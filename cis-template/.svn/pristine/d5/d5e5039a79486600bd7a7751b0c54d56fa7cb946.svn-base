/**
 * This is the factory definition for the SourceOfFunding Data Service. This defines how to handle data about SourceOfFunding objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('SourceOfFundingService', ['cid.app.constants', 'ui-notification'])
        .factory('SourceOfFunding', sourceOfFundingFactory);

    sourceOfFundingFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function sourceOfFundingFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/sourceOfFundings/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the SourceOfFunding from the API collection.
         *
         * @return {SourceOfFunding} An array of SourceOfFunding objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('source-of-fundings-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }


        /**
         * This method is used to retrieve an instance of a SourceOfFunding from the API collection.
         * @param  {int} id of the SourceOfFunding object that is to be retrieved.
         * @return {SourceOfFunding} An SourceOfFunding object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('source-of-funding-loaded', response.data);
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
         * This method is used to create a new instance of an SourceOfFunding object in the database by POSTing the
         * required data to the API.
         *
         * @param  {SourceOfFunding} sourceOfFunding An SourceOfFunding object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no SourceOfFunding data is provided then the method returns null.
         */
        function create(sourceOfFunding, callback) {
            var deferred = $q.defer();
            if (sourceOfFunding != undefined && sourceOfFunding != null) {
                $http.post(url, sourceOfFunding).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('source-of-funding-created', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No SourceOfFunding ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing SourceOfFunding object.
         *
         * @param  {SourceOfFunding} sourceOfFunding An SourceOfFunding object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no SourceOfFunding data is provided then the method returns null.
         */
        function save(sourceOfFunding, callback) {
            var deferred = $q.defer();
            if (sourceOfFunding && sourceOfFunding.id) {
                $http.put(url + sourceOfFunding.id, sourceOfFunding).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('source-of-funding-saved', response.data);
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
