/**
 * This is the factory definition for the LLDDHealthProblem Data Service. This defines how to handle data about LLDDHealthProblem objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('LLDDHealthProblemService', ['cid.app.constants', 'ui-notification'])
        .factory('LLDDHealthProblem', lldHealthProblemFactory);

    lldHealthProblemFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function lldHealthProblemFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/lLDDHealthProblems/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the LLDDHealthProblem from the API collection.
         *
         * @return {LLDDHealthProblem} An array of LLDDHealthProblem objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('lLDD-health-problem-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a LLDDHealthProblem from the API collection.
         * @param  {int} id of the LLDDHealthProblem object that is to be retrieved.
         * @return {LLDDHealthProblem} An LLDDHealthProblem object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('lLDD-health-problem-loaded', response.data);
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
         * This method is used to create a new instance of an LLDDHealthProblem object in the database by POSTing the
         * required data to the API.
         *
         * @param  {LLDDHealthProblem} lLDDHealthProblem An LLDDHealthProblem object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no LLDDHealthProblem data is provided then the method returns null.
         */
        function create(lLDDHealthProblem, callback) {
            var deferred = $q.defer();
            if (lLDDHealthProblem != undefined && lLDDHealthProblem != null) {
                $http.post(url, lLDDHealthProblem).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('lLDD-health-problem-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No LLDDHealthProblem ID Supplied"
                });
            }
            return deferred.promise;
        }


        /**
         * This method is used to save changes to an existing LLDDHealthProblem object.
         *
         * @param  {LLDDHealthProblem} lLDDHealthProblem An LLDDHealthProblem object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no LLDDHealthProblem data is provided then the method returns null.
         */
        function save(lLDDHealthProblem, callback) {
            var deferred = $q.defer();
            if (lLDDHealthProblem && lLDDHealthProblem.id) {
                $http.put(url + lLDDHealthProblem.id, lLDDHealthProblem).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('lLDD-health-problem-saved', response.data);
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
