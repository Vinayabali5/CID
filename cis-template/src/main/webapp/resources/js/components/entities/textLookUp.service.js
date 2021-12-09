/**
 * This is the factory definition for the textLookup Data Service. This defines how to handle data about textLookup objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */


(function() {
    'use strict';

    angular
        .module('TextLookupService', ['cid.app.constants', 'ui-notification'])
        .factory('TextLookup', textLookupFactory);

    textLookupFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function textLookupFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/text-lookup/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the textLookup from the API collection.
         *
         * @return {textLookup} An array of textLookup objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('textLookup-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a textLookup from the API collection.
         * @param  {int} id of the textLookup object that is to be retrieved.
         * @return {textLookup} An textLookup object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('textLookup-loaded', response.data);
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
         * This method is used to create a new instance of an textLookup object in the database by POSTing the
         * required data to the API.
         *
         * @param  {textLookup} textLookup An textLookup object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no textLookup data is provided then the method returns null.
         */
        function create(textLookup, callback) {
            var deferred = $q.defer();
            if (textLookup) {
                $http.post(url, textLookup).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('textLookup-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No TextLookup ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing textLookup object.
         *
         * @param  {textLookup} textLookup An textLookup object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no textLookup data is provided then the method returns null.
         */
        function save(textLookup, callback) {
            var deferred = $q.defer();
            if (textLookup && textLookup.id) {
                $http.put(url + textLookup.id, textLookup).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('textLookup-saved', response.data);
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
