/**
 * This is the factory definition for the LegalSex Data Service. This defines how to handle data about LegalSex objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('LegalSexService', ['ui-notification'])
        .factory('LegalSex', legalSexFactory);

    legalSexFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function legalSexFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/legal-sex/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the LegalSex from the API collection.
         *
         * @return {LegalSex} An array of LegalSex objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('legal-sex-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }


        /**
         * This method is used to retrieve an instance of a LegalSex from the API collection.
         * @param  {int} id of the LegalSex object that is to be retrieved.
         * @return {LegalSex} An LegalSex object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('legal-sex-loaded', response.data);
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
         * This method is used to create a new instance of an LegalSex object in the database by POSTing the
         * required data to the API.
         *
         * @param  {LegalSex} legalSex An LegalSex object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no LegalSex data is provided then the method returns null.
         */
        function create(legalSex, callback) {
            var deferred = $q.defer();
            if (legalSex != undefined && legalSex != null) {
                $http.post(url, legalSex).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('legal-sex-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Legal sex ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing LegalSex object.
         *
         * @param  {LegalSex} legalSex An LegalSex object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no LegalSex data is provided then the method returns null.
         */
        function save(legalSex, callback) {
            var deferred = $q.defer();
            if (legalSex && legalSex.id) {
                $http.put(url + legalSex.id, legalSex).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('legal-sex-saved', response.data);
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
