/**
 * This is the factory definition for the Outcome Data Service. This defines how to handle data about Outcome objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('OutcomeService', ['cid.app.constants', 'ui-notification'])
        .factory('Outcome', outcomeFactory);

    outcomeFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function outcomeFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/outcomes/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the Outcome from the API collection.
         *
         * @return {Outcome} An array of Outcome objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('outcomes-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a Outcome from the API collection.
         * @param  {int} id of the Outcome object that is to be retrieved.
         * @return {Outcome} An Outcome object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('outcomes-loaded', response.data);
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
         * This method is used to create a new instance of an Outcome object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Outcome} Outcome An Outcome object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Outcome data is provided then the method returns null.
         */
        function create(outcome, callback) {
            var deferred = $q.defer();
            if (outcome != undefined && outcome != null) {
                $http.post(url, outcome).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('outcome-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Outcome ID Supplied"
                });
            }
            return deferred.promise;
        }
        /**
         * This method is used to save changes to an existing Outcome object.
         *
         * @param  {Outcome} Outcome An Outcome object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Outcome data is provided then the method returns null.
         */
        function save(outcome, callback) {
            var deferred = $q.defer();
            if (outcome && outcome.id) {
                $http.put(url + outcome.id, outcome).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('outcome-saved', response.data);
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
