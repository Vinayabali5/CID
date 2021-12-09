/**
 * This is the factory definition for the BulkCareersRecord Data Service. This defines how to handle data about BulkCareersRecord objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('BulkCareersRecordService', ['cid.app.constants', 'ui-notification'])
        .factory('BulkCareersRecord', bulkCareersRecordFactory);

    bulkCareersRecordFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function bulkCareersRecordFactory($q, $http, $rootScope, GLOBAL, Notification) {
        // Variable and Constants
        var url = GLOBAL.API + '/bulk-careers-record/';

        // Public Interface
        var factory = {
            create: create
        };

        return factory;

        // Private Interface

        /**
         * This method is used to create a new instance of an BulkCareersRecord object in the database by POSTing the
         * required data to the API.
         *
         * @param  {BulkCareersRecord} bulkCareersRecord An BulkCareersRecord object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         */
        function create(bulkCareersRecord, callback) {
            var deferred = $q.defer();
            if (bulkCareersRecord != undefined && bulkCareersRecord != null) {
                $http.post(url, bulkCareersRecord).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('bulk-careers-record-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error: Missing fields");
                });
            } else {
                deferred.reject({
                    message: "No Mass Letter ID Supplied"
                });
            }
            return deferred.promise;
        }

    }
})();
