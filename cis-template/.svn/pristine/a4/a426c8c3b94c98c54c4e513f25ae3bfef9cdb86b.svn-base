/**
 * This is the factory definition for the AttendanceMonitoring Data Service. This defines how to handle data about AttendanceMonitoring objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */


(function() {
    'use strict';

    angular
        .module('AttendanceMonitoringService', ['ui-notification'])
        .factory('AttendanceMonitoring', attendanceMonitoringFactory);

    attendanceMonitoringFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function attendanceMonitoringFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/attendanceMonitorings/';

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
         * This method is used to retrieve all the AttendanceMonitoring from the API collection.
         *
         * @return {AttendanceMonitoring} An array of AttendanceMonitoring objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('attendance-monitorings-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a AttendanceMonitoring from the API collection.
         * @param  {int} id of the AttendanceMonitoring object that is to be retrieved.
         * @return {AttendanceMonitoring} An AttendanceMonitoring object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('attendance-monitoring-loaded', response.data);
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
         * This method is used to create a new instance of an AttendanceMonitoring object in the database by POSTing the
         * required data to the API.
         *
         * @param  {AttendanceMonitoring} attendanceMonitoring An AttendanceMonitoring object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no AttendanceMonitoring data is provided then the method returns null.
         */
        function create(attendanceMonitoring, callback) {
            var deferred = $q.defer();
            if (attendanceMonitoring != undefined && attendanceMonitoring != null) {
                $http.post(url, attendanceMonitoring).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('attendance-monitoring-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No AttendanceMonitoring ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing AttendanceMonitoring object.
         *
         * @param  {AttendanceMonitoring} attendanceMonitoring An AttendanceMonitoring object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no AttendanceMonitoring data is provided then the method returns null.
         */
        function save(attendanceMonitoring, callback) {
            var deferred = $q.defer();
            $http.put(url + attendanceMonitoring.id, attendanceMonitoring).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('attendance-monitoring-saved', response.data);
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
