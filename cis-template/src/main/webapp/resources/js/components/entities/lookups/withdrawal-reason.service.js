/**
 * This is the factory definition for the WithdrawalReason Data Service. This defines how to handle data about WithdrawalReason objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('WithdrawalReasonService', ['cid.app.constants', 'ui-notification'])
        .factory('WithdrawalReason', withdrawalReasonFactory);

    withdrawalReasonFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function withdrawalReasonFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/withdrawalReasons/';
        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface
        /**
         * This method is used to retrieve all the WithdrawalReason from the API collection.
         *
         * @return {WithdrawalReason} An array of WithdrawalReason objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('withdrawal-reasons-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }


        /**
         * This method is used to retrieve an instance of a WithdrawalReason from the API collection.
         * @param  {int} id of the WithdrawalReason object that is to be retrieved.
         * @return {WithdrawalReason} An WithdrawalReason object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('withdrawal-reason-loaded', response.data);
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
         * This method is used to create a new instance of an WithdrawalReason object in the database by POSTing the
         * required data to the API.
         *
         * @param  {WithdrawalReason} withdrawalReason An WithdrawalReason object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no withdrawalReason data is provided then the method returns null.
         */
        function create(withdrawalReason, callback) {
            var deferred = $q.defer();
            if (withdrawalReason != undefined && withdrawalReason != null) {
                $http.post(url, withdrawalReason).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('withdrawal-reason-created', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No WithdrawalReason ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing WithdrawalReason object.
         *
         * @param  {WithdrawalReason} withdrawalReason An WithdrawalReason object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no withdrawalReason data is provided then the method returns null.
         */
        function save(withdrawalReason, callback) {
            var deferred = $q.defer();
            if (withdrawalReason && withdrawalReason.id) {
                $http.put(url + withdrawalReason.id, withdrawalReason).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('withdrawal-reason-created', response.data);
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
