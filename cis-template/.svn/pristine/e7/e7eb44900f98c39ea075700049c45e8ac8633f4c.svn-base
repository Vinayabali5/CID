/**
 * This is the factory definition for the PaymentReason Data Service. This defines how to handle data about PaymentReason objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('PaymentReasonService', ['ui-notification'])
        .factory('PaymentReason', paymentReasonFactory);

    paymentReasonFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function paymentReasonFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/payment-reasons/';
        // Public Interface
        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the PaymentReason from the API collection.
         *
         * @return {PaymentReason} An array of PaymentReason objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('paymentReason-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a PaymentReason from the API collection.
         * @param  {int} id of the PaymentReason object that is to be retrieved.
         * @return {PaymentReason} An PaymentReason object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('paymentReason-loaded', response.data);
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
         * This method is used to create a new instance of an PaymentReason object in the database by POSTing the
         * required data to the API.
         *
         * @param  {PaymentReason} paymentReason An PaymentReason object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no PaymentReason data is provided then the method returns null.
         */
        function create(paymentReason, callback) {
            var deferred = $q.defer();
            if (paymentReason != undefined && paymentReason != null) {
                $http.post(url, paymentReason).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('paymentReason-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No PaymentReason ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing PaymentReason object.
         *
         * @param  {PaymentReason} paymentReason An PaymentReason object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no PaymentReason data is provided then the method returns null.
         */
        function save(paymentReason, callback) {
            var deferred = $q.defer();
            if (paymentReason && paymentReason.id) {
                $http.put(url + paymentReason.id, paymentReason).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('paymentReason-saved', response.data);
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
