/**
 * This is the factory definition for the ReportingPeriod Data Service. This defines how to handle data about ReportingPeriod objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('ReportingPeriodService', ['cid.app.constants', 'ui-notification'])
        .factory('ReportingPeriod', reportingPeriodFactory);

    reportingPeriodFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function reportingPeriodFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/reportingPeriods/';
        //Public Interface
        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save,
            getByYear: getByYear
        };

        return factory;

        //Private Interface
        /**
         * This method is used to retrieve all the ReportingPeriod from the API collection.
         *
         * @return {ReportingPeriod} An array of ReportingPeriod objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('reportingPeriods-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve all the ReportingPeriod from the API collection of current year.
         *
         * @return {ReportingPeriod} An array of ReportingPeriod objects.
         */
        function getByYear() {
            var deferred = $q.defer();
            $http.get(url + 'years').then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('reportingPeriods-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }
        /**
         * This method is used to retrieve an instance of a ReportingPeriod from the API collection.
         * @param  {int} id of the ReportingPeriod object that is to be retrieved.
         * @return {ReportingPeriod} An ReportingPeriod object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('reportingPeriods-loaded', response.data);
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
         * This method is used to create a new instance of an ReportingPeriod object in the database by POSTing the
         * required data to the API.
         *
         * @param  {ReportingPeriod} reportingPeriod An ReportingPeriod object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no ReportingPeriod data is provided then the method returns null.
         */
        function create(reportingPeriod, callback) {
            var deferred = $q.defer();
            if (reportingPeriod != undefined && reportingPeriod != null) {
                $http.post(url, reportingPeriod).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('reportingPeriods-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No ReportingPeriod ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing ReportingPeriod object.
         *
         * @param  {ReportingPeriod} reportingPeriod An ReportingPeriod object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no ReportingPeriod data is provided then the method returns null.
         */
        function save(reportingPeriod, callback) {
            var deferred = $q.defer();
            if (reportingPeriod && reportingPeriod.id) {
                $http.put(url + reportingPeriod.id, reportingPeriod).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('reportingPeriods-saved', response.data);
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
