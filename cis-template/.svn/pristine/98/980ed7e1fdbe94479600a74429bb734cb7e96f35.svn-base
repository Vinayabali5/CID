/**
 * This is the factory definition for the CareersRecordType Data Service. This defines how to handle data about CareersRecordType objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('CareersRecordTypeService', ['ui-notification'])
        .factory('CareersRecordType', careersRecordTypeFactory);

    careersRecordTypeFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function careersRecordTypeFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/careers-record-types/';

        //Pubic Interface
        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;


        //Private Interface
        /**
         * This method is used to retrieve all the CareersRecordType from the API collection.
         *
         * @return {CareersRecordType} An array of CareersRecordType objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('careers-record-types-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a CareersRecordType from the API collection.
         * @param  {int} id of the CareersRecordType that is to be retrieved.
         * @return {CareersRecordType} An CareersRecordType object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('careers-record-types-loaded', response.data);
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
         * This method is used to create a new instance of an CareersRecordType object in the database by POSTing the
         * required data to the API.
         *
         * @param  {CareersRecordType} careersRecordType An CareersRecordType object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no CareersRecordType data is provided then the method returns null.
         */
        function create(careersRecordType, callback) {
            var deferred = $q.defer();
            if (careersRecordType != undefined && careersRecordType != null) {
                $http.post(url, careersRecordType).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('careers-record-types-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No CareersRecordType ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing CareersRecordType object.
         *
         * @param  {CareersRecordType} careersRecordType An CareersRecordType object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no CareersRecordType data is provided then the method returns null.
         */
        function save(careersRecordType, callback) {
            var deferred = $q.defer();
            $http.put(url + careersRecordType.id, careersRecordType).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('careers-record-types-saved', response.data);
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
