/**
 * This is the factory definition for the Course Data Service. This defines how to handle data about Course objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('CourseService', ['cid.app.constants', 'ui-notification'])
        .factory('Course', courseFactory);

    courseFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'APP', 'Notification'];

    function courseFactory($q, $http, $rootScope, GLOBAL, APP, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/courses/';
        var endpoints = {
            courseGroups: '/courseGroups',
            enrolments: '/enrolments',
            examOptions: '/exam-options'
        };

        // Public Interface

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save,
            getByYear: getByYear,
            courseGroups: getCourseGroupsById,
            enrolments: getCourseEnrolments,
            examOptions: getCourseExamOptions
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the Course from the API collection.
         *
         * @return {Course} An array of Course objects.
         */
        function getAll() {
            var deferred = $q.defer();
            var year = APP.getYear();
            $http.get(url, {
                params: {
                    yearId: year.id
                }
            }).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('courses-loaded', response.data);
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
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('courses-loaded', response.data);
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
         * This method is used to create a new instance of an Course object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Course} Course An Course object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Course data is provided then the method returns null.
         */
        function create(course, callback) {
            var deferred = $q.defer();
            if (course != undefined && course != null) {
                $http.post(url, course).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('course-saved', response.data);
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
         * This method is used to save changes to an existing Course object.
         *
         * @param  {Course} Course An Course object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Course data is provided then the method returns null.
         */
        function save(course, callback) {
            var deferred = $q.defer();
            $http.put(url + course.id, course).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('course-saved', response.data);
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
         * This method is used to retrieve the Course Groups of a Course from the API collection.
         *
         * @param  {int} courseId of the Course object that is to be retrieved.
         * @return {Array} An Array of CourseGroups.
         */
        function getCourseGroupsById(courseId) {
            var deferred = $q.defer();
            var year = APP.getYear();
            if (courseId != undefined && courseId != null) {
                $http.get(url + courseId + endpoints.courseGroups, {
                    params: {
                        yearId: year.id
                    }
                }).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('courses-loaded', response.data);
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
         * This method is used to retrieve the Course of a Year from the API collection.
         *
         * @param  {AcademicYaer} year of the Course object that is to be retrieved.
         * @return {Course} List of Course valid for a year
         */
        function getByYear(year) {
            var deferred = $q.defer();
            $http.get(url, {
                params: {
                    yearId: year.id
                }
            }).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('courses-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve the Enrolments for a given Course from the API collection.
         *
         * @param  {int} courseId of the Course object that is to be retrieved.
         * @return {Array} An Array of Enrolments.
         */
        function getCourseEnrolments(courseId) {
            var deferred = $q.defer();
            var year = APP.getYear();
            if (courseId != undefined && courseId != null) {
                $http.get(url + courseId + endpoints.enrolments, {
                    params: {
                        yearId: year.id
                    }
                }).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('course-enrolment-loaded', response.data);
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
         * This method is used to retrieve the ExamOptions for a given Course from the API collection.
         *
         * @param  {int} courseId of the Course object that is to be retrieved.
         * @return {Array} An Array of ExamOptions.
         */
        function getCourseExamOptions(courseId) {
            var deferred = $q.defer();
            var year = APP.getYear();
            if (courseId != undefined && courseId != null) {
                $http.get(url + courseId + endpoints.examOptions, {
                    params: {
                        yearId: year.id
                    }
                }).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('course-exam-options-loaded', response.data);
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
