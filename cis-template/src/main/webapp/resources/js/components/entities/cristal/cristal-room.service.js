/**
 * This is the factory definition for the CristalRoom Data Service. This defines how to handle data about CristalRoom objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('CristalRoomService', ['cid.app.constants', 'ui-notification'])
        .factory('CristalRoom', cristalRoomFactory);

    cristalRoomFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function cristalRoomFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/cristal-rooms/';

        var factory = {
            query: getAll,
            get: getByRoomId,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the CristalRoom from the API collection.
         *
         * @return {CristalRoom} An array of CristalRoom objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('cristal-rooms-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a CristalRoom from the API collection.
         * @param  {int} id of the CristalRoom object that is to be retrieved.
         * @return {CristalRoom} An CristalRoom object as identified by the id.
         */
        function getByRoomId(roomId) {
            var deferred = $q.defer();
            if (roomId != undefined && roomId != null) {
                $http.get(url + roomId).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('cristal-room-loaded', response.data);
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
         * This method is used to create a new instance of an CristalRoom object in the database by POSTing the
         * required data to the API.
         *
         * @param  {CristalRoom} cristalRoom An CristalRoom object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no CristalRoom data is provided then the method returns null.
         */
        function create(cristalRoom, callback) {
            var deferred = $q.defer();
            if (cristalRoom != undefined && cristalRoom != null) {
                $http.post(url, cristalRoom).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('cristal-room-created', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No CristalRoom ID Supplied"
                });
            }
            return deferred.promise;
        }
        /**
         * This method is used to save changes to an existing CristalRoom object.
         *
         * @param  {CristalRoom} cristalRoom An CristalRoom object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no CristalRoom data is provided then the method returns null.
         */
        function save(cristalRoom, callback) {
            var deferred = $q.defer();
            if (cristalRoom && cristalRoom.roomId) {
                $http.put(url + cristalRoom.roomId, cristalRoom).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('cristal-room-saved', response.data);
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
