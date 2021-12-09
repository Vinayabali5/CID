/**
 * This is the factory definition for the PastoralMonitor Data Service. This defines how to handle data about PastoralMonitor objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('PastoralMonitorService', ['cid.app.constants', 'ui-notification'])
        .factory('PastoralMonitor', pastoralMonitorFactory);

    pastoralMonitorFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification', 'APP'];

    function pastoralMonitorFactory($q, $http, $rootScope, GLOBAL, Notification, APP) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/students/';

        var factory = {
            get: getByStudent,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve an instance of a PastoralMonitor from the API collection.
         * @param  {int} studentId of the PastoralMonitor object that is to be retrieved.
         * @return {PastoralMonitor} An PastoralMonitor object as identified by the studentId.
         */
        function getByStudent(studentId) {
            var deferred = $q.defer();
            year = APP.getYear();
            if (studentId !== null) {
                $http.get(url + studentId + '/pastoral-monitor', {
                    params: {
                        yearId: year.id
                    }
                }).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('pastoral-monitor-loaded', response.data);
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
         * This method is used to save changes to an existing PastoralMonitor object.
         *
         * @param  {PastoralMonitor} pastoralMonitor An PastoralMonitor object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no pastoralMonitor data is provided then the method returns null.
         */
        function save(pastoralMonitor, callback) {
            var deferred = $q.defer();
            if (pastoralMonitor !== null && pastoralMonitor !== undefined && pastoralMonitor.studentId !== null) {
                $http.put(url + pastoralMonitor.studentId + '/pastoral-monitor', pastoralMonitor).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('pastoralMonitor-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            }
            return deferred.promise;
        }
    }
})();
