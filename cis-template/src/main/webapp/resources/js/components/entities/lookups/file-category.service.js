/**
 * This is the factory definition for the FileCategory Data Service. This defines how to handle data about FileCategory objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('FileCategoryService', ['cid.app.constants'])
        .factory('FileCategory', fileCategoryFactory);

    fileCategoryFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function fileCategoryFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/fileCategories/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the FileCategory from the API collection.
         *
         * @return {FileCategory} An array of FileCategory objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('file-categories-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a FileCategory from the API collection.
         * @param  {int} id of the FileCategory object that is to be retrieved.
         * @return {FileCategory} An FileCategory object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('file-category-loaded', response.data);
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
         * This method is used to create a new instance of an FileCategory object in the database by POSTing the
         * required data to the API.
         *
         * @param  {FileCategory} fileCategory An FileCategory object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no FileCategory data is provided then the method returns null.
         */
        function create(fileCategory, callback) {
            var deferred = $q.defer();
            if (fileCategory != undefined && fileCategory != null) {
                $http.post(url, fileCategory).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('file-category-created', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No FileCategory ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing FileCategory object.
         *
         * @param  {FileCategory} fileCategory An FileCategory object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no FileCategory data is provided then the method returns null.
         */
        function save(fileCategory, callback) {
            var deferred = $q.defer();
            if (fileCategory && fileCategory.id) {
                $http.put(url + fileCategory.id, fileCategory).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('file-category-saved', response.data);
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
