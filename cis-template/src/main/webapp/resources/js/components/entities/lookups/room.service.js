/**
 * This is the factory definition for the Room Data Service. This defines how to handle data about Room objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('RoomService', ['cid.app.constants', 'ui-notification'])
        .factory('Room', roomFactory);

    roomFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function roomFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/rooms/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the Room from the API collection.
         *
         * @return {Room} An array of Room objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('rooms-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a Room from the API collection.
         * @param  {int} id of the Room object that is to be retrieved.
         * @return {Room} An Room object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('room-loaded', response.data);
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
         * This method is used to create a new instance of an Room object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Room} room An Room object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Room data is provided then the method returns null.
         */
        function create(room, callback) {
            var deferred = $q.defer();
            if (room != undefined && room != null) {
                $http.post(url, room).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('room-created', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Room ID Supplied"
                });
            }
            return deferred.promise;
        }
        /**
         * This method is used to save changes to an existing Room object.
         *
         * @param  {Room} room An Room object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Room data is provided then the method returns null.
         */
        function save(room, callback) {
            var deferred = $q.defer();
            if (room && room.id) {
                $http.put(url + room.id, room).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('room-saved', response.data);
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
