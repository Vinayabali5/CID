/**
 * This is the factory definition for the FundingModel Data Service. This defines how to handle data about FundingModel objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('FundingModelService', ['cid.app.constants', 'ui-notification'])
        .factory('FundingModel', fundingModelFactory);

    fundingModelFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function fundingModelFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/fundingModels/';
        //Public Interface
        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the FundingModel from the API collection.
         *
         * @return {FundingModel} An array of FundingModel objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('funding-models-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a FundingModel from the API collection.
         * @param  {int} id of the FundingModel object that is to be retrieved.
         * @return {FundingModel} An FundingModel object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('funding-model-loaded', response.data);
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
         * This method is used to create a new instance of an FundingModel object in the database by POSTing the
         * required data to the API.
         *
         * @param  {FundingModel} fundingModel An FundingModel object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no FundingModel data is provided then the method returns null.
         */
        function create(fundingModel, callback) {
            var deferred = $q.defer();
            if (fundingModel != undefined && fundingModel != null) {
                $http.post(url, fundingModel).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('funding-model-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No FundingModel ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing FundingModel object.
         *
         * @param  {FundingModel} fundingModel An FundingModel object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no FundingModel data is provided then the method returns null.
         */
        function save(fundingModel, callback) {
            var deferred = $q.defer();
            if (fundingModel && fundingModel.id) {
                $http.put(url + fundingModel.id, fundingModel).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('funding-model-saved', response.data);
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
