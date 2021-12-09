/**
 * This is the factory definition for the Exam Results Service . This defines how to handle data about Results objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular.module('ExamResultsService', ['cid.app.constants', 'ui-notification'])
        .factory('ExamResults', resultsFactory);

    resultsFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function resultsFactory($q, $http, $rootScope, GLOBAL, Notification) {
        // Variables and Constants
        var url = GLOBAL.API;

        //Public Interface
        var factory = {
            getByStudent: getByStudent,
            get: getById,
            save: save
        };

        return factory;

        //Private
        /**
         * This method is used to retrieve all the Result of Student id from the API collection.
         * @param  studentId
         * @return {Results} An array of Results objects.
         */
        function getByStudent(studentId) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.get(url + '/students/' + studentId + '/exam-results').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('exam-results-loaded', response.data);
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
         * This method is used to retrieve an instance of Result object
         * @param resultId -  result identifier
         * @return {Results} An instance of Result object.
         */
        function getById(resultId) {
            var deferred = $q.defer();
            if (resultId != undefined && resultId != null) {
                $http.get(url + '/exam-results/' + resultId).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('exam-results-loaded', response.data);
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
         * This method is used to save an instance of Result object
         * @param examResult- Results object that is to be saved
         * @return {Results} An instance of Result object saved
         */
        function save(examResult, callback) {
            var deferred = $q.defer();
            if (examResult && examResult.id) {
                $http.put(url + '/exam-results/' + examResult.id, examResult).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('exam-results-saved', response.data);
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
