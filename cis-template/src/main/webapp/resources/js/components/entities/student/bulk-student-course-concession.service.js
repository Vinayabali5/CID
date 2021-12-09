/**
 * This is the factory definition for the BulkStudentCourseConcession Data Service. This defines how to handle data about BulkStudentCourseConcession objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('BulkStudentCourseConcessionService', ['cid.app.constants', 'ui-notification'])
        .factory('BulkStudentCourseConcession', bulkStudentCourseConcessionFactory);

    bulkStudentCourseConcessionFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function bulkStudentCourseConcessionFactory($q, $http, $rootScope, GLOBAL, Notification) {
        // Variable and Constants
        var url = GLOBAL.API + '/bulk-student-course-concession/';

        // Public Interface
        var factory = {
            create: create
        };

        return factory;

        // Private Interface

        /**
         * This method is used to create a new instance of an BulkStudentCourseConcession object in the database by POSTing the
         * required data to the API.
         *
         * @param  {BulkStudentCourseConcession} bulkStudentCourseConcession An BulkStudentCourseConcession object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no BulkStudentCourseConcessionType data is provided then the method returns null.
         */
        function create(bulkStudentCourseConcession, callback) {
            var deferred = $q.defer();
            if (bulkStudentCourseConcession != undefined && bulkStudentCourseConcession != null) {
                $http.post(url, bulkStudentCourseConcession).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('bulk-student-course-concession-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error: Missing fields");
                });
            } else {
                deferred.reject({
                    message: "No bulk-student-course-concession ID Supplied"
                });
            }
            return deferred.promise;
        }

    }
})();
