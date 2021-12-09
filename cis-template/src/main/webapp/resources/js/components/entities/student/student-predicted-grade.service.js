/**
 * This is the factory definition for the StudentPredictedGrade Data Service. This defines how to handle data about StudentPredictedGrade objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('StudentPredictedGradeService', ['cid.app.constants', 'ui-notification'])
        .factory('StudentPredictedGrade', studentPredictedGradeFactory);

    studentPredictedGradeFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function studentPredictedGradeFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/';
        //Public Interface
        var factory = {
            query: getAll,
            get: getById,
            entryQualification: getEntryQualification,
            delete: deleteById,
            create: create,
            save: save
        };
        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the StudentPredictedGrade from the API collection.
         *
         * @return {StudentPredictedGrade} An array of StudentPredictedGrade objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('student-predicted-grades-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an collection of StudentPredictedGrade entities from the API collection.
         * @param  {int} studentPredictedGradeId of the StudentPredictedGrade object that is to be retrieved.
         * @return {StudentPredictedGrade} An StudentPredictedGrade object as identified by the id.
         */
        function getById(studentId) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.get(url + 'students/' + studentId + '/predictedGrades').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-predicted-grades-loaded', response.data);
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
         * This method is used to retrieve an instance of a StudentPredictedGrade from the API collection.
         * @param  {int} studentPredictedGradeId of the StudentPredictedGrade object that is to be retrieved.
         * @return {StudentPredictedGrade} An StudentPredictedGrade object as identified by the id.
         */
        function getEntryQualification(studentPredictedGradeId) {
            var deferred = $q.defer();
            $http.get(url + 'student-predicted-grades/' + studentPredictedGradeId).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('student-predicted-grades-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to delete an instance of a StudentPredictedGrade from the API collection.
         * @param  {int} studentPredictedGradeId of the StudentPredictedGrade object that is to be retrieved.
         * @return {StudentPredictedGrade} An StudentPredictedGrade object as identified by the studentPredictedGradeId.
         */
        function deleteById(studentPredictedGradeId) {
            var deferred = $q.defer();
            if (studentPredictedGradeId) {
                $http.delete(url + 'student-predicted-grades/' + studentPredictedGradeId).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-predicted-grades-deleted', response.data);
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
         * This method is used to create a new instance of an StudentPredictedGrade object in the database by POSTing the
         * required data to the API.
         *
         * @param  {StudentPredictedGrade} studentPredictedGrade An StudentPredictedGrade object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no studentPredictedGrade data is provided then the method returns null.
         */
        function create(studentPredictedGrade, callback) {
            var deferred = $q.defer();
            if (studentPredictedGrade) {
                $http.post(url + 'student-predicted-grades', studentPredictedGrade).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-predicted-grades-created', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No studentPredictedGrade ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing StudentPredictedGrade object.
         *
         * @param  {StudentPredictedGrade} studentPredictedGrade An StudentPredictedGrade object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no studentPredictedGrade data is provided then the method returns null.
         */
        function save(studentPredictedGrade, callback) {
            var deferred = $q.defer();
            if (studentPredictedGrade && studentPredictedGrade.studentPredictedGradeId) {
                $http.put(url + 'student-predicted-grades/' + studentPredictedGrade.studentPredictedGradeId, studentPredictedGrade).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-predicted-grades-saved', response.data);
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
