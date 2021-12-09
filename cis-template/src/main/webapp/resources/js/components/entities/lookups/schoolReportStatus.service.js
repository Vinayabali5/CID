/**
 * This is the factory definition for the SchoolReportStatus Data Service. This defines how to handle data about SchoolReportStatus objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('SchoolReportStatusService', ['cid.app.constants', 'ui-notification'])
        .factory('SchoolReportStatus', schoolReportStatusFactory);

    schoolReportStatusFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function schoolReportStatusFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/schoolReportStatuses/';

        var factory = {
            query: getAll,
            get: getById,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the SchoolReportStatus from the API collection.
         *
         * @return {SchoolReportStatus} An array of SchoolReportStatus objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('school-report-statuss-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a SchoolReportStatus from the API collection.
         * @param  {int} id of the SchoolReportStatus object that is to be retrieved.
         * @return {SchoolReportStatus} An SchoolReportStatus object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('school-report-status-loaded', response.data);
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
         * This method is used to save changes to an existing SchoolReportStatus object.
         *
         * @param  {schoolReportStatus} SchoolReportStatus An SchoolReportStatus object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no SchoolReportStatus data is provided then the method returns null.
         */
        function save(schoolReportStatus, callback) {
            var deferred = $q.defer();
            if (schoolReportStatus && schoolReportStatus.id) {
                $http.put(url + schoolReportStatus.id, schoolReportStatus).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('school-report-status-saved', response.data);
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
    }
})();
