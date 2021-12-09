/**
 * This is the factory definition for the StudentEntryQualification Data Service. This defines how to handle data about StudentEntryQualification objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('StudentEntryQualificationService', ['cid.app.constants', 'ui-notification'])
        .factory('StudentEntryQualification', studentEntryQualificationFactory);

    studentEntryQualificationFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function studentEntryQualificationFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/';
        //Public Interface
        var factory = {
            query: getAll,
            get: getById,
            entryQualification: getEntryQualification,
            delete: deleteById,
            create: create,
            save: save,
            markChecked: markChecked
        };
        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the StudentEntryQualification from the API collection.
         *
         * @return {StudentEntryQualification} An array of StudentEntryQualification objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('student-entry-qualifications-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an collection of StudentEntryQualification entities from the API collection.
         * @param  {int} studentEntryQualificationId of the StudentEntryQualification object that is to be retrieved.
         * @return {StudentEntryQualification} An StudentEntryQualification object as identified by the id.
         */
        function getById(studentEntryQualificationId) {
            var deferred = $q.defer();
            if (studentEntryQualificationId != undefined && studentEntryQualificationId != null) {
                $http.get(url + 'students/' + studentEntryQualificationId + '/entryQualifications').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-entry-qualifications-loaded', response.data);
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
         * This method is used to retrieve an instance of a StudentEntryQualification from the API collection.
         * @param  {int} studentEntryQualificationId of the StudentEntryQualification object that is to be retrieved.
         * @return {StudentEntryQualification} An StudentEntryQualification object as identified by the id.
         */
        function getEntryQualification(studentEntryQualificationId) {
            var deferred = $q.defer();
            $http.get(url + 'studentEntryQualifications/' + studentEntryQualificationId).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('student-entry-qualifications-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to delete an instance of a StudentEntryQualification from the API collection.
         * @param  {int} studentEntryQualificationId of the StudentEntryQualification object that is to be retrieved.
         * @return {StudentEntryQualification} An StudentEntryQualification object as identified by the studentEntryQualificationId.
         */
        function deleteById(studentEntryQualificationId) {
            var deferred = $q.defer();
            if (studentEntryQualificationId) {
                $http.delete(url + 'studentEntryQualifications/' + studentEntryQualificationId).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('entry-qualification-changed', response.data);
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
         * This method is used to create a new instance of an StudentEntryQualification object in the database by POSTing the
         * required data to the API.
         *
         * @param  {StudentEntryQualification} studentEntryQualification An StudentEntryQualification object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no studentEntryQualification data is provided then the method returns null.
         */
        function create(studentEntryQualification, callback) {
            var deferred = $q.defer();
            if (studentEntryQualification) {
                $http.post(url + 'studentEntryQualifications', studentEntryQualification).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('entry-qualification-changed', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No studentEntryQualification ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing StudentEntryQualification object.
         *
         * @param  {StudentEntryQualification} studentEntryQualification An StudentEntryQualification object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no studentEntryQualification data is provided then the method returns null.
         */
        function save(studentEntryQualification, callback) {
            var deferred = $q.defer();
            if (studentEntryQualification && studentEntryQualification.studentEntryQualificationId) {
                $http.put(url + 'studentEntryQualifications/' + studentEntryQualification.studentEntryQualificationId, studentEntryQualification).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('entry-qualification-changed', response.data);
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
         * This method is used to mark all the Student EntryQualification checked.
         * @param  {int} studentId of the List of StudentEntryQualification object that is to be retrieved.
         * @return {StudentEntryQualification} An StudentEntryQualification object as identified by the id.
         */
        function markChecked(studentId) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.put(url + 'students/' + studentId + '/studentEntryQualificationsChecked').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('entryQualification-saved', response.data);
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
