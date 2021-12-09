/**
 * This is the factory definition for the StaffSignin Data Service. This defines how to handle data about StaffSignin objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('StaffSigninService', ['cid.app.constants', 'ui-notification'])
        .factory('StaffSignin', staffSigninFactory);

    staffSigninFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function staffSigninFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/staff-signin/';

        var factory = {
            getByStaffId: getByStaffId
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve an instance of a StaffSignin from the API collection.
         * @param  {int} id of the StaffSignin object that is to be retrieved.
         * @return {StaffSignin} An StaffSignin object as identified by the id.
         */
        //        function getById(id) {
        //            var deferred = $q.defer();
        //            if (id != undefined && id != null) {
        //                $http.get(url + 'staff/' + id).then(function(response) {
        //                    deferred.resolve(response);
        //                    $rootScope.$emit('staff-signins-loaded', response.data);
        //                }, function(response) {
        //                    deferred.reject(response);
        //                });
        //            } else {
        //                deferred.reject({
        //                    message: "No ID Supplied"
        //                });
        //            }
        //            return deferred.promise;
        //        }

        /**
         * This method is used to retrieve an instance of a StaffSignin from the API collection.
         * @param  {int} id of the StaffSignin object that is to be retrieved.
         * @return {StaffSignin} An StaffSignin object as identified by the id.
         */
        function getByStaffId(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + 'staff/' + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staff-signins-loaded', response.data);
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
