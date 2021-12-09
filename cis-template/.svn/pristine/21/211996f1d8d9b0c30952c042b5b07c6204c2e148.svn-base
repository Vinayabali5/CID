/**
 * This is the factory definition for the StaffEmailing Data Service. This defines how to handle data about StaffEmailing objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('StaffEmailingService', [])
        .factory('StaffEmailing', staffEmailingFactory);

    staffEmailingFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function staffEmailingFactory($q, $http, $rootScope, GLOBAL, Notification) {
        // Variable and Constants
        var url = GLOBAL.API + '/';
        var data;

        // Public Interface
        var factory = {
            create: create,
            createEamil: createEamil
        };

        return factory;

        // Private Interface

        function create(staffEmailing, callback) {
            var deferred = $q.defer();
            if (staffEmailing != undefined && staffEmailing != null) {
                $http.post(url + 'emails/related-staff', staffEmailing).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staff-emailing-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No StaffEmailing ID Supplied"
                });
            }
            return deferred.promise;
        }

        function createEamil(staffEmailing, callback) {
            var deferred = $q.defer();
            if (staffEmailing != undefined && staffEmailing != null) {
                $http.post(url + 'emails/staff-ilp-notification', staffEmailing).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staff-emailing-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No StaffEmailing ID Supplied"
                });
            }
            return deferred.promise;
        }

    }
})();
