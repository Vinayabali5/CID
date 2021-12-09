/**
 * This is the factory definition for the School Data Service. This defines how to handle data about School objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('SchoolService', ['cid.app.constants', 'ui-notification'])
        .factory('School', schoolFactory);

    schoolFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function schoolFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/schools/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the School from the API collection.
         *
         * @return {School} An array of School objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('schools-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a School from the API collection.
         * @param  {int} id of the School object that is to be retrieved.
         * @return {School} An School object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('school-loaded', response.data);
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
         * This method is used to create a new instance of an School object in the database by POSTing the
         * required data to the API.
         *
         * @param  {School} school An School object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no School data is provided then the method returns null.
         */
        function create(school, callback) {
            var deferred = $q.defer();
            if (school != undefined && school != null) {
                $http.post(url, school).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('school-created', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No School ID Supplied"
                });
            }
            return deferred.promise;
        }
        /**
         * This method is used to save changes to an existing School object.
         *
         * @param  {School} school An School object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no School data is provided then the method returns null.
         */
        function save(school, callback) {
            var deferred = $q.defer();
            if (school && school.id) {
                $http.put(url + school.id, school).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('school-saved', response.data);
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
