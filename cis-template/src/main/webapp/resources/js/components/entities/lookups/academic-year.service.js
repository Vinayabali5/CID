/**
 * This is the factory definition for the AcademicYear Data Service. This defines how to handle data about AcademicYear objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('AcademicYearService', ['ui-notification'])
        .factory('AcademicYear', academicYearFactory);

    academicYearFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function academicYearFactory($q, $http, $rootScope, GLOBAL, Notification) {
        // Variable and Constants
        var url = GLOBAL.API + '/academic-years/';

        // Public Interface
        var factory = {
            query: getAll,
            get: getById,
            getCurrent: getCurrent,
            getNext: getNext,
            create: create,
            save: save

        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the AcademicYears from the API collection.
         *
         * @return {AcademicYear} An array of AcademicYear objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('academic-years-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method returns an individual AcademicYear object from the API based on the ID supplied.
         *
         * @param  {int} id The ID for the AcademicYear object to retrieve.
         * @return {AcademicYear} An AcademicYear object representation for year idefieid by the ID supplied.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('academic-years-loaded', response.data);
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
         * This method returns the "Current" AcademicYear.
         *
         * @return {AcademicYear} An AcademicYear object that represents the current academic year.
         */
        function getCurrent() {
            var deferred = $q.defer();
            $http.get(url + 'current').then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('academic-years-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        function getNext() {
            var deferred = $q.defer();
            $http.get(url + 'next').then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('academic-years-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to create a new instance of an AcademicYear object in the database by POSTing the
         * required data to the API.
         *
         * @param  {AcademicYear} academicYear An AcademicYear object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depnding on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no AcademicYear data is provided then the method returns null.
         */
        function create(academicYear, callback) {
            var deferred = $q.defer();
            if (academicYear != undefined && academicYear != null) {
                $http.post(url, academicYear).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('academic-year-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No AcademicYear ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing AcademicYear object.
         *
         * @param  {AcademicYear} academicYear An AcademicYear object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no AcademicYear data is provided then the method returns null.
         */
        function save(academicYear, callback) {
            var deferred = $q.defer();
            $http.put(url + academicYear.id, academicYear).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('academic-year-saved', response.data);
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
})();
