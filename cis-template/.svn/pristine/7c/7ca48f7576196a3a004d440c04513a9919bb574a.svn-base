/**
 * This is the factory definition for the InterimReport Data Service. This defines how to handle data about InterimReport objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('InterimReportService', ['cid.app.constants', 'ui-notification'])
        .factory('InterimReport', interimReportFactory);

    interimReportFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function interimReportFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/interimReports/';

        var factory = {
            query: getAll,
            get: getById,
            getCurrent: getCurrent,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the InterimReport from the API collection.
         *
         * @return {InterimReport} An array of InterimReport objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('interim-reports-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        function getCurrent() {
            var deferred = $q.defer();
            $http.get(url + 'current').then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('interim-reports-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }
        /**
         * This method is used to retrieve an instance of a InterimReport from the API collection.
         * @param  {int} id of the InterimReport object that is to be retrieved.
         * @return {InterimReport} An InterimReport object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('interim-reports-loaded', response.data);
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
         * This method is used to create a new instance of an InterimReport object in the database by POSTing the
         * required data to the API.
         *
         * @param  {InterimReport} interimReport An InterimReport object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no InterimReport data is provided then the method returns null.
         */
        function create(interimReport, callback) {
            var deferred = $q.defer();
            if (interimReport != undefined && interimReport != null) {
                $http.post(url, interimReport).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('interim-report-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No InterimReport ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing InterimReport object.
         *
         * @param  {InterimReport} interimReport An InterimReport object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no InterimReport data is provided then the method returns null.
         */
        function save(interimReport, callback) {
            var deferred = $q.defer();
            if (interimReport && interimReport.id) {
                $http.put(url + interimReport.id, interimReport).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('interim-report-saved', response.data);
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
