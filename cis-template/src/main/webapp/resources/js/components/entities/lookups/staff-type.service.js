/**
 * This is the factory definition for the StaffType Data Service. This defines how to handle data about StaffType objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */


(function() {
    'use strict';

    angular
        .module('StaffTypeService', ['cid.app.constants', 'ui-notification'])
        .factory('StaffType', staffTypeFactory);

    staffTypeFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function staffTypeFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/staffTypes/';
        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };
        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the StaffType from the API collection.
         *
         * @return {StaffType} An array of StaffType objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('staff-types-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a StaffType from the API collection.
         * @param  {int} id of the StaffType object that is to be retrieved.
         * @return {StaffType} An StaffType object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staff-type-loaded', response.data);
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
         * This method is used to create a new instance of an StaffType object in the database by POSTing the
         * required data to the API.
         *
         * @param  {StaffType} staffType An StaffType object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no StaffType data is provided then the method returns null.
         */
        function create(staffType, callback) {
            var deferred = $q.defer();
            if (staffType != undefined && staffType != null) {
                $http.post(url, staffType).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staff-type-created', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No StaffType ID Supplied"
                });
            }
            return deferred.promise;
        }


        /**
         * This method is used to save changes to an existing StaffType object.
         *
         * @param  {StaffType} staffType An StaffType object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no StaffType data is provided then the method returns null.
         */
        function save(staffType, callback) {
            var deferred = $q.defer();
            if (staffType && staffType.id) {
                $http.put(url + staffType.id, staffType).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staff-type-saved', response.data);
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
