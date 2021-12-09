/**
 * This is the factory definition for the StudentRemarkPermission Data Service. This defines how to handle data about StudentRemarkPermission objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('StudentRemarkPermissionService', ['cid.app.constants', 'ui-notification'])
        .factory('StudentRemarkPermission', studentRemarkPermissionFactory);

    studentRemarkPermissionFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function studentRemarkPermissionFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/studentRemarkPermissions/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the StudentRemarkPermission from the API collection.
         *
         * @return {StudentRemarkPermission} An array of StudentRemarkPermission objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('student-remark-permission-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }
        /**
         * This method is used to retrieve an instance of a StudentRemarkPermission from the API collection.
         * @param  {int} id of the StudentRemarkPermission object that is to be retrieved.
         * @return {StudentRemarkPermission} An StudentRemarkPermission object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-remark-permission-loaded', response.data);
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
         * This method is used to create a new instance of an StudentRemarkPermission object in the database by POSTing the
         * required data to the API.
         *
         * @param  {StudentRemarkPermission} studentRemarkPermission An StudentRemarkPermission object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no studentRemarkPermission data is provided then the method returns null.
         */
        function create(studentRemarkPermission, callback) {
            var deferred = $q.defer();
            if (studentRemarkPermission != undefined && studentRemarkPermission != null) {
                $http.post(url, studentRemarkPermission).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-remark-permission-created', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No StudentRemarkPermission ID Supplied"
                });
            }
            return deferred.promise;
        }
        /**
         * This method is used to save changes to an existing StudentRemarkPermission object.
         *
         * @param  {StudentRemarkPermission} studentRemarkPermission An StudentRemarkPermission object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no studentRemarkPermission data is provided then the method returns null.
         */
        function save(studentRemarkPermission, callback) {
            var deferred = $q.defer();
            if (studentRemarkPermission && studentRemarkPermission.id) {
                $http.put(url + studentRemarkPermission.id, studentRemarkPermission).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-remark-permission-saved', response.data);
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
