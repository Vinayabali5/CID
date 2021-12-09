/**
 * This is the factory definition for the PunctualityMonitoring Data Service. This defines how to handle data about PunctualityMonitoring objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('PunctualityMonitoringService', ['cid.app.constants', 'ui-notification'])
        .factory('PunctualityMonitoring', punctualityMonitoringFactory);

    punctualityMonitoringFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function punctualityMonitoringFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/punctualityMonitorings/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the PunctualityMonitoring from the API collection.
         *
         * @return {PunctualityMonitoring} An array of PunctualityMonitoring objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('punctuality-monitorings-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a PunctualityMonitoring from the API collection.
         * @param  {int} id of the PunctualityMonitoring object that is to be retrieved.
         * @return {PunctualityMonitoring} An PunctualityMonitoring object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('punctuality-monitoring-loaded', response.data);
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
         * This method is used to create a new instance of an PunctualityMonitoring object in the database by POSTing the
         * required data to the API.
         *
         * @param  {PunctualityMonitoring} punctualityMonitoring An PunctualityMonitoring object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no PunctualityMonitoring data is provided then the method returns null.
         */
        function create(punctualityMonitoring, callback) {
            var deferred = $q.defer();
            if (punctualityMonitoring) {
                $http.post(url, punctualityMonitoring).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('punctuality-monitoring-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No PunctualityMonitoring ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing PunctualityMonitoring object.
         *
         * @param  {PunctualityMonitoring} punctualityMonitoring An PunctualityMonitoring object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no PunctualityMonitoring data is provided then the method returns null.
         */
        function save(punctualityMonitoring, callback) {
            var deferred = $q.defer();
            if (punctualityMonitoring && punctualityMonitoring.id) {
                $http.put(url + punctualityMonitoring.id, punctualityMonitoring).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('punctuality-monitoring-saved', response.data);
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
