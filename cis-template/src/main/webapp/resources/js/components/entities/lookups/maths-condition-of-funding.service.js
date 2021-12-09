/**
 * This is the factory definition for the MathsConditionOfFunding Data Service. This defines how to handle data about MathsConditionOfFunding objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('MathsConditionOfFundingService', ['cid.app.constants', 'ui-notification'])
        .factory('MathsConditionOfFunding', mathsConditionOfFundingFactory);

    mathsConditionOfFundingFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function mathsConditionOfFundingFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/mathsConditionOfFundings/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the MathsConditionOfFunding from the API collection.
         *
         * @return {MathsConditionOfFunding} An array of MathsConditionOfFunding objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('maths-condition-of-fundings-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }


        /**
         * This method is used to retrieve an instance of a MathsConditionOfFunding from the API collection.
         * @param  {int} id of the MathsConditionOfFunding object that is to be retrieved.
         * @return {MathsConditionOfFunding} An MathsConditionOfFunding object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('maths-condition-of-funding-loaded', response.data);
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
         * This method is used to create a new instance of an MathsConditionOfFunding object in the database by POSTing the
         * required data to the API.
         *
         * @param  {MathsConditionOfFunding} mathsConditionOfFunding An MathsConditionOfFunding object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no MathsConditionOfFunding data is provided then the method returns null.
         */
        function create(mathsConditionOfFunding, callback) {
            var deferred = $q.defer();
            if (mathsConditionOfFunding != undefined && mathsConditionOfFunding != null) {
                $http.post(url, mathsConditionOfFunding).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('maths-condition-of-funding-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No MathsConditionOfFunding ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing MathsConditionOfFunding object.
         *
         * @param  {MathsConditionOfFunding} mathsConditionOfFunding An MathsConditionOfFunding object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no MathsConditionOfFunding data is provided then the method returns null.
         */
        function save(mathsConditionOfFunding, callback) {
            var deferred = $q.defer();
            if (mathsConditionOfFunding && mathsConditionOfFunding.id) {
                $http.put(url + mathsConditionOfFunding.id, mathsConditionOfFunding).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('maths-condition-of-funding-saved', response.data);
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
