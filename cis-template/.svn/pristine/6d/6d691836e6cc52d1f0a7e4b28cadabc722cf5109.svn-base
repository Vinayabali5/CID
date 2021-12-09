/**
 * This is the factory definition for the InterimReportsDue Data Service. This defines how to handle data about InterimReportsDue objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('InterimReportsDueService', ['cid.app.constants', 'ui-notification'])
        .factory('InterimReportsDue', interimReportsDueFactory);

    interimReportsDueFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function interimReportsDueFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/interim-reports-due/';
        var factory = {

            query: getAll,
            myInterimReports: myInterimReports,
            getByCourseGroupId: getByCourseGroupId
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the InterimReportsDue from the API collection.
         *
         * @return {InterimReportsDue} An array of InterimReportsDue objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('interimReportsDues-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        function myInterimReports(staffId) {
            var deferred = $q.defer();
            $http.get(url + staffId + '/my-interim-reports').then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('my-interim-reports-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        function getByCourseGroupId(courseGroupId) {
            var deferred = $q.defer();
            if (courseGroupId != undefined && courseGroupId != null) {
                $http.get(url + 'course-group/' + courseGroupId + '/data-collection').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('data-collection-interim-reports-loaded', response.data);
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

    }
})();
