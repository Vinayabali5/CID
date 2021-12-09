/**
 * This is the factory definition for the Holiday Data Service. This defines how to handle data about Holiday objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('HolidayService', ['ui-notification'])
        .factory('Holiday', holidayFactory);

    holidayFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function holidayFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/holidays/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the Holiday from the API collection.
         *
         * @return {Holiday} An array of Holiday objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('holidays-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a Holiday from the API collection.
         * @param  {int} id of the Holiday object that is to be retrieved.
         * @return {Holiday} An Holiday object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('holiday-loaded', response.data);
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
         * This method is used to create a new instance of an Holiday object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Holiday} holiday An Holiday object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Holiday data is provided then the method returns null.
         */
        function create(holiday, callback) {
            var deferred = $q.defer();
            if (holiday != undefined && holiday != null) {
                $http.post(url, holiday).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('holiday-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Holiday ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing Holiday object.
         *
         * @param  {Holiday} holiday An Holiday object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Holiday data is provided then the method returns null.
         */
        function save(holiday, callback) {
            var deferred = $q.defer();
            if (holiday && holiday.id) {
                $http.put(url + holiday.id, holiday).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('holiday-saved', response.data);
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
