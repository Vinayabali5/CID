/**
 * This is the factory definition for the EnglishConditionOfFunding Data Service. This defines how to handle data about EnglishConditionOfFunding objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('EnglishConditionOfFundingService', ['ui-notification'])
        .factory('EnglishConditionOfFunding', englishConditionOfFundingFactory);

    englishConditionOfFundingFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function englishConditionOfFundingFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/englishConditionOfFundings/';
        //Public Interface
        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;

        //Private Interface
        /**
         * This method is used to retrieve all the EnglishConditionOfFunding from the API collection.
         *
         * @return {EnglishConditionOfFunding} An array of EnglishConditionOfFunding objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('english-condition-of-funding-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a EnglishConditionOfFunding from the API collection.
         * @param  {int} id of the EnglishConditionOfFunding object that is to be retrieved.
         * @return {EnglishConditionOfFunding} An EnglishConditionOfFunding object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('english-condition-of-funding-loaded', response.data);
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
         * This method is used to create a new instance of an EnglishConditionOfFunding object in the database by POSTing the
         * required data to the API.
         *
         * @param  {EnglishConditionOfFunding} englishConditionOfFunding An EnglishConditionOfFunding object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no EnglishConditionOfFunding data is provided then the method returns null.
         */
        function create(englishConditionOfFunding, callback) {
            var deferred = $q.defer();
            if (englishConditionOfFunding != undefined && englishConditionOfFunding != null) {
                $http.post(url, englishConditionOfFunding).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('english-condition-of-funding-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No EnglishConditionOfFunding ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing EnglishConditionOfFunding object.
         *
         * @param  {EnglishConditionOfFunding} englishConditionOfFunding An EnglishConditionOfFunding object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no EnglishConditionOfFunding data is provided then the method returns null.
         */
        function save(englishConditionOfFunding, callback) {
            var deferred = $q.defer();
            if (englishConditionOfFunding && englishConditionOfFunding.id) {
                $http.put(url + englishConditionOfFunding.id, englishConditionOfFunding).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('english-condition-of-funding-saved', response.data);
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
