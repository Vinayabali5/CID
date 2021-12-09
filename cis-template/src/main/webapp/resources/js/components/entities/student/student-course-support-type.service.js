/**
 * This is the factory definition for the StudentCourseSupportType Data Service. This defines how to handle data about StudentCourseSupportType objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('StudentCourseSupportTypeService', ['cid.app.constants', 'ui-notification'])
        .factory('StudentCourseSupportType', studentCourseSupportTypeFactory);

    studentCourseSupportTypeFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function studentCourseSupportTypeFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/';

        var factory = {
            query: getAll,
            create: create,
            save: save,
            delete: deleteSupportType,
            getByStudentId: getByStudentId
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the StudentCourseSupportType from the API collection.
         *
         * @return {StudentCourseSupportType} An array of StudentCourseSupportType objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('course-support-types-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a StudentCourseSupportType from the API collection.
         * @param  {int} id of the StudentCourseSupportType object that is to be retrieved.
         * @return {StudentCourseSupportType} An StudentCourseSupportType object as identified by the id.
         */
        function getByStudentId(studentId) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.get(url + 'students/' + studentId + '/support-types').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-course-support-types-loaded', response.data);
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
         * This method is used to create a new instance of an StudentCourseSupportType object in the database by POSTing the
         * required data to the API.
         *
         * @param  {StudentCourseSupportType} studentCourseSupportType An StudentCourseSupportType object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no studentCourseSupportType data is provided then the method returns null.
         */
        function create(concession, callback) {
            var deferred = $q.defer();
            if (concession != undefined && concession != null) {
                $http.post(url + 'course-support-types', concession).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('course-support-types-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No concession ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing StudentCourseSupportType object.
         *
         * @param  {StudentCourseSupportType} StudentCourseSupportType An StudentCourseSupportType object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no StudentCourseSupportType data is provided then the method returns null.
         */
        function save(concession, callback) {
            var deferred = $q.defer();
            if (concession && concession.studentId) {
                $http.put(url + 'course-support-types/' + concession.studentCourseSupportTypeId, concession).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('course-concession-saved', response.data);
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

        function deleteSupportType(supportType) {
            var deferred = $q.defer();
            $http.delete(url + 'course-support-types/' + supportType.studentCourseSupportTypeId).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('course-support-type-saved', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }



    }
})();
