/**
 * This is the factory definition for the StudentLearningSupportCost Data Service. This defines how to handle data about StudentLearningSupportCost objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('StudentLearningSupportCostService', ['cid.app.constants', 'ui-notification'])
        .factory('LearningSupportCost', studentLearningSupportCostFactory);

    studentLearningSupportCostFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function studentLearningSupportCostFactory($q, $http, $rootScope, GLOBAL, Notification) {
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
         * This method is used to retrieve all the StudentLearningSupportCost from the API collection.
         *
         * @return {StudentLearningSupportCost} An array of StudentLearningSupportCost objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url + 'learningSupportCosts').then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('student-learning-support-costs-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }
        /**
         * This method is used to retrieve an instance of a StudentLearningSupportCost from the API collection.
         * @param  {int} id of the StudentLearningSupportCost object that is to be retrieved.
         * @return {StudentLearningSupportCost} An StudentLearningSupportCost object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + 'learningSupportCosts/' + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-learning-support-cost-loaded', response.data);
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
         * This method is used to retrieve an instance of a StudentLearningSupportCost from the API collection.
         * @param  {int} studentId of the StudentLearningSupportCost object that is to be retrieved.
         * @return {StudentLearningSupportCost} An StudentLearningSupportCost object as identified by the id.
         */
        function getByStudent(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + 'students/' + id + '/learningSupportCosts').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-learning-support-cost-loaded', response.data);
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
         * This method is used to create a new instance of an StudentLearningSupportCost object in the database by POSTing the
         * required data to the API.
         *
         * @param  {StudentLearningSupportCost} studentLearningSupportCost An StudentLearningSupportCost object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no StudentLearningSupportCost data is provided then the method returns null.
         */
        function create(studentLearningSupportCost, callback) {
            var deferred = $q.defer();
            if (studentLearningSupportCost != undefined && studentLearningSupportCost != null) {
                $http.post(url + 'learningSupportCosts', studentLearningSupportCost).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-learning-support-cost-create', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No StudentLearningSupportCost ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing School object.
         *
         * @param  {StudentLearningSupportCost} studentLearningSupportCost An StudentLearningSupportCost object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no School data is provided then the method returns null.
         */
        function save(studentLearningSupportCost, callback) {
            var deferred = $q.defer();
            if (studentLearningSupportCost && studentLearningSupportCost.id) {
                $http.put(url + 'learningSupportCosts/' + studentLearningSupportCost.id, studentLearningSupportCost).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-learning-support-cost-saved', response.data);
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
