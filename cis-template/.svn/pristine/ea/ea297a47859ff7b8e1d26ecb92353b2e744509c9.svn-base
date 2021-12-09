/**
 * This is the factory definition for the StudentRelatedStaff Data Service. This defines how to handle data about StudentRelatedStaff objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('StudentRelatedStaffService', [])
        .factory('StudentRelatedStaff', studentRelatedStaffFactory);

    studentRelatedStaffFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL'];

    function studentRelatedStaffFactory($q, $http, $rootScope, GLOBAL) {
        // Variable and Constants
        var url = GLOBAL.API + '/';
        var data;

        // Public Interface
        var factory = {
            query: getAll,
            get: getById
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the StudentRelatedStaffs from the API collection.
         *
         * @return {StudentRelatedStaff} An array of StudentRelatedStaff objects.
         */
        function getAll() {
            var deferred = $q.defer();
            if (data == undefined) {
                $http.get(url + 'related-staff').then(function(response) {
                    data = response;
                    deferred.resolve(response);
                    $rootScope.$emit('student-related-staff-loaded', response.data);
                }, function(response) {
                    deferred.reject(response);
                });
                return deferred.promise;
            } else {
                return data;
            }
        }

        /**
         * This method is used to retrieve an collection of StudentEntryQualification entities from the API collection.
         * @param  {int} studentEntryQualificationId of the StudentEntryQualification object that is to be retrieved.
         * @return {StudentEntryQualification} An StudentEntryQualification object as identified by the id.
         */
        function getById(studentId) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.get(url + 'students/' + studentId + '/related-staff').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-related-staff-loaded', response.data);
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
