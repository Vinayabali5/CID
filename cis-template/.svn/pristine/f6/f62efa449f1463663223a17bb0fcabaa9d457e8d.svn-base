/**
 * This is the factory definition for the StudentLearningSupport Data Service. This defines how to handle data about StudentLearningSupport objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('StudentLearningSupportService', ['cid.app.constants', 'ui-notification'])
        .factory('StudentLearningSupport', studentLearningSupportFactory);

    studentLearningSupportFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function studentLearningSupportFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/';
        var factory = {
            query: getAll,
            get: getById,
            save: save,
            create: create
        };
        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the StudentLearningSupport from the API collection.
         *
         * @return {StudentLearningSupport} An array of StudentLearningSupport objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url + 'students/').then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('student-learning-supports-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }
        /**
         * This method is used to retrieve an instance of a StudentLearningSupport of a Student from the API collection.
         * @param  {int} studentId of the Student object that is to be retrieved.
         * @return {StudentLearningSupport} An StudentLearningSupport object as identified by the studentId.
         */
        function getById(studentId) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.get(url + 'students/' + studentId + '/learningSupport').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-learning-supports-loaded', response.data);
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
         * This method is used to create a new instance of an StudentLearningSupport object in the database by POSTing the
         * required data to the API.
         *
         * @param  {StudentLearningSupport} studentLearningSupport An StudentLearningSupport object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Room data is provided then the method returns null.
         */
        function create(studentLearningSupport, callback) {
            var deferred = $q.defer();
            if (studentLearningSupport) {
                $http.post(url + 'student-learning-support', studentLearningSupport).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-learning-support-saved', response.data);
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
         * This method is used to save changes to an existing StudentLearningSupport object.
         *
         * @param  {StudentLearningSupport} studentLearningSupport An StudentLearningSupport object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Room data is provided then the method returns null.
         */
        function save(studentLearningSupport, callback) {
            var deferred = $q.defer();
            if (studentLearningSupport && studentLearningSupport.studentId) {
                $http.put(url + 'students/' + studentLearningSupport.studentId + '/learning-support', studentLearningSupport).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-learning-support-saved', response.data);
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
