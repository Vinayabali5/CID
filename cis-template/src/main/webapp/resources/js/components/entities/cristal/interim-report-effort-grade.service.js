/**
 * This is the factory definition for the InterimReportEffortGrade Data Service. This defines how to handle data about InterimReportEffortGrade objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('InterimReportEffortGradeService', ['cid.app.constants', 'ui-notification'])
        .factory('InterimReportEffortGrade', interimReportEffortGradeFactory);

    interimReportEffortGradeFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function interimReportEffortGradeFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/interim-report-effort-grades/';
        var factory = {

            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the InterimReportEffortGrade from the API collection.
         *
         * @return {InterimReportEffortGrade} An array of InterimReportEffortGrade objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url, {
                cache: true
            }).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('interimReportEffortGrades-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a InterimReportEffortGrade from the API collection.
         * @param  {int} id of the InterimReportEffortGrade object that is to be retrieved.
         * @return {InterimReportEffortGrade} An InterimReportEffortGrade object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('interimReportEffortGrade-loaded', response.data);
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
         * This method is used to create a new instance of an InterimReportEffortGrade object in the database by POSTing the
         * required data to the API.
         *
         * @param  {InterimReportEffortGrade} interimReportEffortGrade An InterimReportEffortGrade object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no interimReportEffortGrade data is provided then the method returns null.
         */
        function create(interimReportEffortGrade, callback) {
            var deferred = $q.defer();
            if (interimReportEffortGrade != undefined && interimReportEffortGrade != null) {
                $http.post(url, interimReportEffortGrade).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('interimReportEffortGrade-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No InterimReportEffortGrade ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing InterimReportEffortGrade object.
         *
         * @param  {InterimReportEffortGrade} interimReportEffortGrade An InterimReportEffortGrade object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no interimReportEffortGrade data is provided then the method returns null.
         */
        function save(interimReportEffortGrade, callback) {
            var deferred = $q.defer();
            if (interimReportEffortGrade && interimReportEffortGrade.id) {
                $http.put(url + interimReportEffortGrade.id, interimReportEffortGrade).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('interimReportEffortGrade-saved', response.data);
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
