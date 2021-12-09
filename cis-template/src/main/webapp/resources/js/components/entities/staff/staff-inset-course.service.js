/**
 * This is the factory definition for the StaffInsetCourse Data Service. This defines how to handle data about StaffInsetCourse objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('StaffInsetCourseService', ['ui-notification'])
        .factory('StaffInsetCourse', staffInsetCourseFactory);

    staffInsetCourseFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function staffInsetCourseFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/staff-inset-courses/';
        // Public Interface
        var factory = {
            query: getAll,
            get: getById,
            getByStaffId: getByStaffId,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the StaffInsetCourse from the API collection.
         *
         * @return {StaffInsetCourse} An array of StaffInsetCourse objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('staffInsetCourse-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a StaffInsetCourse from the API collection.
         * @param  {int} id of the StaffInsetCourse object that is to be retrieved.
         * @return {StaffInsetCourse} An StaffInsetCourse object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staffInsetCourse-loaded', response.data);
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

        function getByStaffId(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + 'staff/' + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staffInsetCourse-loaded', response.data);
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
         * This method is used to create a new instance of an StaffInsetCourse object in the database by POSTing the
         * required data to the API.
         *
         * @param  {StaffInsetCourse} staffInsetCourse An StaffInsetCourse object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no StaffInsetCourse data is provided then the method returns null.
         */
        function create(staffInsetCourse, callback) {
            var deferred = $q.defer();
            if (staffInsetCourse != undefined && staffInsetCourse != null) {
                $http.post(url, staffInsetCourse).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staffInsetCourse-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No StaffInsetCourse ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing StaffInsetCourse object.
         *
         * @param  {StaffInsetCourse} staffInsetCourse An StaffInsetCourse object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no StaffInsetCourse data is provided then the method returns null.
         */
        function save(staffInsetCourse, callback) {
            var deferred = $q.defer();
            if (staffInsetCourse && staffInsetCourse.id) {
                $http.put(url + staffInsetCourse.id, staffInsetCourse).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staffInsetCourse-saved', response.data);
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
