(function() {
    angular
        .module('cid.user-settings', [
            'ngCookies',
            'cid.service.logger',
            'cid.app.constants',
        ])
        .factory('USER', UserSettingsFactory);

    UserSettingsFactory.$inject = ['$cookies', 'Logger', 'GLOBAL'];

    /**
     * The factory service is used to save and load user based settings within the CID application.
     * 
     * @param {*} $cookies The default AngularJS Cookies Provider.
     * @param {*} Logger The Logger factory for logging purposes.
     * @param {*} GLOBAL The GLOBAL variables service. 
     */
    function UserSettingsFactory($cookies, Logger, GLOBAL) {
        var DEBUG = GLOBAL.DEBUG;
        var COOKIE_NAME = 'cid.user-settings';
        var expiryDate = new Date();
        expiryDate.setDate(expiryDate.getDate() + 7);
        var settings = {
            debugInfoEnabled: false,
            displaySideBar: false
        };
        var options = {
            expires: expiryDate,
            //secure: true,
            samesite: 'strict'
        };

        // Public Interface

        var service = {
            load: load,
            save: save,
            clear: clear,
            refresh: refresh,
            setSetting: setSetting,
            getSetting: getSetting,
        };

        return service;

        // Private Interface

        /**
         * This method is used to load the user setting from the cookie. 
         */
        function load() {
            Logger.debug('II Loading User Settings');
            var loadedSettings = $cookies.getObject(COOKIE_NAME);
            if (loadedSettings !== undefined) {
                settings = $cookies.getObject(COOKIE_NAME);
            }
            return settings;
        }

        /**
         * This method is used to save the user settings into the cookie. 
         */
        function save() {
            Logger.debug('II Saving User Settings');
            $cookies.putObject(COOKIE_NAME, settings, options);
        }

        /**
         * This method is used to preform a refresh of the user settings. 
         */
        function refresh() {
            load();
            save();
        }

        /**
         * This method is used to clear the user settings from memory
         */
        function clear() {
            Logger.debug('II Clearing User Settings');
            settings = {};
            $cookies.remove(COOKIE_NAME);
        }

        /**
         * This method is used to add a set a new or existing user setting. 
         * 
         * @param {} key The name of the setting to save.
         * @param {} value The value of the setting to save.
         */
        function setSetting(key, value) {
            Logger.debug("II Setting '" + key + "' has being set to: " + value);
            if (!settings) settings = {};
            settings[key] = value;
            save();
        }

        /**
         * This method is used to retrieve an existing user setting. 
         * 
         * @param {} key The name of the setting to retrieve.
         */
        function getSetting(key) {
            Logger.debug("II Setting '" + key + "' being retrieved with value: '" + settings[key] + "'");
            return settings[key];
        }

    }

})();
