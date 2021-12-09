/**
 * This is the factory definition for the StudentLLDDHealthProblemCategory Data Service. This defines how to handle data about StudentLLDDHealthProblemCategory objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('StudentLLDDHealthProblemCategoryService', ['cid.app.constants', 'ui-notification'])
        .factory('StudentLLDDHealthProblemCategory', studentLLDDHealthProblemCategoryFactory);

    studentLLDDHealthProblemCategoryFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function studentLLDDHealthProblemCategoryFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save,
            delete: deleteById,
            getByStudentId: getByStudentId
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the StudentRefferalReason from the API collection.
         *
         * @return {StudentRefferalReason} An array of StudentRefferalReason objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url + 'student-lldd-health-problem-categories').then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('student-lldd-health-problem-categories-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }
        /**
         * This method is used to retrieve an instance of a StudentRefferalReason from the API collection.
         * @param  {int} id of the StudentRefferalReason object that is to be retrieved.
         * @return {StudentRefferalReason} An StudentRefferalReason object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + 'student-lldd-health-problem-categories/' + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-lldd-health-problem-categories-loaded', response.data);
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
         * This method is used to retrieve all the StudentLLDDHealthProblemCategory from the API collection.
         *
         * @return {StudentLLDDHealthProblemCategory} An array of StudentLLDDHealthProblemCategory objects.
         */
        function getByStudentId(studentId) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.get(url + 'students/' + studentId + '/student-lldd-health-problem-categories').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-lldd-health-problem-categories-loaded', response.data);
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
         * This method is used to delete an instance of a StudentLLDDHealthProblemCategory from the API Collection.
         * @param {int} id of the StudentLLDDHealthProblemCategory object that is to be deleted.
         * @return {StudentLLDDHealthProblemCategory} A StudentLLDDHealthProblemCategory object as identified by the id.
         */
        function deleteById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.delete(url + 'student-lldd-health-problem-categories/' + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-lldd-health-problem-category-deleted', response.data);
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
         * This method is used to create a new instance of an StudentLLDDHealthProblemCategory object in the database by POSTing the
         * required data to the API.
         *
         * @param  {StudentLLDDHealthProblemCategory} studentLLDDHealthProblemCategory An StudentLLDDHealthProblemCategory object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no studentLLDDHealthProblemCategory data is provided then the method returns null.
         */
        function create(studentLLDDHealthProblemCategory, callback) {
            var deferred = $q.defer();
            if (studentLLDDHealthProblemCategory != undefined && studentLLDDHealthProblemCategory != null) {
                $http.post(url + 'student-lldd-health-problem-categories', studentLLDDHealthProblemCategory).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-lldd-health-problem-category-created', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No StudentLLDDHealthProblemCategory ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing StudentLLDDHealthProblemCategory object.
         *
         * @param  {StudentLLDDHealthProblemCategory} StudentLLDDHealthProblemCategory An StudentLLDDHealthProblemCategory object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no StudentLLDDHealthProblemCategory data is provided then the method returns null.
         */
        function save(studentLLDDHealthProblemCategory, callback) {
            var deferred = $q.defer();
            if (studentLLDDHealthProblemCategory && studentLLDDHealthProblemCategory.id) {
                $http.put(url + 'student-lldd-health-problem-categories/' + studentLLDDHealthProblemCategory.id, studentLLDDHealthProblemCategory).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-lldd-health-problem-category-saved', response.data);
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
