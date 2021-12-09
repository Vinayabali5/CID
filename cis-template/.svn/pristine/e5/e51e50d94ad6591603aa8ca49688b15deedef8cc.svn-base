/**
 * This is the factory definition for the RiskLevel Data Service. This defines how to handle data about RiskLevel objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('RiskLevelService', ['ui-notification'])
        .factory('RiskLevel', riskLevelFactory);

    riskLevelFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function riskLevelFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/risk-levels/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the RiskLevel from the API collection.
         *
         * @return {RiskLevel} An array of RiskLevel objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('riskLevels-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }


        /**
         * This method is used to retrieve an instance of a RiskLevel from the API collection.
         * @param  {int} id of the RiskLevel object that is to be retrieved.
         * @return {RiskLevel} An RiskLevel object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('riskLevel-loaded', response.data);
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
         * This method is used to create a new instance of an RiskLevel object in the database by POSTing the
         * required data to the API.
         *
         * @param  {RiskLevel} riskLevel An RiskLevel object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no RiskLevel data is provided then the method returns null.
         */
        function create(riskLevel, callback) {
            var deferred = $q.defer();
            if (riskLevel != undefined && riskLevel != null) {
                $http.post(url, riskLevel).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('riskLevel-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No RiskLevel ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing RiskLevel object.
         *
         * @param  {RiskLevel} riskLevel An RiskLevel object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no RiskLevel data is provided then the method returns null.
         */
        function save(riskLevel, callback) {
            var deferred = $q.defer();
            if (riskLevel && riskLevel.id) {
                $http.put(url + riskLevel.id, riskLevel).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('riskLevel-saved', response.data);
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
