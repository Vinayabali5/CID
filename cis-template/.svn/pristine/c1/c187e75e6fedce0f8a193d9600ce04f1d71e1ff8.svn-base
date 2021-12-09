/**
 * This is the factory definition for the StudentRiskAssessment Data Service. This defines how to handle data about StudentRiskAssessment objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('StudentRiskAssessmentService', ['cid.app.constants', 'ui-notification'])
        .factory('StudentRiskAssessment', studentRiskAssessmentFactory);

    studentRiskAssessmentFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function studentRiskAssessmentFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/';
        var factory = {
            get: getById,
            create: create,
            save: save
        };
        return factory;
        // Private Interface

        /**
         * This method is used to retrieve an instance of a StudentRiskAssessment of a Student from the API collection.
         * @param  {int} studentId of the Student object that is to be retrieved.
         * @return {StudentRiskAssessment} An StudentRiskAssessment object as identified by the studentId.
         */
        function getById(studentId) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.get(url + 'students/' + studentId + '/risk-assessment').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-risk-assessments-loaded', response.data);
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
         * This method is used to create a new instance of an StudentRiskAssessment object in the database by POSTing the
         * required data to the API.
         *
         * @param  {StudentRiskAssessment} studentRiskAssessment An StudentRiskAssessment object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Room data is provided then the method returns null.
         */
        function create(studentRiskAssessment, callback) {
            var deferred = $q.defer();
            if (studentRiskAssessment != undefined && studentRiskAssessment != null) {
                $http.post(url + 'student-risk-assessment', studentRiskAssessment).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-risk-assessment-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Room ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing StudentRiskAssessment object.
         *
         * @param  {StudentRiskAssessment} studentRiskAssessment An StudentRiskAssessment object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Room data is provided then the method returns null.
         */
        function save(studentRiskAssessment, callback) {
            var deferred = $q.defer();
            if (studentRiskAssessment != undefined && studentRiskAssessment != null && studentRiskAssessment.id) {
                $http.put(url + 'student-risk-assessment/' + studentRiskAssessment.id, studentRiskAssessment).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-risk-assessment-saved', response.data);
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
    }
})();
