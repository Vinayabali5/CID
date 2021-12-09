/**
 * This is the factory definition for the RoomType Data Service. This defines how to handle data about RoomType objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('RoomTypeService', ['cid.app.constants', 'ui-notification'])
        .factory('RoomType', roomTypeFactory);

    roomTypeFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function roomTypeFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/roomTypes/';

        var factory = {
            query: getAll,
            get: getById,
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the RoomType from the API collection.
         *
         * @return {RoomType} An array of RoomType objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('room-types-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a RoomType from the API collection.
         * @param  {int} id of the RoomType object that is to be retrieved.
         * @return {RoomType} An RoomType object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('room-type-loaded', response.data);
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
