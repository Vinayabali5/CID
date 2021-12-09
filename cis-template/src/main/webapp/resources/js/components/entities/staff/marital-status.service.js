/**
 * This is the factory definition for the MaritalStatus Data Service. This defines how to handle data about MaritalStatus objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('MaritalStatusService', ['ui-notification'])
        .factory('MaritalStatus', maritalStatusFactory);

    maritalStatusFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function maritalStatusFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/marital-statuses/';
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
         * This method is used to retrieve all the MaritalStatus from the API collection.
         *
         * @return {MaritalStatus} An array of MaritalStatus objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('maritalStatus-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a MaritalStatus from the API collection.
         * @param  {int} id of the MaritalStatus object that is to be retrieved.
         * @return {MaritalStatus} An MaritalStatus object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('maritalStatus-loaded', response.data);
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
         * This method is used to create a new instance of an MaritalStatus object in the database by POSTing the
         * required data to the API.
         *
         * @param  {MaritalStatus} maritalStatus An MaritalStatus object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no MaritalStatus data is provided then the method returns null.
         */
        function create(maritalStatus, callback) {
            var deferred = $q.defer();
            if (maritalStatus != undefined && maritalStatus != null) {
                $http.post(url, maritalStatus).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('maritalStatus-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No MaritalStatus ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing MaritalStatus object.
         *
         * @param  {MaritalStatus} maritalStatus An MaritalStatus object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no MaritalStatus data is provided then the method returns null.
         */
        function save(maritalStatus, callback) {
            var deferred = $q.defer();
            if (maritalStatus && maritalStatus.id) {
                $http.put(url + maritalStatus.id, maritalStatus).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('maritalStatus-saved', response.data);
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
