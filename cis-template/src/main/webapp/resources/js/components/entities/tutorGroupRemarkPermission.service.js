/**
 * This is the factory definition for the StudentYear Data Service. This defines how to handle data about StudentYear objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('TutorGroupRemarkPermissionService', ['cid.app.constants', 'ui-notification'])
        .factory('StudentYear', studentYearFactory);

    studentYearFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function studentYearFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/tutorGroups/';
        var factory = {
            query: getAll,
            get: getById
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the StudentYear from the API collection.
         *
         * @return {StudentYear} An array of StudentYear objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('tutorGroups-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a StudentYear from the API collection.
         * @param  {int} id of the StudentYear object that is to be retrieved.
         * @return {StudentYear} An StudentYear object as identified by the id.
         */
        function getById(tutorGroupId) {
            if (tutorGroupId != undefined && tutorGroup != null) {
                $http.get(url + tutorGroupId + '/remarkPermissions').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('tutor-group-loaded', response.data);
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
