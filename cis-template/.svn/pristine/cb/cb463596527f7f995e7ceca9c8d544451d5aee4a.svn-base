/**
 * This is the factory definition for the Level Data Service. This defines how to handle data about Level objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('LevelService', ['cid.app.constants', 'ui-notification'])
        .factory('Level', levelFactory);

    levelFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function levelFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/levels/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the Level from the API collection.
         *
         * @return {Level} An array of Level objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('levels-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a Level from the API collection.
         * @param  {int} id of the Level object that is to be retrieved.
         * @return {Level} An Level object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('level-loaded', response.data);
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
         * This method is used to create a new instance of an Level object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Level} level An Level object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Level data is provided then the method returns null.
         */
        function create(level, callback) {
            var deferred = $q.defer();
            if (level != undefined && level != null) {
                $http.post(url, level).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('level-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Level ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing Level object.
         *
         * @param  {Level} level An Level object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Level data is provided then the method returns null.
         */
        function save(level, callback) {
            var deferred = $q.defer();
            if (level && level.id) {
                $http.put(url + level.id, level).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('level-saved', response.data);
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
