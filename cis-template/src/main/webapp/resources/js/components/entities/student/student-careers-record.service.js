/**
 * This is the factory definition for the StudentCareersRecord Data Service. This defines how to handle data about StudentCareersRecord objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('StudentCareersRecordService', ['cid.app.constants', 'ui-notification'])
        .factory('StudentCareersRecord', studentCareersRecordFactory);

    studentCareersRecordFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function studentCareersRecordFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/';
        //Public Interface
        var factory = {
            query: getAll,
            get: getById,
            getByStudentId: getByStudentId,
            create: create,
            delete: deleteById,
            save: save
        };
        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the StudentCareersRecord from the API collection.
         *
         * @return {StudentCareersRecord} An array of StudentCareersRecord objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url + 'careers-records').then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('student-careers-records-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an collection of StudentCareersRecord entities from the API collection.
         * @param  {int} studentCareersRecordId of the StudentCareersRecord object that is to be retrieved.
         * @return {StudentCareersRecord} An StudentCareersRecord object as identified by the id.
         */
        function getByStudentId(studentId) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.get(url + 'students/' + studentId + '/student-careers-records').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-careers-records-loaded', response.data);
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
         * This method is used to retrieve an instance of a StudentCareersRecord from the API collection.
         * @param  {int} studentCareersRecordId of the StudentCareersRecord object that is to be retrieved.
         * @return {StudentCareersRecord} An StudentCareersRecord object as identified by the id.
         */
        function getById(studentCareersRecordId) {
            var deferred = $q.defer();
            $http.get(url + 'student-careers-records/' + studentCareersRecordId).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('student-careers-records-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to create a new instance of an StudentCareersRecord object in the database by POSTing the
         * required data to the API.
         *
         * @param  {StudentCareersRecord} studentCareersRecord An StudentCareersRecord object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no studentCareersRecord data is provided then the method returns null.
         */
        function create(studentCareersRecord, callback) {
            var deferred = $q.defer();
            if (studentCareersRecord) {
                $http.post(url + 'student-careers-records', studentCareersRecord).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('careers-record-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No studentCareersRecord ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to delete an instance of a studentCareersRecord from the API collection.
         * @param  {int} studentCareersRecordId of the studentCareersRecord object that is to be retrieved.
         * @return {studentCareersRecord} An studentCareersRecord object as identified by the studentCareersRecordId.
         */
        function deleteById(studentCareersRecordId) {
            var deferred = $q.defer();
            if (studentCareersRecordId) {
                $http.delete(url + 'student-careers-records/' + studentCareersRecordId).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-careers-records-deleted', response.data);
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + "Permission denied");
                });
            } else {
                deferred.reject({
                    message: "No ID Supplied"
                });
            }
            return deferred.promise;
        }
        /**
         * This method is used to save changes to an existing StudentCareersRecord object.
         *
         * @param  {StudentCareersRecord} studentCareersRecord An StudentCareersRecord object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no studentCareersRecord data is provided then the method returns null.
         */
        function save(studentCareersRecord, callback) {
            var deferred = $q.defer();
            if (studentCareersRecord && studentCareersRecord.id) {
                $http.put(url + 'student-careers-records/' + studentCareersRecord.id, studentCareersRecord).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('careers-record-saved', response.data);
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
