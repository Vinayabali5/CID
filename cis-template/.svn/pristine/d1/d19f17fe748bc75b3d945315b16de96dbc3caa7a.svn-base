/**
 * This is the factory definition for the StatementBank Data Service. This defines how to handle data about StatementBank objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('StatementBankService', ['cid.app.constants', 'ui-notification'])
        .factory('StatementBank', statementBankFactory);

    statementBankFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function statementBankFactory($q, $http, $rootScope, GLOBAL, Notification) {
        // Variable and Constants
        var url = GLOBAL.API + '/statement-bank/';

        // Public Interface
        var factory = {
            query: getAll,
            get: getById,
            getMassLetters: getMassLetters,
            create: create,
            save: save
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the StatementBanks from the API collection.
         *
         * @return {StatementBank} An array of StatementBank objects.
         */
        function getAll() {
            var deferred = $q.defer();
            var data;
            if (data == undefined) {
                $http.get(url).then(function(response) {
                    data = response;
                    deferred.resolve(response);
                    $rootScope.$emit('statement-bank-loaded', response.data);
                }, function(response) {
                    deferred.reject(response);
                });
                return deferred.promise;
            } else {
                return data;
            }
        }

        function getMassLetters() {
            var deferred = $q.defer();
            var data;
            if (data == undefined) {
                $http.get(url + "mass-letters").then(function(response) {
                    data = response;
                    deferred.resolve(response);
                    $rootScope.$emit('statement-bank-loaded', response.data);
                }, function(response) {
                    deferred.reject(response);
                });
                return deferred.promise;
            } else {
                return data;
            }
        }

        /**
         * This method is used to retrieve an instance of a StatementBank from the API collection.
         * @param  {int} id of the StatementBank object that is to be retrieved.
         * @return {StatementBank} An StatementBank object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('statement-bank--loaded', response.data);
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
         * This method is used to create a new instance of an StatementBank object in the database by POSTing the
         * required data to the API.
         *
         * @param  {StatementBank} statementBank An StatementBank object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no StatementBankType data is provided then the method returns null.
         */
        function create(statementBank, callback) {
            var deferred = $q.defer();
            if (statementBank != undefined && statementBank != null) {
                $http.post(url, statementBank).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('statement-bank--saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No StatemenetBank ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing StatementBank object.
         *
         * @param  {StatementBank} statementBank An StatementBank object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no StatementBankType data is provided then the method returns null.
         */
        function save(statementBank, callback) {
            var deferred = $q.defer();
            if (statementBank && statementBank.id) {
                $http.put(url + statementBank.id, statementBank).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('statement-bank-saved', response.data);
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
