/**
 * This is the factory definition for the ProgrammeType Data Service. This defines how to handle data about ProgrammeType objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('ProgrammeTypeService', ['cid.app.constants', 'ui-notification'])
        .factory('ProgrammeType', programmeTypeFactory);

    programmeTypeFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function programmeTypeFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/programmeTypes/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the ProgrammeType from the API collection.
         *
         * @return {ProgrammeType} An array of ProgrammeType objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('programme-types-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }


        /**
         * This method is used to retrieve an instance of a ProgrammeType from the API collection.
         * @param  {int} id of the ProgrammeType object that is to be retrieved.
         * @return {ProgrammeType} An ProgrammeType object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('programme-types-loaded', response.data);
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
         * This method is used to create a new instance of an ProgrammeType object in the database by POSTing the
         * required data to the API.
         *
         * @param  {ProgrammeType} programmeType An ProgrammeType object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no ProgrammeType data is provided then the method returns null.
         */
        function create(programmeType, callback) {
            var deferred = $q.defer();
            if (programmeType != undefined && programmeType != null) {
                $http.post(url, programmeType).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('programme-type-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No ProgrammeType ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing ProgrammeType object.
         *
         * @param  {ProgrammeType} programmeType An ProgrammeType object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no ProgrammeType data is provided then the method returns null.
         */
        function save(programmeType, callback) {
            var deferred = $q.defer();
            if (programmeType && programmeType.id) {
                $http.put(url + programmeType.id, programmeType).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('programme-type-saved', response.data);
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
