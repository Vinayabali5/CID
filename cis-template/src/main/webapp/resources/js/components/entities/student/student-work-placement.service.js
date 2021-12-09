/**
 * This is the factory definition for the StudentWorkPlacement Data Service. This defines how to handle data about StudentWorkPlacement objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('StudentWorkPlacementService', ['cid.app.constants', 'ui-notification'])
        .factory('StudentWorkPlacement', studentWorkPlacementFactory);

    studentWorkPlacementFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function studentWorkPlacementFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/';
        //Public Interface
        var factory = {
            query: getAll,
            get: getById,
            getByStudentId: getByStudentId,
            create: create,
            save: save
        };
        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the StudentWorkPlacement from the API collection.
         *
         * @return {StudentWorkPlacement} An array of StudentWorkPlacement objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url + 'work-placements').then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('student-work-placements-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an collection of StudentWorkPlacement entities from the API collection.
         * @param  {int} studentWorkPlacementId of the StudentWorkPlacement object that is to be retrieved.
         * @return {StudentWorkPlacement} An StudentWorkPlacement object as identified by the id.
         */
        function getByStudentId(studentId) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.get(url + 'students/' + studentId + '/work-placements').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-work-placements-loaded', response.data);
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
         * This method is used to retrieve an instance of a StudentWorkPlacement from the API collection.
         * @param  {int} studentWorkPlacementId of the StudentWorkPlacement object that is to be retrieved.
         * @return {StudentWorkPlacement} An StudentWorkPlacement object as identified by the id.
         */
        function getById(studentWorkPlacementId) {
            var deferred = $q.defer();
            $http.get(url + 'work-placements/' + studentWorkPlacementId).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('student-work-placements-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to create a new instance of an StudentWorkPlacement object in the database by POSTing the
         * required data to the API.
         *
         * @param  {StudentWorkPlacement} studentWorkPlacement An StudentWorkPlacement object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no studentWorkPlacement data is provided then the method returns null.
         */
        function create(studentWorkPlacement, callback) {
            var deferred = $q.defer();
            if (studentWorkPlacement) {
                $http.post(url + 'work-placements', studentWorkPlacement).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('work-placement-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No studentWorkPlacement ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing StudentWorkPlacement object.
         *
         * @param  {StudentWorkPlacement} studentWorkPlacement An StudentWorkPlacement object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no studentWorkPlacement data is provided then the method returns null.
         */
        function save(studentWorkPlacement, callback) {
            var deferred = $q.defer();
            if (studentWorkPlacement && studentWorkPlacement.id) {
                $http.put(url + 'work-placements/' + studentWorkPlacement.id, studentWorkPlacement).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('work-placement-saved', response.data);
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
