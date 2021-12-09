/**
 * This is the factory definition for the AbsenceReason Data Service. This defines how to handle data about AbsenceReason objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('AbsenceReasonService', ['ui-notification'])
        .factory('AbsenceReason', absenceReasonFactory);

    absenceReasonFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function absenceReasonFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/absence-reasons/';
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
         * This method is used to retrieve all the AbsenceReason from the API collection.
         *
         * @return {AbsenceReason} An array of AbsenceReason objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('absenceReason-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a AbsenceReason from the API collection.
         * @param  {int} id of the AbsenceReason object that is to be retrieved.
         * @return {AbsenceReason} An AbsenceReason object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('absenceReason-loaded', response.data);
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
         * This method is used to create a new instance of an AbsenceReason object in the database by POSTing the
         * required data to the API.
         *
         * @param  {AbsenceReason} absenceReason An AbsenceReason object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no AbsenceReason data is provided then the method returns null.
         */
        function create(absenceReason, callback) {
            var deferred = $q.defer();
            if (absenceReason != undefined && absenceReason != null) {
                $http.post(url, absenceReason).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('absenceReason-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No AbsenceReason ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing AbsenceReason object.
         *
         * @param  {AbsenceReason} absenceReason An AbsenceReason object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no AbsenceReason data is provided then the method returns null.
         */
        function save(absenceReason, callback) {
            var deferred = $q.defer();
            if (absenceReason && absenceReason.id) {
                $http.put(url + absenceReason.id, absenceReason).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('absenceReason-saved', response.data);
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
