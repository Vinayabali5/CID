/**
 * This is the factory definition for the StaffPayment Data Service. This defines how to handle data about StaffPayment objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('StaffPaymentService', ['ui-notification'])
        .factory('StaffPayment', staffPaymentFactory);

    staffPaymentFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function staffPaymentFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/staff-payments/';
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
         * This method is used to retrieve all the StaffPayment from the API collection.
         *
         * @return {StaffPayment} An array of StaffPayment objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('staffPayment-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a StaffPayment from the API collection.
         * @param  {int} id of the StaffPayment object that is to be retrieved.
         * @return {StaffPayment} An StaffPayment object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staffPayment-loaded', response.data);
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
                    $rootScope.$emit('staffPayment-loaded', response.data);
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
         * This method is used to create a new instance of an StaffPayment object in the database by POSTing the
         * required data to the API.
         *
         * @param  {StaffPayment} staffPayment An StaffPayment object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no StaffPayment data is provided then the method returns null.
         */
        function create(staffPayment, callback) {
            var deferred = $q.defer();
            if (staffPayment != undefined && staffPayment != null) {
                $http.post(url, staffPayment).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staffPayment-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No StaffPayment ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing StaffPayment object.
         *
         * @param  {StaffPayment} staffPayment An StaffPayment object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no StaffPayment data is provided then the method returns null.
         */
        function save(staffPayment, callback) {
            var deferred = $q.defer();
            if (staffPayment && staffPayment.id) {
                $http.put(url + staffPayment.id, staffPayment).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staffPayment-saved', response.data);
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
