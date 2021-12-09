/**
 * This is the factory definition for the StudentOverallAttendance Data Service. This defines how to handle data about StudentOverallAttendance objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('StudentOverallAttendanceService', ['cid.app.constants', 'ui-notification'])
        .factory('StudentOverallAttendance', studentOverAllAttendanceFactory);

    studentOverAllAttendanceFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function studentOverAllAttendanceFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/students/';
        var factory = {
            query: getAll,
            get: getByStudentId,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the StudentOverallAttendance from the API collection.
         *
         * @return {StudentOverallAttendance} An array of StudentOverallAttendance objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('student-overall-attendance-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a StudentOverallAttendance of a student from the API collection.
         * @param  {int} studentId of the StudentOverallAttendance object that is to be retrieved.
         * @return {StudentOverallAttendance} An StudentOverallAttendance object as identified by the studentId.
         */
        function getByStudentId(studentId) {
            var deferred = $q.defer();
            if (studentId !== undefined && studentId !== null) {
                $http.get(url + studentId + '/attendance').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-overall-attendance-loaded', response.data);
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
         * This method is used to save changes to an existing StudentOverallAttendance object.
         *
         * @param  {StudentOverallAttendance} studentOverallAttendance An StudentOverallAttendance object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no StudentOverallAttendance data is provided then the method returns null.
         */
        function save(studentOverallAttendance, callback) {
            var deferred = $q.defer();
            if (studentOverallAttendance && studentOverallAttendance.studentId) {
                $http.put(url + studentOverallAttendance.studentId + '/attendance', studentOverallAttendance).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-overall-attendance-saved', response.data);
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
