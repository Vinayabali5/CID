/**
 * This is the factory definition for the Subject Data Service. This defines how to handle data about Subject objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */


(function() {
    'use strict';

    angular
        .module('SubjectService', ['cid.app.constants', 'ui-notification'])
        .factory('Subject', subjectFactory);

    subjectFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function subjectFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/subjects/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the Subject from the API collection.
         *
         * @return {Subject} An array of Subject objects.
         */
        function getAll(options) {
            var deferred = $q.defer();
            var reqParams = {};
            if (options) {
                if (options.page) {
                    reqParams.page = options.page;
                }
                if (options.size) {
                    reqParams.size = options.size;
                }
            }
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('subject-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a Subject from the API collection.
         * @param  {int} id of the Subject object that is to be retrieved.
         * @return {Subject} An Subject object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('subject-loaded', response.data);
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
         * This method is used to create a new instance of an Subject object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Subject} subject An Subject object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no subject data is provided then the method returns null.
         */
        function create(subject, callback) {
            var deferred = $q.defer();
            if (subject != undefined && subject != null) {
                $http.post(url, subject).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('subject-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Subject ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing Subject object.
         *
         * @param  {Subject} subject An Subject object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no subject data is provided then the method returns null.
         */
        function save(subject, callback) {
            var deferred = $q.defer();
            if (subject && subject.id) {
                $http.put(url + subject.id, subject).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('subject-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
                return deferred.promise;
            }
        }
    }
})();
