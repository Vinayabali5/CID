/**
 * This is the factory definition for the Faculty Data Service. This defines how to handle data about Faculty objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('FacultyService', ['cid.app.constants', 'ui-notification'])
        .factory('Faculty', facultyFactory);

    facultyFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function facultyFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/faculties/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        //Private Interface
        /**
         * This method is used to retrieve all the Faculty from the API collection.
         *
         * @return {Faculty} An array of Faculty objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('faculties-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a Faculty from the API collection.
         * @param  {int} id of the Faculty object that is to be retrieved.
         * @return {Faculty} An Faculty object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('faculty-loaded', response.data);
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
         * This method is used to create a new instance of an Faculty object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Faculty} faculty An Faculty object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Faculty data is provided then the method returns null.
         */
        function create(faculty, callback) {
            var deferred = $q.defer();
            if (faculty != undefined && faculty != null) {
                $http.post(url, faculty).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('faculty-created', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Faculty ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing Faculty object.
         *
         * @param  {Faculty} faculty An Course object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Faculty data is provided then the method returns null.
         */
        function save(faculty, callback) {
            var deferred = $q.defer();
            if (faculty && faculty.id) {
                $http.put(url + faculty.id, faculty).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('faculty-saved', response.data);
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
