/**
 * This is the factory definition for the SexualOrientation Data Service. This defines how to handle data about SexualOrientation objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('SexualOrientationService', ['ui-notification'])
        .factory('SexualOrientation', sexualOrientationFactory);

    sexualOrientationFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function sexualOrientationFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/sexual-orientations/';
        // Public Interface
        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the SexualOrientation from the API collection.
         *
         * @return {SexualOrientation} An array of SexualOrientation objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('sexualOrientation-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a SexualOrientation from the API collection.
         * @param  {int} id of the SexualOrientation object that is to be retrieved.
         * @return {SexualOrientation} An SexualOrientation object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('sexualOrientation-loaded', response.data);
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
         * This method is used to create a new instance of an SexualOrientation object in the database by POSTing the
         * required data to the API.
         *
         * @param  {SexualOrientation} sexualOrientation An SexualOrientation object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no SexualOrientation data is provided then the method returns null.
         */
        function create(sexualOrientation, callback) {
            var deferred = $q.defer();
            if (sexualOrientation != undefined && sexualOrientation != null) {
                $http.post(url, sexualOrientation).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('sexualOrientation-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No SexualOrientation ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing SexualOrientation object.
         *
         * @param  {SexualOrientation} sexualOrientation An SexualOrientation object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no SexualOrientation data is provided then the method returns null.
         */
        function save(sexualOrientation, callback) {
            var deferred = $q.defer();
            if (sexualOrientation && sexualOrientation.id) {
                $http.put(url + sexualOrientation.id, sexualOrientation).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('sexualOrientation-saved', response.data);
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
