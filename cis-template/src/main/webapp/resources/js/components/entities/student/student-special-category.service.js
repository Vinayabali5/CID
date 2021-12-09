/**
 * This is the factory definition for the StudentSpecialCategory Data Service. This defines how to handle data about StudentSpecialCategory objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */


(function() {
    'use strict';

    angular
        .module('StudentSpecialCategoryService', ['cid.app.constants', 'ui-notification'])
        .factory('StudentSpecialCategory', studentSpecialCatergoryFactory);

    studentSpecialCatergoryFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function studentSpecialCatergoryFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/';

        var factory = {
            query: getAll,
            get: getById,
            getForm: getFormByStudentId,
            getCompleteForm: getCompleteFormByStudentId,
            create: create,
            save: save
        };
        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the StudentSpecialCategory from the API collection.
         *
         * @return {StudentSpecialCategory} An array of StudentSpecialCategory objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('student-special-categories-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a StudentSpecialCategory from the API collection.
         * @param  {int} id of the StudentSpecialCategory object that is to be retrieved.
         * @return {StudentSpecialCategory} An StudentSpecialCategory object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + 'studentSpecialCategories/' + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-special-category-loaded', response.data);
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
         * This method is used to retrieve an instance of a StudentSpecialCategory from the API collection.
         * @param  {int} studentId of the StudentSpecialCategory object that is to be retrieved.
         * @return {StudentSpecialCategory} An StudentSpecialCategory object as identified by the id.
         */
        function getFormByStudentId(studentId) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.get(url + 'students/' + studentId + '/specialCategories').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-special-category-studentId-loaded', response.data);
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
         * This method is used to retrieve an instance of a StudentSpecialCategory from the API collection.
         * @param  {int} id of the StudentSpecialCategory object that is to be retrieved.
         * @return {StudentSpecialCategory} An StudentSpecialCategory object as identified by the id.
         */
        function getCompleteFormByStudentId(studentId) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.get(url + 'students/' + studentId + '/specialCategoriesForm').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-special-category-by-studentId-loaded', response.data);
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
         * This method is used to create a new instance of an StudentSpecialCategory object in the database by POSTing the
         * required data to the API.
         *
         * @param  {StudentSpecialCategory} studentSpecialCategory An StudentSpecialCategory object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no studentSpecialCategory data is provided then the method returns null.
         */
        function create(studentSpecialCategory, callback) {
            var deferred = $q.defer();
            if (studentSpecialCategory != undefined && studentSpecialCategory != null) {
                $http.post(url + 'studentSpecialCategories', studentSpecialCategory).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-special-category-created', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No StudentSpecialCategory ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing StudentSpecialCategory object.
         *
         * @param  {StudentSpecialCategory} StudentSpecialCategory An StudentSpecialCategory object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no StudentSpecialCategory data is provided then the method returns null.
         */
        function save(studentSpecialCategory, callback) {
            var deferred = $q.defer();
            if (studentSpecialCategory && studentSpecialCategory.id) {
                $http.put(url + 'studentSpecialCategories/' + studentSpecialCategory.id, studentSpecialCategory).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-special-category-saved', response.data);
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
