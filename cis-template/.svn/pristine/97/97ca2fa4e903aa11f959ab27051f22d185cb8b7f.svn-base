/**
 * This is the factory definition for the CentralMonitoring Data Service. This defines how to handle data about CentralMonitoring objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('CentralMonitoringService', ['ui-notification'])
        .factory('CentralMonitoring', centralMonitoringFactory);

    centralMonitoringFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function centralMonitoringFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/centralMonitorings/';
        //Public Interface
        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;

        //Private Interface
        /**
         * This method is used to retrieve all the CentralMonitoring from the API collection.
         *
         * @return {CentralMonitoring} An array of CentralMonitoring objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('cebtral-monitorings-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a CentralMonitoring from the API collection.
         * @param  {int} id of the CentralMonitoring object that is to be retrieved.
         * @return {CentralMonitoring} An CentralMonitoring object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('central-monitorings-loaded', response.data);
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
         * This method is used to create a new instance of an CentralMonitoring object in the database by POSTing the
         * required data to the API.
         *
         * @param  {CentralMonitoring} centralMonitoring An CentralMonitoring object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no CentralMonitoring data is provided then the method returns null.
         */
        function create(centralMonitoring, callback) {
            var deferred = $q.defer();
            if (centralMonitoring != undefined && centralMonitoring != null) {
                $http.post(url, centralMonitoring).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('central-monitoring-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No CentralMonitoring ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing CentralMonitoring object.
         *
         * @param  {CentralMonitoring} centralMonitoring An CentralMonitoring object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no CentralMonitoring data is provided then the method returns null.
         */
        function save(centralMonitoring, callback) {
            var deferred = $q.defer();
            $http.put(url + centralMonitoring.id, centralMonitoring).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('central-monitoring-saved', response.data);
                if (callback) {
                    callback();
                }
            }, function(response) {
                deferred.reject(response);
                Notification.error("Error:" + response.data.message);
            });
            return deferred.promise;
        }
    }
})();
