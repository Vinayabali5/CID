/**
 * This is the factory definition for the VolunteeringType Data Service. This defines how to handle data about Address objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('VolunteeringTypeService', ['ui-notification'])
        .factory('VolunteeringType', volunteeringTypeFactory);

    volunteeringTypeFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function volunteeringTypeFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/volunteering-types/';

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
         * This method is used to retrieve all the VolunteeringType from the API collection.
         *
         * @return {VolunteeringType} An array of VolunteeringType objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('volunteering-types-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a VolunteeringType from the API collection.
         * @param  {int} id of the VolunteeringType that is to be retrieved.
         * @return {VolunteeringType} An VolunteeringType object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('volunteering-types-loaded', response.data);
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
         * This method is used to create a new instance of an VolunteeringType object in the database by POSTing the
         * required data to the API.
         *
         * @param  {VolunteeringType} volunteeringType An VolunteeringType object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no VolunteeringType data is provided then the method returns null.
         */
        function create(volunteeringType, callback) {
            var deferred = $q.defer();
            if (volunteeringType != undefined && volunteeringType != null) {
                $http.post(url, volunteeringType).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('volunteering-type-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No VolunteeringType ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing VolunteeringType object.
         *
         * @param  {VolunteeringType} volunteeringType An VolunteeringType object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no VolunteeringType data is provided then the method returns null.
         */
        function save(volunteeringType, callback) {
            var deferred = $q.defer();
            $http.put(url + volunteeringType.id, volunteeringType).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('volunteering-type-saved', response.data);
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
