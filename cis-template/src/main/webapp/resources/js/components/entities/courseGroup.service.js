/**
 * This is the factory definition for the CourseGroup Data Service. This defines how to handle data about CourseGroup objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('CourseGroupService', ['cid.app.constants', 'ui-notification'])
        .factory('CourseGroup', courseGroupFactory);

    courseGroupFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'APP', 'Notification'];

    function courseGroupFactory($q, $http, $rootScope, GLOBAL, APP, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/course-groups/';
        var params = '';
        // Public Interface
        var factory = {
            query: getAll,
            get: getById,
            searchBySpec: searchBySpec,
            create: create,
            save: save,
            getByYear: getByYear,
            enrolments: getEnrolments,
            timetables: getTimetables,
            ilpInterviews: getILPInterviews,
        };

        return factory;

        //Private Interface
        /**
         * This method is used to retrieve all the CourseGroup from the API collection.
         *
         * @return {CourseGroup} An array of CourseGroup objects.
         */
        function getAll() {
            var deferred = $q.defer();
            params = '';
            if ($rootScope.currentYear) {
                params = '?year=' + $rootScope.currentYear.code;
            }
            $http.get(url + params).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('course-groups-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        function searchBySpec(spec) {
            var deferred = $q.defer();
            if (spec != undefined && spec != null) {
                $http.get(url + 'searchByYearAndSpec' + '?spec=' + spec).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('course-group-spec-loaded', response.data);
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
         * This method is used to retrieve an instance of a CourseGroup from the API collection.
         * @param  {int} id of the CourseGroup object that is to be retrieved.
         * @return {CourseGroup} An CourseGroup object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('course-groups-loaded', response.data);
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
         * This method is used to create a new instance of an CourseGroup object in the database by POSTing the
         * required data to the API.
         *
         * @param  {CourseGroup} CourseGroup An CourseGroup object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no CourseGroup data is provided then the method returns null.
         */
        function create(courseGroup, callback) {
            var deferred = $q.defer();
            if (courseGroup != undefined && courseGroup != null) {
                $http.post(url, courseGroup).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('course-group-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No CourseGroup ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing CourseGroup object.
         *
         * @param  {CourseGroup} CourseGroup An CourseGroup object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no CourseGroup data is provided then the method returns null.
         */
        function save(courseGroup, callback) {
            var deferred = $q.defer();
            if (courseGroup && courseGroup.id) {
                $http.put(url + courseGroup.id, courseGroup).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('course-group-saved', response.data);
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

        /**
         * This method is used to retrieve all the CourseGroup from the API collection.
         * @param {year} Request Parameter
         * @return {CourseGroup} An array of CourseGroup objects valid for year.
         */
        function getByYear(year) {
            var deferred = $q.defer();
            $http.get(url, {
                params: {
                    yearId: year.id
                }
            }).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('course-group-by-year-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a CourseGroup from the API collection.
         * @param  {int} id of the CourseGroup object that is to be retrieved.
         * @return {CourseGroup} An CourseGroup object as identified by the id.
         */
        function getTimetables(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id + '/timetable').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('course-group-timetable-loaded', response.data);
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
         * This method is used to retrieve all the enrolments for the specified CourseGroup from the API collection.
         *
         * @param {id} The ID for the course group to query for.
         * @return {Enrolment} An array of Enrolment objects valid for specified course group..
         */
        function getEnrolments(id) {
            var deferred = $q.defer();
            var year = APP.getYear();
            if (id != undefined && id != null) {
                $http.get(url + id + '/enrolments', {
                    params: {
                        yearId: year.id
                    }
                }).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('course-group-enrolment-loaded', response.data);
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
         * This method is used to retrieve all the ilp interviews for the specified CourseGroup from the API collection.
         *
         * @param {id} The ID for the course group to query for.
         * @return {ILPInterview} An array of ILPInterview objects valid for specified course group..
         */
        function getILPInterviews(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id + '/ilp-interviews').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('course-group-ilp-interviews-loaded', response.data);
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
