/**
 * This is the factory definition for the SpecialCategory Data Service. This defines how to handle data about SpecialCategory objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('SpecialCategoryService', ['cid.app.constants'])
        .factory('SpecialCategory', specialCategoryFactory);

    specialCategoryFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function specialCategoryFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/specialCategories/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the SpecialCategory from the API collection.
         *
         * @return {SpecialCategory} An array of SpecialCategory objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('special-categories-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a SpecialCategory from the API collection.
         * @param  {int} id of the SpecialCategory object that is to be retrieved.
         * @return {SpecialCategory} An SpecialCategory object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('special-category-loaded', response.data);
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
         * This method is used to create a new instance of an SpecialCategory object in the database by POSTing the
         * required data to the API.
         *
         * @param  {SpecialCategory} specialCategory An SpecialCategory object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no SpecialCategory data is provided then the method returns null.
         */
        function create(specialCategory, callback) {
            var deferred = $q.defer();
            if (specialCategory != undefined && specialCategory != null) {
                $http.post(url, specialCategory).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('special-category-created', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No SpecialCategory ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing SpecialCategory object.
         *
         * @param  {SpecialCategory} specialCategory An SpecialCategory object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no SpecialCategory data is provided then the method returns null.
         */
        function save(specialCategory, callback) {
            var deferred = $q.defer();
            if (specialCategory && specialCategory.id) {
                $http.put(url + specialCategory.id, specialCategory).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('special-category-saved', response.data);
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
