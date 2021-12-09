/**
 * This is the factory definition for the InsetCourse Data Service. This defines how to handle data about InsetCourse objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('InsetCourseService', ['ui-notification'])
        .factory('InsetCourse', insetCourseFactory);

    insetCourseFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function insetCourseFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/inset-courses/';
        // Public Interface
        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the InsetCourse from the API collection.
         *
         * @return {InsetCourse} An array of InsetCourse objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('insetCourse-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a InsetCourse from the API collection.
         * @param  {int} id of the InsetCourse object that is to be retrieved.
         * @return {InsetCourse} An InsetCourse object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('insetCourse-loaded', response.data);
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
         * This method is used to create a new instance of an InsetCourse object in the database by POSTing the
         * required data to the API.
         *
         * @param  {InsetCourse} insetCourse An InsetCourse object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no InsetCourse data is provided then the method returns null.
         */
        function create(insetCourse, callback) {
            var deferred = $q.defer();
            if (insetCourse != undefined && insetCourse != null) {
                $http.post(url, insetCourse).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('insetCourse-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No InsetCourse ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing InsetCourse object.
         *
         * @param  {InsetCourse} insetCourse An InsetCourse object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no InsetCourse data is provided then the method returns null.
         */
        function save(insetCourse, callback) {
            var deferred = $q.defer();
            if (insetCourse && insetCourse.id) {
                $http.put(url + insetCourse.id, insetCourse).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('insetCourse-saved', response.data);
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
