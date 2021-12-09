/**
 * This is the factory definition for the Period Data Service. This defines how to handle data about Period objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('PeriodService', ['cid.app.constants', 'ui-notification'])
        .factory('Period', periodFactory);

    periodFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function periodFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/periods/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the Period from the API collection.
         *
         * @return {Period} An array of Period objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('period-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a Period from the API collection.
         * @param  {int} id of the Period object that is to be retrieved.
         * @return {Period} An Period object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('period-loaded', response.data);
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
         * This method is used to create a new instance of an Period object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Period} period An Period object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Period data is provided then the method returns null.
         */
        function create(period, callback) {
            var deferred = $q.defer();
            if (period) {
                $http.post(url, period).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('period-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Period ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing Period object.
         *
         * @param  {Period} period An Period object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Period data is provided then the method returns null.
         */
        function save(period, callback) {
            var deferred = $q.defer();
            if (period && period.id) {
                $http.put(url + period.id, period).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('period-saved', response.data);
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
