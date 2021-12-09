/**
 * This is the factory definition for the Request Data Service. This defines how to handle data about Request objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('RequestService', ['cid.app.constants', 'ui-notification'])
        .factory('Request', requestFactory);

    requestFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function requestFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/';

        var factory = {
            query: getAll,
            get: getById,
            getByStudentId: getByStudentId,
            delete: deleteById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the Request from the API collection.
         *
         * @return {Request} An array of Request objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url + 'requests/').then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('requests-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a Request from the API collection.
         * @param  {int} id of the Request object that is to be retrieved.
         * @return {Request} An Request object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + 'requests/' + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('request-loaded', response.data);
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
         * This method is used to retrieve an instance of a Request from the API collection.
         * @param  {int} id of the Request object that is to be retrieved.
         * @return {Request} An Request object as identified by the id.
         */
        function getByStudentId(studentId) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.get(url + 'students/' + studentId + '/request').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('request-loaded', response.data);
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
         * This method is used to create a new instance of an Request object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Request} request An Request object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Request data is provided then the method returns null.
         */
        function create(request, callback) {
            var deferred = $q.defer();
            if (request != undefined && request != null) {
                $http.post(url + 'requests', request).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('request-created', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error: Course Requests already exists");
                });
            } else {
                deferred.reject({
                    message: "No Request ID Supplied"
                });
            }
            return deferred.promise;
        }
        /**
         * This method is used to save changes to an existing Request object.
         *
         * @param  {Request} request An Request object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Request data is provided then the method returns null.
         */
        function save(request, callback) {
            var deferred = $q.defer();
            if (request && request.id) {
                $http.put(url + 'requests/' + request.id, request).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('request-saved', response.data);
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
         * This method is used to delete an instance of a Request from the API collection.
         * @param  {int} requestId of the Request object that is to be retrieved.
         * @return {Request} An Request object as identified by the requestId.
         */
        function deleteById(requestId) {
            var deferred = $q.defer();
            if (requestId) {
                $http.delete(url + 'requests/' + requestId).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('request-deleted', response.data);
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
