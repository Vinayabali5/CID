/**
 * This is the factory definition for the CompletionStatus Data Service. This defines how to handle data about CompletionStatus objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */


(function() {
    'use strict';

    angular
        .module('CompletionStatusService', ['ui-notification'])
        .factory('CompletionStatus', completionStatusFactory);

    completionStatusFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function completionStatusFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/completionStatuses/';

        // Public Interface
        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };


        return factory;

        //Private Interface
        /**
         * This method is used to retrieve all the CompletionStatus from the API collection.
         *
         * @return {CompletionStatus} An array of CompletionStatus objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('completion-statuses-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a CompletionStatus from the API collection.
         * @param  {int} id of the CompletionStatus object that is to be retrieved.
         * @return {CompletionStatus} An CompletionStatus object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('completion-status-loaded', response.data);
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
         * This method is used to create a new instance of an CompletionStatus object in the database by POSTing the
         * required data to the API.
         *
         * @param  {CompletionStatus} completionStatus An CompletionStatus object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no CompletionStatus data is provided then the method returns null.
         */
        function create(completionStatus, callback) {
            var deferred = $q.defer();
            if (completionStatus != undefined && completionStatus != null) {
                $http.post(url, completionStatus).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('completion-status-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No CompletionStatus ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing CompletionStatus object.
         *
         * @param  {CompletionStatus} completionStatus An CompletionStatus object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no CompletionStatus data is provided then the method returns null.
         */
        function save(completionStatus, callback) {
            var deferred = $q.defer();
            $http.put(url + completionStatus.id, completionStatus).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('completion-status-saved', response.data);
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
