/**
 * This is the factory definition for the ReferralReason Data Service. This defines how to handle data about ReferralReason objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('ReferralReasonService', ['cid.app.constants', 'ui-notification'])
        .factory('ReferralReason', referralReasonFactory);

    referralReasonFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function referralReasonFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/referralReasons/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the ReferralReason from the API collection.
         *
         * @return {ReferralReason} An array of ReferralReason objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('referral-reasons-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a ReferralReason from the API collection.
         * @param  {int} id of the ReferralReason object that is to be retrieved.
         * @return {ReferralReason} An ReferralReason object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('referral-reason-loaded', response.data);
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
         * This method is used to create a new instance of an ReferralReason object in the database by POSTing the
         * required data to the API.
         *
         * @param  {ReferralReason} referralReason An ReferralReason object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no ReferralReason data is provided then the method returns null.
         */
        function create(referralReason, callback) {
            var deferred = $q.defer();
            if (referralReason != undefined && referralReason != null) {
                $http.post(url, referralReason).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('referral-reason-created', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No ReferralReason ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing ReferralReason object.
         *
         * @param  {ReferralReason} referralReason An ReferralReason object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no ReferralReason data is provided then the method returns null.
         */
        function save(referralReason, callback) {
            var deferred = $q.defer();
            if (referralReason && referralReason.id) {
                $http.put(url + referralReason.id, referralReason).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('referral-reason-saved', response.data);
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
