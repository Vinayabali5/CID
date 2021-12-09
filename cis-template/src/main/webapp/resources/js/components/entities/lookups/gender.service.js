/**
 * This is the factory definition for the Gender Data Service. This defines how to handle data about Gender objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('GenderService', ['ui-notification'])
        .factory('Gender', genderFactory);

    genderFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function genderFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/genders/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the Gender from the API collection.
         *
         * @return {Gender} An array of Gender objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('genders-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }


        /**
         * This method is used to retrieve an instance of a Gender from the API collection.
         * @param  {int} id of the Gender object that is to be retrieved.
         * @return {Gender} An Gender object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('gender-loaded', response.data);
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
         * This method is used to create a new instance of an Gender object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Gender} gender An Gender object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Gender data is provided then the method returns null.
         */
        function create(gender, callback) {
            var deferred = $q.defer();
            if (gender != undefined && gender != null) {
                $http.post(url, gender).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('gender-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Gender ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing Gender object.
         *
         * @param  {Gender} gender An Gender object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Gender data is provided then the method returns null.
         */
        function save(gender, callback) {
            var deferred = $q.defer();
            if (gender && gender.id) {
                $http.put(url + gender.id, gender).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('gender-saved', response.data);
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
