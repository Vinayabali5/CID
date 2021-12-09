/**
 * This is the factory definition for the Timetable Data Service. This defines how to handle data about Timetable objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('TimetableService', ['cid.app.constants', 'ui-notification'])
        .factory('Timetable', timetableFactory);

    timetableFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function timetableFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/timetables/';
        var factory = {

            query: getAll,
            get: getById,
            create: create,
            delete: deleteById,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the Timetable from the API collection.
         *
         * @return {Timetable} An array of Timetable objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('timetable-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a Timetable from the API collection.
         * @param  {int} id of the Timetable object that is to be retrieved.
         * @return {Timetable} An Timetable object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('timetable-loaded', response.data);
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
         * This method is used to create a new instance of an Timetable object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Timetable} timetable An Timetable object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no timetable data is provided then the method returns null.
         */
        function create(timetable, callback) {
            var deferred = $q.defer();
            if (timetable != undefined && timetable != null) {
                $http.post(url, timetable).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('timetable-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Timetable ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing Timetable object.
         *
         * @param  {Timetable} timetable An Timetable object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no timetable data is provided then the method returns null.
         */
        function save(timetable, callback) {
            var deferred = $q.defer();
            if (timetable && timetable.id) {
                $http.put(url + timetable.id, timetable).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('timetable-saved', response.data);
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

        /**
         * This method is used to delete an instance of a Timetable from the API collection.
         * @param  {int} timetableId of the Timetable object that is to be retrieved.
         * @return {Timetable} An Timetable object as identified by the timetableId.
         */
        function deleteById(id) {
            var deferred = $q.defer();
            if (id) {
                $http.delete(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('timetable-deleted', response.data);
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
    }
})();
