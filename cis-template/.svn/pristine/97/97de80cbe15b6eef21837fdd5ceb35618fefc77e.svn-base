/**
 * This is the factory definition for the BlockService Data Service. This defines how to handle data about BlockService objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('BlockService', ['ui-notification'])
        .factory('Block', blockFactory);

    blockFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function blockFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/blocks/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;

        //Private Interface
        /**
         * This method is used to retrieve all the BlockService from the API collection.       *
         * @return {BlockService} An array of BlockService objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('block-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a BlockService from the API collection.
         * @param  {int} id of the BlockService object that is to be retrieved.
         * @return {BlockService} An BlockService object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('block-loaded', response.data);
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
         * This method is used to create a new instance of an BlockService object in the database by POSTing the
         * required data to the API.
         *
         * @param  {BlockService} block An BlockService object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no BlockService data is provided then the method returns null.
         */
        function create(block, callback) {
            var deferred = $q.defer();
            if (block != undefined && block != null) {
                $http.post(url, block).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('block-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No BlockS ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing BlockService object.
         *
         * @param  {BlockService} block An BlockService object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no BlockService data is provided then the method returns null.
         */
        function save(block, callback) {
            var deferred = $q.defer();
            $http.put(url + block.id, block).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('block-saved', response.data);
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
