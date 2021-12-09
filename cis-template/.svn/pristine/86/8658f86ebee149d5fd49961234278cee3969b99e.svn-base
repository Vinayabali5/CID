/**
 * This is the factory definition for the StudentDukeOfEdinburgh Data Service. This defines how to handle data about StudentDukeOfEdinburgh objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('StudentDukeOfEdinburghService', ['cid.app.constants', 'ui-notification'])
        .factory('StudentDukeOfEdinburgh', studentDukeOfEdinburghFactory);

    studentDukeOfEdinburghFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function studentDukeOfEdinburghFactory($q, $http, $rootScope, GLOBAL, Notification) {
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
         * This method is used to retrieve all the StudentDukeOfEdinburgh from the API collection.
         *
         * @return {StudentDukeOfEdinburgh} An array of StudentDukeOfEdinburgh objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url + 'student-duke-of-edinburghss').then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('student-duke-of-edinburghs-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an collection of StudentDukeOfEdinburgh entities from the API collection.
         * @param  {int} studentDukeOfEdinburghId of the StudentDukeOfEdinburgh object that is to be retrieved.
         * @return {StudentDukeOfEdinburgh} An StudentDukeOfEdinburgh object as identified by the id.
         */
        function getByStudentId(studentId) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.get(url + 'students/' + studentId + '/student-duke-of-edinburghs').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-duke-of-edinburghs-loaded', response.data);
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
         * This method is used to retrieve an instance of a StudentDukeOfEdinburgh from the API collection.
         * @param  {int} studentDukeOfEdinburghId of the StudentDukeOfEdinburgh object that is to be retrieved.
         * @return {StudentDukeOfEdinburgh} An StudentDukeOfEdinburgh object as identified by the id.
         */
        function getById(studentDukeOfEdinburghId) {
            var deferred = $q.defer();
            $http.get(url + 'student-duke-of-edinburghs/' + studentDukeOfEdinburghId).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('student-duke-of-edinburghs-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to create a new instance of an StudentDukeOfEdinburgh object in the database by POSTing the
         * required data to the API.
         *
         * @param  {StudentDukeOfEdinburgh} studentDukeOfEdinburgh An StudentDukeOfEdinburgh object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no studentDukeOfEdinburgh data is provided then the method returns null.
         */
        function create(studentDukeOfEdinburgh, callback) {
            var deferred = $q.defer();
            if (studentDukeOfEdinburgh) {
                $http.post(url + 'student-duke-of-edinburghs', studentDukeOfEdinburgh).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-duke-of-edinburghs-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No studentDukeOfEdinburgh ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to delete an instance of a studentDukeOfEdinburgh from the API collection.
         * @param  {int} studentDukeOfEdinburghId of the studentDukeOfEdinburgh object that is to be retrieved.
         * @return {studentDukeOfEdinburgh} An studentDukeOfEdinburgh object as identified by the studentDukeOfEdinburghId.
         */
        function deleteById(studentDukeOfEdinburghId) {
            var deferred = $q.defer();
            if (studentDukeOfEdinburghId) {
                $http.delete(url + 'student-duke-of-edinburghs/' + studentDukeOfEdinburghId).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-duke-of-edinburghs-deleted', response.data);
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
         * This method is used to save changes to an existing StudentDukeOfEdinburgh object.
         *
         * @param  {StudentDukeOfEdinburgh} studentDukeOfEdinburgh An StudentDukeOfEdinburgh object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no studentDukeOfEdinburgh data is provided then the method returns null.
         */
        function save(studentDukeOfEdinburgh, callback) {
            var deferred = $q.defer();
            if (studentDukeOfEdinburgh && studentDukeOfEdinburgh.id) {
                $http.put(url + 'student-duke-of-edinburghs/' + studentDukeOfEdinburgh.id, studentDukeOfEdinburgh).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-duke-of-edinburghs-saved', response.data);
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
