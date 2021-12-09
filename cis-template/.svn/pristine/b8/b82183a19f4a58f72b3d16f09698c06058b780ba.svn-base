/**
 * This is the factory definition for the Destination Data Service. This defines how to handle data about Destination objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('DestinationService', ['ui-notification'])
        .factory('Destination', destinationFactory);

    destinationFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function destinationFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/destinations/';
        // Public Interface
        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;

        //Private Interface
        /**
         * This method is used to retrieve all the Destination from the API collection.
         *
         * @return {Destination} An array of Destination objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('destination-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }
        /**
         * This method is used to retrieve an instance of a Destination from the API collection.
         * @param  {int} id of the Destination object that is to be retrieved.
         * @return {Destination} An Destination object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('academic-years-loaded', response.data);
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
         * This method is used to create a new instance of an Destination object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Destination} destination An Destination object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Destination data is provided then the method returns null.
         */
        function create(destination, callback) {
            var deferred = $q.defer();
            if (destination != undefined && destination != null) {
                $http.post(url, destination).then(function(response) {
                    $rootScope.$emit('destination-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Destination ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing Destination object.
         *
         * @param  {Destination} destination An Destination object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Destination data is provided then the method returns null.
         */
        function save(destination, callback) {
            var deferred = $q.defer();
            if (destination && destination.id) {
                $http.put(url + destination.id, destination).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('destination-saved', response.data);
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
