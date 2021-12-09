/**
 * This is the factory definition for the PriorAttainment Data Service. This defines how to handle data about PriorAttainment objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('PriorAttainmentService', ['cid.app.constants', 'ui-notification'])
        .factory('PriorAttainment', priorAttainmentFactory);

    priorAttainmentFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function priorAttainmentFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/priorAttainments/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the PriorAttainment from the API collection.
         *
         * @return {PriorAttainment} An array of PriorAttainment objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('prior-attainments-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }
        /**
         * This method is used to retrieve an instance of a PriorAttainment from the API collection.
         * @param  {int} id of the PriorAttainment object that is to be retrieved.
         * @return {PriorAttainment} An PriorAttainment object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('prior-attainment-loaded', response.data);
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
         * This method is used to create a new instance of an PriorAttainment object in the database by POSTing the
         * required data to the API.
         *
         * @param  {PriorAttainment} priorAttainment An PriorAttainment object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no PriorAttainment data is provided then the method returns null.
         */
        function create(priorAttainment, callback) {
            var deferred = $q.defer();
            if (priorAttainment != undefined && priorAttainment != null) {
                $http.post(url, priorAttainment).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('prior-attainment-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No PriorAttainment ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing PriorAttainment object.
         *
         * @param  {PriorAttainment} priorAttainment An PriorAttainment object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no PriorAttainment data is provided then the method returns null.
         */
        function save(priorAttainment, callback) {
            var deferred = $q.defer();
            if (priorAttainment && priorAttainment.id) {
                $http.put(url + priorAttainment.id, priorAttainment).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('prior-attainment-saved', response.data);
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
