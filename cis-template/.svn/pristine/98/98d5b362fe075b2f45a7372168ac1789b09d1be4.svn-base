/**
 * This is the factory definition for the StudentInterimReport Data Service. This defines how to handle data about StudentInterimReport objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('StudentInterimReportService', ['cid.app.constants', 'ui-notification'])
        .factory('StudentInterimReport', studentInterimReportFactory);

    studentInterimReportFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function studentInterimReportFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/';

        var factory = {
            query: getAll,
            get: getById,
            getByStudentId: getByStudentId,
            getByCourseGroupIdAndInterimReportId: getByCourseGroupIdAndInterimReportId,
            save: save,
            create: create
        };

        return factory;
        /**
         * This method is used to retrieve all the StudentInterimReport from the API collection.
         *
         * @return {StudentInterimReport} An array of StudentInterimReport objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('student.interim-reports.loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve a collection of a StudentInterimReport of a Student from the API collection.
         * @param  {int} studentId of the StudentInterimReport object that is to be retrieved.
         * @return {StudentInterimReport} An An array of StudentInterimReports object as identified by the studentId.
         */
        function getByStudentId(studentId) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.get(url + studentId + '/interimReports').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student.interim-reports.loaded', response.data);
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
         * This method is used to retrieve a collection of a StudentInterimReport of a courseGroup from the API collection.
         * @param  {int} courseGroupId of the StudentInterimReport object that is to be retrieved.
         * @return {StudentInterimReport} An An array of StudentInterimReports object as identified by the studentId.
         */
        function getByCourseGroupIdAndInterimReportId(interimReportId, courseGroupId) {
            var deferred = $q.defer();
            if (courseGroupId != undefined && interimReportId != null) {
                $http.get(url + 'student-interim-report/' + interimReportId + '/courseGroup/' + courseGroupId).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student.interim-reports.loaded', response.data);
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
         * This method is used to retrieve a collection of a StudentInterimReport of a Student from the API collection.
         * @param  {int} studentId of the StudentInterimReport object that is to be retrieved.
         * @return {StudentInterimReport} An An array of StudentInterimReports object as identified by the studentId.
         */
        function getById(studentInterimReportId) {
            var deferred = $q.defer();
            if (studentInterimReportId != undefined && studentInterimReportId != null) {
                $http.get(url + 'student-interim-report/' + studentInterimReportId).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student.interim-reports.loaded', response.data);
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
         * This method is used to save changes to an existing StudentInterimReport object.
         *
         * @param  {StudentInterimReport} studentInterimReport An StudentInterimReport object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no studentInterimReport data is provided then the method returns null.
         */
        function save(studentInterimReport, callback) {
            var deferred = $q.defer();
            if (studentInterimReport && studentInterimReport.id) {
                $http.put(url + 'student-interim-report/' + studentInterimReport.id, studentInterimReport).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-interim-reports-saved', response.data);
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

        function create(studentInterimReport, callback) {
            var deferred = $q.defer();
            if (studentInterimReport != undefined && studentInterimReport != null) {
                $http.post(url + 'student-interim-report/', studentInterimReport).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-interim-reports-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No MasterReview ID Supplied"
                });
            }
            return deferred.promise;
        }
    }

})();
