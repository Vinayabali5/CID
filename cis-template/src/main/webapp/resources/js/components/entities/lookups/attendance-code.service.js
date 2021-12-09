/**
 * This is the factory definition for the AttendanceCode Data Service. This defines how to handle data about AttendanceCode objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('AttendanceCodeService', ['ui-notification'])
        .factory('AttendanceCode', attendanceCodeFactory);

    attendanceCodeFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function attendanceCodeFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/attendanceCodes/';

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
         * This method is used to retrieve all the AttendanceCode from the API collection.
         *
         * @return {AttendanceCode} An array of AttendanceCode objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('attendance-codes-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }


        /**
         * This method is used to retrieve an instance of a AttendanceCode from the API collection.
         * @param  {int} id of the AttendanceCode object that is to be retrieved.
         * @return {AttendanceCode} An AttendanceCode object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('attendance-code-loaded', response.data);
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
         * This method is used to create a new instance of an AttendanceCode object in the database by POSTing the
         * required data to the API.
         *
         * @param  {AttendanceCode} attendanceCode An AttendanceCode object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no AttendanceCode data is provided then the method returns null.
         */
        function create(attendanceCode, callback) {
            var deferred = $q.defer();
            if (attendanceCode != undefined && attendanceCode != null) {
                $http.post(url, attendanceCode).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('attendance-code-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No AttendanceCode ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing AttendanceCode object.
         *
         * @param  {AttendanceCode} attendanceCode An AttendanceCode object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no AttendanceCode data is provided then the method returns null.
         */
        function save(attendanceCode, callback) {
            var deferred = $q.defer();
            $http.put(url + attendanceCode.id, attendanceCode).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('attendance-code-saved', response.data);
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
