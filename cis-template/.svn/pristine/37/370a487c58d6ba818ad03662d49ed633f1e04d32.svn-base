/**
 * This is the factory definition for the StudentType Data Service. This defines how to handle data about StudentType objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('StudentTypeService', ['cid.app.constants', 'ui-notification'])
        .factory('StudentType', studentTypeFactory);

    studentTypeFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function studentTypeFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/studentTypes/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the StudentType from the API collection.
         *
         * @return {StudentType} An array of StudentType objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('student-types-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }
        /**
         * This method is used to retrieve an instance of a StudentType from the API collection.
         * @param  {int} id of the StudentType object that is to be retrieved.
         * @return {StudentType} An StudentType object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-type-loaded', response.data);
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
         * This method is used to create a new instance of an StudentType object in the database by POSTing the
         * required data to the API.
         *
         * @param  {StudentType} studentType An StudentType object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no studentType data is provided then the method returns null.
         */
        function create(studentType, callback) {
            var deferred = $q.defer();
            if (studentType != undefined && studentType != null) {
                $http.post(url, studentType).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-type-created', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No StudentType ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing StudentType object.
         *
         * @param  {StudentType} studentType An StudentType object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no studentType data is provided then the method returns null.
         */
        function save(studentType, callback) {
            var deferred = $q.defer();
            if (studentType && studentType.id) {
                $http.put(url + studentType.id, studentType).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-type-saved', response.data);
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
