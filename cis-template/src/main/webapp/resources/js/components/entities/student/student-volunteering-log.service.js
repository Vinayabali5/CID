/**
 * This is the factory definition for the StudentVolunteeringLog Data Service. This defines how to handle data about StudentVolunteeringLog objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('StudentVolunteeringLogService', ['cid.app.constants', 'ui-notification'])
        .factory('StudentVolunteeringLog', studentVolunteeringLogFactory);

    studentVolunteeringLogFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function studentVolunteeringLogFactory($q, $http, $rootScope, GLOBAL, Notification) {
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
         * This method is used to retrieve all the StudentVolunteeringLog from the API collection.
         *
         * @return {StudentVolunteeringLog} An array of StudentVolunteeringLog objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url + 'student-volunteering-logs').then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('student-volunteering-logs-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an collection of StudentVolunteeringLog entities from the API collection.
         * @param  {int} studentVolunteeringLogId of the StudentVolunteeringLog object that is to be retrieved.
         * @return {StudentVolunteeringLog} An StudentVolunteeringLog object as identified by the id.
         */
        function getByStudentId(studentId) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.get(url + 'students/' + studentId + '/student-volunteering-logs').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-volunteering-logs-loaded', response.data);
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
         * This method is used to retrieve an instance of a StudentVolunteeringLog from the API collection.
         * @param  {int} studentVolunteeringLogId of the StudentVolunteeringLog object that is to be retrieved.
         * @return {StudentVolunteeringLog} An StudentVolunteeringLog object as identified by the id.
         */
        function getById(studentVolunteeringLogId) {
            var deferred = $q.defer();
            $http.get(url + 'student-volunteering-logs/' + studentVolunteeringLogId).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('student-volunteering-logs-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to create a new instance of an StudentVolunteeringLog object in the database by POSTing the
         * required data to the API.
         *
         * @param  {StudentVolunteeringLog} studentVolunteeringLog An StudentVolunteeringLog object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no studentVolunteeringLog data is provided then the method returns null.
         */
        function create(studentVolunteeringLog, callback) {
            var deferred = $q.defer();
            if (studentVolunteeringLog) {
                $http.post(url + 'student-volunteering-logs', studentVolunteeringLog).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-volunteering-logs-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No studentVolunteeringLog ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to delete an instance of a studentVolunteeringLog from the API collection.
         * @param  {int} studentVolunteeringLogId of the studentVolunteeringLog object that is to be retrieved.
         * @return {studentVolunteeringLog} An studentVolunteeringLog object as identified by the studentVolunteeringLogId.
         */
        function deleteById(studentVolunteeringLogId) {
            var deferred = $q.defer();
            if (studentVolunteeringLogId) {
                $http.delete(url + 'student-volunteering-logs/' + studentVolunteeringLogId).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-volunteering-logs-deleted', response.data);
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
         * This method is used to save changes to an existing StudentVolunteeringLog object.
         *
         * @param  {StudentVolunteeringLog} studentVolunteeringLog An StudentVolunteeringLog object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no studentVolunteeringLog data is provided then the method returns null.
         */
        function save(studentVolunteeringLog, callback) {
            var deferred = $q.defer();
            if (studentVolunteeringLog && studentVolunteeringLog.id) {
                $http.put(url + 'student-volunteering-logs/' + studentVolunteeringLog.id, studentVolunteeringLog).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-volunteering-logs-saved', response.data);
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
