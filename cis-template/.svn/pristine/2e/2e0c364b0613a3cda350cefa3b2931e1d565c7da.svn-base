/**
 * This is the factory definition for the StaffAbsence Data Service. This defines how to handle data about StaffAbsence objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('StaffAbsenceService', ['ui-notification'])
        .factory('StaffAbsence', staffAbsenceFactory);

    staffAbsenceFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function staffAbsenceFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/staff-absences/';
        // Public Interface
        var factory = {
            query: getAll,
            get: getById,
            getByStaffId: getByStaffId,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the StaffAbsence from the API collection.
         *
         * @return {StaffAbsence} An array of StaffAbsence objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('staffAbsence-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a StaffAbsence from the API collection.
         * @param  {int} id of the StaffAbsence object that is to be retrieved.
         * @return {StaffAbsence} An StaffAbsence object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staffAbsence-loaded', response.data);
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

        function getByStaffId(staffId) {
            var deferred = $q.defer();
            if (staffId != undefined && staffId != null) {
                $http.get(url + 'staff/' + staffId).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staffAbsence-loaded', response.data);
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
         * This method is used to create a new instance of an StaffAbsence object in the database by POSTing the
         * required data to the API.
         *
         * @param  {StaffAbsence} staffAbsence An StaffAbsence object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no StaffAbsence data is provided then the method returns null.
         */
        function create(staffAbsence, callback) {
            var deferred = $q.defer();
            if (staffAbsence != undefined && staffAbsence != null) {
                $http.post(url, staffAbsence).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staffAbsence-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No StaffAbsence ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing StaffAbsence object.
         *
         * @param  {StaffAbsence} staffAbsence An StaffAbsence object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no StaffAbsence data is provided then the method returns null.
         */
        function save(staffAbsence, callback) {
            var deferred = $q.defer();
            if (staffAbsence && staffAbsence.id) {
                $http.put(url + staffAbsence.id, staffAbsence).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staffAbsence-saved', response.data);
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
