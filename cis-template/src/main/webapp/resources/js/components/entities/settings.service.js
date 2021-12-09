/**
 * This is the factory definition for the settingsService Data Service. This defines how to handle data about settingsService objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('SettingsService', ['cid.app.constants', 'ui-notification'])
        .factory('Settings', settingsFactory);

    settingsFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function settingsFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/settings/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;

        //Private Interface
        /**
         * This method is used to retrieve all the settingsService from the API collection.       *
         * @return {settingsService} An array of settingsService objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('settings-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a settingsService from the API collection.
         * @param  {int} id of the settingsService object that is to be retrieved.
         * @return {settingsService} An settingsService object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('setting-loaded', response.data);
                }, function(response) {
                    deferred.reject(response);
                });
            } else {
                deferred.reject({
                    message: "No ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to create a new instance of an settingsService object in the database by POSTing the
         * required data to the API.
         *
         * @param  {settingsService} settings An settingsService object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no settingsService data is provided then the method returns null.
         */
        function create(settings, callback) {
            var deferred = $q.defer();
            if (settings != undefined && settings != null) {
                $http.post(url, settings).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('settings-created', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Settings ID Supplied"
                });
            }
            return deferred.promise;
        }
        /**
         * This method is used to save changes to an existing settingsService object.
         *
         * @param  {settingsService} settings An settingsService object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no settingsService data is provided then the method returns null.
         */
        function save(settings, callback) {
            var deferred = $q.defer();
            if (settings && settings.id) {
                $http.put(url + settings.id, settings).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('settings-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            }
            return deferred.promise;
        }
    }

})();
