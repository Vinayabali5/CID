/**
 * This is the factory definition for the IdentificationViolation Data Service. This defines how to handle data about IdentificationViolation objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */


(function() {
    'use strict';

    angular
        .module('IdentificationViolationService', ['ui-notification'])
        .factory('IdentificationViolation', identificationViolationFactory);

    identificationViolationFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function identificationViolationFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/id-violations/';

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
         * This method is used to retrieve all the IdentificationViolation from the API collection.
         *
         * @return {IdentificationViolation} An array of IdentificationViolation objects.
         */
        function getAll(options) {
            var reqParams = {};
            var deferred = $q.defer();
            if (options) {
                if (options.page) {
                    reqParams.page = options.page;
                }
                if (options.size) {
                    reqParams.size = options.size;
                }
            }
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('identification-violations-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }


        /**
         * This method is used to retrieve an instance of a IdentificationViolation from the API collection.
         * @param  {int} id of the IdentificationViolation object that is to be retrieved.
         * @return {IdentificationViolation} An IdentificationViolation object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('identification-violation-loaded', response.data);
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
         * This method is used to create a new instance of an IdentificationViolation object in the database by POSTing the
         * required data to the API.
         *
         * @param  {IdentificationViolation} identificationViolation An IdentificationViolation object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no identificationViolation data is provided then the method returns null.
         */
        function create(identificationViolation, callback) {
            var deferred = $q.defer();
            if (identificationViolation != undefined && identificationViolation != null) {
                $http.post(url, identificationViolation).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('identification-violation-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No IdentificationViolation ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to delete an instance of a IdentificationViolation from the API collection.
         * @param  {int} id of the IdentificationViolation object that is to be deleted.
         * @return {IdentificationViolation} An IdentificationViolation object as identified by the id.
         */
        function deleteById(id) {
            var deferred = $q.defer();
            if (id) {
                $http.delete(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('identification-violation-deleted', response.data);
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
         * This method is used to save changes to an existing IdentificationViolation object.
         *
         * @param  {IdentificationViolation} identificationViolation An IdentificationViolation object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no identificationViolation data is provided then the method returns null.
         */
        function save(identificationViolation, callback) {
            var deferred = $q.defer();
            if (identificationViolation && identificationViolation.id) {
                $http.put(url + identificationViolation.id, identificationViolation).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('identification-violation-saved', response.data);
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
