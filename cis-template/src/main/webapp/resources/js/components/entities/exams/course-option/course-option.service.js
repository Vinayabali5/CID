/**
 * This is the factory definition for the Address Data Service. This defines how to handle data about Address objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('CourseOptionService', ['ui-notification'])
        .factory('CourseOption', CourseOptionService);

    CourseOptionService.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function CourseOptionService($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/course-options/';

        // Public Interface
        var factory = {
            query: getAll,
            get: getById,
            getCourseId: getCourseId,
            create: create,
            save: save,
            deleteById: deleteById

        };
        return factory;

        //private Interface
        /**
         * This method is used to retrieve all the Address from the API collection.
         *
         * @return {Address} An array of Address objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('course-options-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a Course from the API collection.
         *
         * @param  {int} id of the Course object that is to be retrieved.
         * @return {Course} An Course object as identified by the id.
         */
        function getCourseId(courseId) {
            var deferred = $q.defer();
            if (courseId != undefined) {
                $http.get(url + courseId).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('course-options-loaded', response.data);
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
         * This method is used to retrieve an instance of a Course from the API collection.
         *
         * @param  {int} id of the Course object that is to be retrieved.
         * @return {Course} An Course object as identified by the id.
         */
        function getById(courseId, examOptionId, callback) {
            var deferred = $q.defer();
            if (courseId != undefined && examOptionId != null) {
                return $http.get(url + courseId + "/" + examOptionId).then(function(response) {
                    if (callback) {
                        callback();
                    }
                    return response.data;
                }, function(response) {
                    return {
                        status: response.status,
                        error: response.data
                    };
                });
            } else {
                return null;
            }
        }

        /**
         * This method is used to create a new instance of an Course object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Course} Course An Course object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Course data is provided then the method returns null.
         */
        function create(courseOption, callback) {
            var deferred = $q.defer();
            if (courseOption != undefined && courseOption != null) {
                $http.post(url, courseOption).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('course-option-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Course ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing CourseOption object.
         *
         * @param  {CourseOption} CourseOption An CourseOption object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Course data is provided then the method returns null.
         */
        function save(courseId, examOptionId, courseOption, callback) {
            var deferred = $q.defer();
            $http.put(url + courseId + "/" + examOptionId, courseOption).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('course-option-saved', response.data);
                if (callback) {
                    callback();
                }
            }, function(response) {
                deferred.reject(response);
                Notification.error("Error:" + response.data.message);
            });
            return deferred.promise;
        }

        /**
         * This method is used to delete an instance of a CourseOption from the API collection.
         * @param  {int} courseId of the CourseOption object that is to be retrieved.
         * @return {ExamOption} A CourseOption object as identified by the courseOptionId.
         */
        function deleteById(courseId, examOptionId) {
            var deferred = $q.defer();
            if (courseId, examOptionId) {
                $http.delete(url + courseId + "/" + examOptionId).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('exam-syllabus-saved', response.data);
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
    }
})();
