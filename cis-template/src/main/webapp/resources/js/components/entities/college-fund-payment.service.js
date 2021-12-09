/**
 * This is the factory definition for the CollegeFundPayment Data Service. This defines how to handle data about CollegeFundPayment objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('CollegeFundPaymentService', ['ui-notification'])
        .factory('CollegeFundPayment', collegeFundPaymentFactory);

    collegeFundPaymentFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function collegeFundPaymentFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/';

        var factory = {
            query: getAll,
            get: getById,
            getByStudent: getByStudentId,
            create: create,
            save: save
        };

        return factory;

        //Private Interface
        /**
         * This method is used to retrieve all the CollegeFundPayment from the API collection.
         *
         * @return {CollegeFundPayment} An array of CollegeFundPayment objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('college-fund-payment-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }


        /**
         * This method is used to retrieve an instance of a CollegeFundPayment from the API collection.
         * @param  {int} id of the CollegeFundPayment object that is to be retrieved.
         * @return {CollegeFundPayment} An CollegeFundPayment object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + 'collegeFundPayments/' + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('college-fund-payment-loaded', response.data);
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
         * This method is used to retrieve an instance of a CollegeFundPayment from the API collection.
         * @param  {int} studentId of the Student of whose the CollegeFundPayment object is to be retrieved.
         * @return {CollegeFundPayment} An CollegeFundPayment object of Student of studentId.
         */
        function getByStudentId(studentId) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.get(url + 'students/' + studentId + '/collegeFundPayments').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('college-fund-payment-student-loaded', response.data);
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
         * This method is used to create a new instance of an CollegeFundPayment object in the database by POSTing the
         * required data to the API.
         *
         * @param  {CollegeFundPayment} collegeFundPayment An CollegeFundPayment object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no CollegeFundPayment data is provided then the method returns null.
         */
        function create(collegeFundPayment, callback) {
            var deferred = $q.defer();
            if (collegeFundPayment != undefined && collegeFundPayment != null) {
                $http.post(url + 'collegeFundPayments', collegeFundPayment).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('college-fund-payment-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No CollegeFundPayment ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing CollegeFundPayment object.
         *
         * @param  {CollegeFundPayment} collegeFundPayment An CollegeFundPayment object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no CollegeFundPayment data is provided then the method returns null.
         */
        function save(collegeFundPayment, callback) {
            var deferred = $q.defer();
            $http.put(url + 'collegeFundPayments/' + collegeFundPayment.id, collegeFundPayment).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('college-fund-payment-saved', response.data);
                if (callback) {
                    callback();
                }
            }, function(response) {
                deferred.reject(response);
                Notification.error("Error:" + response.data.message);
            });
            return deferred.promise;
        }
    }
})();
