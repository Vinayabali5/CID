/**
 * This is the factory definition for the StudentLearningSupportVisit Data Service. This defines how to handle data about StudentLearningSupportVisit objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('StudentLearningSupportVisitService', ['cid.app.constants', 'ui-notification'])
        .factory('LearningSupportVisit', studentLearningSupportVisitFactory);

    studentLearningSupportVisitFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function studentLearningSupportVisitFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/';

        var factory = {
            query: getAll,
            get: getById,
            getByStudent: getByStudent,
            create: create,
            save: save
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the StudentLearningSupportVisit from the API collection.
         *
         * @return {StudentLearningSupportVisit} An array of StudentLearningSupportVisit objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url + 'learningSupportVisits').then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('learning-support-visit-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }
        /**
         * This method is used to retrieve an instance of a StudentLearningSupportVisit from the API collection.
         * @param  {int} id of the StudentLearningSupportVisit object that is to be retrieved.
         * @return {StudentLearningSupportVisit} An StudentLearningSupportVisit object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + 'learningSupportVisits/' + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('learning-support-visit-loaded', response.data);
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
         * This method is used to retrieve an instance of a StudentLearningSupportVisit from the API collection.
         * @param  {int} studentId of the StudentLearningSupportVisit object that is to be retrieved.
         * @return {StudentLearningSupportVisit} An StudentLearningSupportVisit object as identified by the id.
         */
        function getByStudent(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + 'students/' + id + '/learningSupportVisits').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('learning-support-visit-loaded', response.data);
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
         * This method is used to create a new instance of an StudentLearningSupportVisit object in the database by POSTing the
         * required data to the API.
         *
         * @param  {StudentLearningSupportVisit} studentLearningSupportVisit An StudentLearningSupportVisit object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no StudentLearningSupportVisit data is provided then the method returns null.
         */
        function create(studentLearningSupportVisit, callback) {
            var deferred = $q.defer();
            if (studentLearningSupportVisit != undefined && studentLearningSupportVisit != null) {
                $http.post(url + 'learningSupportVisits', studentLearningSupportVisit).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('learning-support-visit-created', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No StudentLearningSupportVisit ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing School object.
         *
         * @param  {StudentLearningSupportVisit} studentLearningSupportVisit An StudentLearningSupportVisit object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no School data is provided then the method returns null.
         */
        function save(studentLearningSupportVisit, callback) {
            var deferred = $q.defer();
            if (studentLearningSupportVisit && studentLearningSupportVisit.id) {
                $http.put(url + 'learningSupportVisits/' + studentLearningSupportVisit.id, studentLearningSupportVisit).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('learning-support-visit-saved', response.data);
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
