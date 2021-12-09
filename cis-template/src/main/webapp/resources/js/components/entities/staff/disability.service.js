/**
 * This is the factory definition for the Disability Data Service. This defines how to handle data about Disability objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('DisabilityService', ['ui-notification'])
        .factory('Disability', disabilityFactory);

    disabilityFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function disabilityFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/disabilities/';
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
         * This method is used to retrieve all the Disability from the API collection.
         *
         * @return {Disability} An array of Disability objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('disability-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a Disability from the API collection.
         * @param  {int} id of the Disability object that is to be retrieved.
         * @return {Disability} An Disability object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('disability-loaded', response.data);
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
         * This method is used to create a new instance of an Disability object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Disability} disability An Disability object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Disability data is provided then the method returns null.
         */
        function create(disability, callback) {
            var deferred = $q.defer();
            if (disability != undefined && disability != null) {
                $http.post(url, disability).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('disability-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Disability ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing Disability object.
         *
         * @param  {Disability} disability An Disability object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Disability data is provided then the method returns null.
         */
        function save(disability, callback) {
            var deferred = $q.defer();
            if (disability && disability.id) {
                $http.put(url + disability.id, disability).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('disability-saved', response.data);
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
