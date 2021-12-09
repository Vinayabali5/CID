/**
 * This is the factory definition for the YearGroup Data Service. This defines how to handle data about YearGroup objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('YearGroupService', ['cid.app.constants', 'ui-notification'])
        .factory('YearGroup', yearGroupFactory);

    yearGroupFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function yearGroupFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/yearGroups/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the YearGroup from the API collection.
         *
         * @return {YearGroup} An array of YearGroup objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('year-groups-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a YearGroup from the API collection.
         * @param  {int} id of the YearGroup object that is to be retrieved.
         * @return {YearGroup} An YearGroup object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('year-group-loaded', response.data);
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
         * This method is used to create a new instance of an YearGroup object in the database by POSTing the
         * required data to the API.
         *
         * @param  {YearGroup} yearGroup An YearGroup object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no yearGroup data is provided then the method returns null.
         */
        function create(yearGroup, callback) {
            var deferred = $q.defer();
            if (yearGroup != undefined && yearGroup != null) {
                $http.post(url, yearGroup).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('year-group-created', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No YearGroup ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing YearGroup object.
         *
         * @param  {YearGroup} yearGroup An YearGroup object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no yearGroup data is provided then the method returns null.
         */
        function save(yearGroup, callback) {
            var deferred = $q.defer();
            if (yearGroup && yearGroup.id) {
                $http.put(url + yearGroup.id, yearGroup).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('year-group-saved', response.data);
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
