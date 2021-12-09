/**
 * This is the Authentication Module
 *
 * Applied Styles: [Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Factory and Constants
 */

(function() {

    angular
        .module('cid.core.authentication', [
            'ngCookies',
            'cid.app.constants',
            'cid.service.logger',
            'Base64EncoderService'
        ])
        .constant('AUTH_EVENTS', {
            loginSuccess: 'login-success',
            loginFailed: 'login-failed',
            logoutSuccess: 'logout-success',
            sessionTimeout: 'session-timeout',
            notAuthenticated: 'not-authenticated',
            notAuthorized: 'not-authorized'
        })
        .factory('Auth', AuthenticationService);

    AuthenticationService.$inject = ['Logger', '$http', '$rootScope', '$state', '$cookies', 'Base64', 'GLOBAL', 'AUTH_EVENTS'];

    function AuthenticationService(Logger, $http, $rootScope, $state, $cookies, Base64, GLOBAL, AUTH_EVENTS) {
        // Public Interface
        var currentUser;
        var DEBUG = GLOBAL.DEBUG;
        var STORAGE_KEY = 'auth';
        var COOKIE_NAME = 'cid.current-user';

        $rootScope.hasRole = hasRole;
        $rootScope.hasAnyRole = hasAnyRole;

        var factory = {
            login: login,
            logout: logout,
            storeCredentials: storeCredentials,
            isAuthenticated: isAuthenticated,
            isAuthorised: isAuthorised,
            getUser: getUser,
            clearCredentials: clearCredentials,
            refreshUser: refreshCredentials,
            hasRole: hasRole,
            hasAnyRole: hasAnyRole,
        };

        return factory;


        // Private Interface

        /**
         * The authenticate method is used to submit a HTTP request to the API server to retrieve check the user credentials
         *
         * @param  {String}   basicAuth A basic authentication token to be used for the authentication request
         * @param  {Function} callback  A callback function that is called after the authentication request
         */
        function authenticate(basicAuth, callback) {
            var req = {
                method: 'GET',
                url: GLOBAL.USER,
                headers: {
                    'Authorization': "Basic " + basicAuth
                }
            };

            $http(req).then(loginSuccessful, loginFailure).catch(angular.noop);

            function loginSuccessful(response) {
                storeCredentials(basicAuth, response.data);
                $rootScope.$emit(AUTH_EVENTS.loginSuccess, response.data);
                if (callback !== undefined && typeof callback === 'function') {
                    callback(response);
                }
            }

            function loginFailure(response) {
                $rootScope.$emit(AUTH_EVENTS.loginFailed, null);
                callback(response);
                if (callback !== undefined && typeof callback === 'function') {
                    callback(response);
                }
            }
        }

        /**
         * The login method is used to create a basic auth token from a credentials object then pass this to the authenticate
         * method
         *
         * @param  {Object}   credentials A credentials object should contain a username and password.
         * @param  {Function} callback    A callback function to be called after the authentication has been attempted.
         */
        function login(credentials, callback) {
            var basicAuth = credentials ? Base64.encode(credentials.username + ":" + credentials.password) : "";
            authenticate(basicAuth, callback);
        }

        /**
         * This method is used to log the current user out of the system. This is achieved by clearing any stored
         * credentials from memory and clearing any authentication cookies.
         *
         * @return {void}
         */
        function logout() {
            clearCredentials();
        }

        /**
         * This methods is used to retrieve the current user and return it to be used.
         *
         * @return {Object} the current user data
         */
        function getUser() {
            loadCredentials();
            return currentUser;
        }

        /**
         * This method is used to set the authentication headers for basic authentication using the http service.
         *
         * @param {string} authdata The authentication token to use for setting the authentication header. If undefined
         *                          or null the authentication header is removed.
         */
        function setAuthHeader(authdata) {
            if (authdata !== undefined || authdata !== null) {
                $http.defaults.headers.common.Authorization = 'Basic ' + authdata;
            } else {
                delete $http.defaults.headers.common.Authorization;
            }

        }

        /**
         * This method is used to store the credentials and current user data into the local cookie. After storing these details
         * the authentication header is set.
         *
         * @param  {Object|string}  credentials If an object is supplied with a username and password these are used to create the authdata,
         *                                      otherwise an authdata string is expected.
         * @param  {Object} user        A user object containing the data for the current user to store
         */
        function storeCredentials(credentials, user) {
            var authdata;
            if (credentials.username !== undefined && credentials.password !== undefined) {
                authdata = Base64.encode(credentials.username + ':' + credentials.password);
            } else {
                authdata = credentials;
            }
            currentUser = user;
            currentUser.authdata = authdata;
            Logger.debug(currentUser);
            setAuthHeader(authdata);
            var expiryDate = new Date();
            expiryDate.setDate(expiryDate.getDate() + 7);
            var options = {
                expires: expiryDate,
                //secure: true,
                samesite: 'strict'
            };
            $cookies.putObject(COOKIE_NAME, currentUser, options);
        }

        /**
         * This method is used to retrieve the crednetials and user data from the local cookie. After retireving these details
         * the authentication header is set.
         *
         */
        function loadCredentials() {
            Logger.debug('II Loading credentials from cookie');
            var cookie = $cookies.getObject(COOKIE_NAME);
            if (cookie !== undefined && cookie.authdata !== undefined) {
                currentUser = cookie;
                setAuthHeader(cookie.authdata);
            } else {
                currentUser = null;
                Logger.debug('WW No Cookie Found or Cookie Data in wrong format');
            }
        }

        /**
         * This method is used to refresh the user details from the API.
         */
        function refreshCredentials() {
            Logger.debug('II Refreshing User Credentials');
            if (currentUser !== null && currentUser !== undefined) {
                $http.get(GLOBAL.USER).then(function(response) {
                    storeCredentials(currentUser.authdata, response.data);
                }).catch(function(response) {
                    if (response.status == 401) {
                        clearCredentials();
                    }
                });
            }
        }

        /**
         * This method is used to clear any stored credentials from the local cookie and from memory.
         */
        function clearCredentials() {
            Logger.debug('Clearing User Credentials');
            $cookies.remove(COOKIE_NAME);
            $http.defaults.headers.common.Authorization = 'Basic';
            //delete $http.defaults.headers.common.Authorization;
            currentUser = null;
        }

        /**
         * This method is used to check the user is currently authenticated.
         *
         * @return {Boolean} True if authenticated, false if not.
         */
        function isAuthenticated() {
            if (currentUser === null || currentUser === undefined) {
                loadCredentials();
            }
            if (currentUser !== null && currentUser !== undefined) {
                if (DEBUG) {
                    Logger.debug('II User Authenticated');
                }
                return true;
            } else {
                Logger.debug('II User Unauthenticated');
                $rootScope.$emit(AUTH_EVENTS.notAuthenticated, null);
                return false;
            }
        }

        /**
         * This method is used to check if the current user has the specified role(s)
         *
         * @param  {Array|String}  roles an array of strings or a single string that represent the roles to check
         *                               if the user has.
         * @return {Boolean}       True if the user has any of the supplied roles
         */
        function isAuthorised(roles) {
            if (roles !== null && roles !== undefined && currentUser !== null && currentUser !== undefined) {
                Logger.debug('II Checking if user is authorised');
                if (typeof roles === "string") {
                    // var userHasRole = ($.inArray(roles, currentUser.roles) > -1);
                    var userHasRole = hasRole(roles);
                    return userHasRole;
                }
                if (roles instanceof Array) {
                    return hasAnyRole(roles);
                }
                $rootScope.$emit(AUTH_EVENTS.notAuthorized, null);
                return false;
            } else {
                if (!roles) {
                    Logger.debug('II No roles specified');
                    return true;
                }
                Logger.debug('WW Not Authorised: No Roles defined or No Current User loaded');
                $rootScope.$emit(AUTH_EVENTS.notAuthorized, null);
                return false;
            }
        }

        /**
         * This method is used to check if the currentUser variable has the specified role.
         *
         * @param  {String}  role A string containing the role to search
         * @return {Boolean}      True if the role was found. False if not found or roles array is not defined.
         */
        function hasRole(role) {
            if (currentUser !== null && currentUser !== undefined) {
                var _user = currentUser;
                return _user.roles && _user.roles.indexOf(role) !== -1;
            }
            return false;
        }

        /**
         * This method is used to check if the currentUser variable has any of the roles specified
         * in the roles array passed.
         *
         * @param  {Array}  roles  An array of strings with the role names.
         * @return {Boolean}       True if any of the roles were found. False if not found or roles array is
         *                              not defined.
         */
        function hasAnyRole(roles) {
            if (roles.length === 0) {
                return true;
            }
            for (var i = 0; i < roles.length; i++) {
                if (hasRole(roles[i])) {
                    return true;
                }
            }
            return false;
        }

    }

})();
