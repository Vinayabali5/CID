/**
 * This is the factory definition for the StudentRiskLevel Data Service. This defines how to handle data about StudentRiskLevel objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('StudentRiskLevelService', ['ui-notification'])
        .factory('StudentRiskLevel', studentRiskLevelFactory);

    studentRiskLevelFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function studentRiskLevelFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/';

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
         * This method is used to retrieve all the StudentRiskLevel from the API collection.
         *
         * @return {StudentRiskLevel} An array of StudentRiskLevel objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url + 'student-risk-levels').then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('studentRiskLevels-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }


        /**
         * This method is used to retrieve an instance of a StudentRiskLevel from the API collection.
         * @param  {int} id of the StudentRiskLevel object that is to be retrieved.
         * @return {StudentRiskLevel} An StudentRiskLevel object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + 'student-risk-level/' + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-risk-levels-loaded', response.data);
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
         * This method is used to retrieve an instance of a StudentRiskLevel from the API collection.
         * @param  {int} id of the StudentRiskLevel object that is to be retrieved.
         * @return {StudentRiskLevel} An StudentRiskLevel object as identified by the id.
         */
        function getByStudentId(studentId) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.get(url + 'students/' + studentId + '/risk-levels').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-risk-levels-loaded', response.data);
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
         * This method is used to create a new instance of an StudentRiskLevel object in the database by POSTing the
         * required data to the API.
         *
         * @param  {StudentRiskLevel} studentRiskLevel An StudentRiskLevel object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no StudentRiskLevel data is provided then the method returns null.
         */
        function create(studentRiskLevel, callback) {
            var deferred = $q.defer();
            if (studentRiskLevel != undefined && studentRiskLevel != null) {
                $http.post(url + 'student-risk-level', studentRiskLevel).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-risk-level-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No StudentRiskLevel ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing StudentRiskLevel object.
         *
         * @param  {StudentRiskLevel} studentRiskLevel An StudentRiskLevel object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no StudentRiskLevel data is provided then the method returns null.
         */
        function save(studentRiskLevel, callback) {
            var deferred = $q.defer();
            if (studentRiskLevel != undefined && studentRiskLevel != null && studentRiskLevel.id) {
                $http.put(url + 'student-risk-level/' + studentRiskLevel.id, studentRiskLevel).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-risk-level-saved', response.data);
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
         * This method is used to delete an instance of a StudentRiskLevel from the API collection.
         * @param  {int} studentRiskLevelId of the StudentRiskLevel object that is to be retrieved.
         * @return {StudentRiskLevel} An StudentRiskLevel object as identified by the studentRiskLevelId.
         */
        function deleteById(studentRiskLevelId) {
            var deferred = $q.defer();
            if (studentRiskLevelId != undefined && studentRiskLevelId != null) {
                $http.delete(url + 'student-risk-levels/' + studentRiskLevelId).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-risk-level-deleted', response.data);
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
