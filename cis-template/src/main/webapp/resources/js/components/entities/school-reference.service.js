/**
 * This is the factory definition for the SchoolReference Data Service. This defines how to handle data about SchoolReference objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('SchoolReferenceService', ['cid.app.constants', 'ui-notification'])
        .factory('SchoolReference', schoolReferenceFactory);

    schoolReferenceFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function schoolReferenceFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/schoolReferences/';

        var factory = {
            query: getAll,
            get: getByStudentId
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the SchoolReference from the API collection.
         *
         * @return {SchoolReference} An array of SchoolReference objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('school-references.loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a SchoolReference from the API collection.
         * @param  {int} id of the SchoolReference object that is to be retrieved.
         * @return {SchoolReference} An SchoolReference object as identified by the id.
         */
        function getByStudentId(studentId) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.get(url + studentId + '/schoolReferences').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('school-references.loaded', response.data);
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
