/**
 * This is the factory definition for the Enrolment Data Service. This defines how to handle data about Enrolment objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('EnrolmentService', ['cid.app.constants', 'ui-notification'])
        .factory('Enrolment', enrolmentFactory);

    enrolmentFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function enrolmentFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/enrolments/';
        // Public Interface
        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;

        //Private Interface
        /**
         * This method is used to retrieve all the Enrolment from the API collection.
         *
         * @return {Enrolment} An array of Enrolment objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('enroloments-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a Enrolment from the API collection.
         * @param  {int} id of the Enrolment object that is to be retrieved.
         * @return {Enrolment} An Enrolment object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('enrolments-loaded', response.data);
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
         * This method is used to create a new instance of an Enrolment object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Enrolment} enrolment An Enrolment object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Enrolment data is provided then the method returns null.
         */
        function create(enrolment, callback) {
            var deferred = $q.defer();
            if (enrolment != undefined && enrolment != null) {
                $http.post(url, enrolment).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('enrolment-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Enrolment ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing Enrolment object.
         *
         * @param  {Enrolment} enrolment An Enrolment object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Enrolment data is provided then the method returns null.
         */
        function save(enrolment, callback) {
            var deferred = $q.defer();
            if (enrolment && enrolment.enrolmentId) {
                $http.put(url + enrolment.enrolmentId, enrolment).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('enrolment-saved', response.data);
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
