/**
 * This is the factory definition for the RestrictedUseIndicator Data Service. This defines how to handle data about RestrictedUseIndicator objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('RestrictedUseIndicatorService', ['cid.app.constants', 'ui-notification'])
        .factory('RestrictedUseIndicator', restrictedUseIndicatorFactory);

    restrictedUseIndicatorFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function restrictedUseIndicatorFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/restrictedUseIndicators/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        //Private Interface
        /**
         * This method is used to retrieve all the RestrictedUseIndicator from the API collection.
         *
         * @return {RestrictedUseIndicator} An array of RestrictedUseIndicator objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('restricted-use-indicators-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a RestrictedUseIndicator from the API collection.
         * @param  {int} id of the RestrictedUseIndicator object that is to be retrieved.
         * @return {RestrictedUseIndicator} An RestrictedUseIndicator object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('restricted-use-indicator-loaded', response.data);
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
         * This method is used to create a new instance of an RestrictedUseIndicator object in the database by POSTing the
         * required data to the API.
         *
         * @param  {RestrictedUseIndicator} restrictedUseIndicator An RestrictedUseIndicator object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no RestrictedUseIndicator data is provided then the method returns null.
         */
        function create(restrictedUseIndicator, callback) {
            var deferred = $q.defer();
            if (restrictedUseIndicator != undefined && restrictedUseIndicator != null) {
                $http.post(url, restrictedUseIndicator).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('restricted-use-indicator-created', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No RestrictedUseIndicator ID Supplied"
                });
            }
            return deferred.promise;
        }
        /**
         * This method is used to save changes to an existing RestrictedUseIndicator object.
         *
         * @param  {RestrictedUseIndicator} restrictedUseIndicator An RestrictedUseIndicator object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no RestrictedUseIndicator data is provided then the method returns null.
         */
        function save(restrictedUseIndicator, callback) {
            var deferred = $q.defer();
            if (restrictedUseIndicator && restrictedUseIndicator.id) {
                $http.put(url + restrictedUseIndicator.id, restrictedUseIndicator).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('restricted-use-indicator-saved', response.data);
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
