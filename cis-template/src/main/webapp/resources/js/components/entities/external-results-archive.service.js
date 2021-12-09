/**
 * This is the factory definition for the ExternalResultsArchive Data Service. This defines how to handle data about ExternalResultsArchive objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('ExternalResultsArchiveService', ['cid.app.constants', 'ui-notification'])
        .factory('ExternalResultsArchive', externalResultArchiveFactory);

    externalResultArchiveFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function externalResultArchiveFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/students/';
        // Public Interface
        var factory = {
            query: getAll,
            get: getById
        };

        return factory;
        // Private Interface
        /**
         * This method is used to retrieve all the ExternalResultsArchive from the API collection.
         *
         * @return {ExternalResultsArchive} An array of ExternalResultsArchive objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('external-results-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a ExternalResultsArchive from the API collection.
         * @param  {int} id of the ExternalResultsArchive object that is to be retrieved.
         * @return {ExternalResultsArchive} An ExternalResultsArchive object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.get(url + studentId + '/externalResults').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('external-results-loaded', response.data);
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
