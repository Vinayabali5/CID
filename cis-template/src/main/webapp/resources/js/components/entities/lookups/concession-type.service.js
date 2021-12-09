/**
 * This is the factory definition for the ConcessionType Data Service. This defines how to handle data about ConcessionType objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('ConcessionTypeService', ['ui-notification'])
        .factory('ConcessionType', concessionTypeFactory);

    concessionTypeFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function concessionTypeFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/concessionTypes/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the ConcessionType from the API collection.
         *
         * @return {ConcessionType} An array of ConcessionType objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('concession-types-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a ConcessionType from the API collection.
         * @param  {int} id of the ConcessionType object that is to be retrieved.
         * @return {ConcessionType} An ConcessionType object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('concession-type-loaded', response.data);
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
         * This method is used to create a new instance of an ConcessionType object in the database by POSTing the
         * required data to the API.
         *
         * @param  {ConcessionType} concessionType An ConcessionType object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no ConcessionType data is provided then the method returns null.
         */
        function create(concessionType, callback) {
            var deferred = $q.defer();
            if (concessionType != undefined && concessionType != null) {
                $http.post(url, concessionType).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('concession-type-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No ConcessionType ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing ConcessionType object.
         *
         * @param  {ConcessionType} concessionType An ConcessionType object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no ConcessionType data is provided then the method returns null.
         */
        function save(concessionType, callback) {
            var deferred = $q.defer();
            $http.put(url + concessionType.id, concessionType).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('concession-type-saved', response.data);
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
