/**
 * This is the factory definition for the SchoolPriority Data Service. This defines how to handle data about SchoolPriority objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('SchoolPriorityService', ['cid.app.constants', 'ui-notification'])
        .factory('SchoolPriority', schoolPriorityFactory);

    schoolPriorityFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function schoolPriorityFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/schoolPriorities/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the SchoolPriority from the API collection.
         *
         * @return {SchoolPriority} An array of SchoolPriority objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('school-priorities-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a SchoolPriority from the API collection.
         * @param  {int} id of the SchoolPriority object that is to be retrieved.
         * @return {SchoolPriority} An SchoolPriority object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('school-priority-loaded', response.data);
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
         * This method is used to create a new instance of an SchoolPriority object in the database by POSTing the
         * required data to the API.
         *
         * @param  {SchoolPriority} schoolPriority An SchoolPriority object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no SchoolPriority data is provided then the method returns null.
         */
        function create(schoolPriority, callback) {
            var deferred = $q.defer();
            if (schoolPriority != undefined && schoolPriority != null) {
                $http.post(url, schoolPriority).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('school-priority-created', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No SchoolPriority ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing SchoolPriority object.
         *
         * @param  {SchoolPriority} schoolPriority An SchoolPriority object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no SchoolPriority data is provided then the method returns null.
         */
        function save(schoolPriority, callback) {
            var deferred = $q.defer();
            if (schoolPriority && schoolPriority.id) {
                $http.put(url + schoolPriority.id, schoolPriority).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('school-priority-saved', response.data);
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
