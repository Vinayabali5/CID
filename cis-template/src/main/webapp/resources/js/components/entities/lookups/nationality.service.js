/**
 * This is the factory definition for the Nationality Data Service. This defines how to handle data about Nationality objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('NationalityService', ['cid.app.constants', 'ui-notification'])
        .factory('Nationality', nationalityFactory);

    nationalityFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function nationalityFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/nationalities/';

        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the Nationality from the API collection.
         *
         * @return {Nationality} An array of Nationality objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('nationalities-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a Nationality from the API collection.
         * @param  {int} id of the Nationality object that is to be retrieved.
         * @return {Nationality} An Nationality object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('nationality-loaded', response.data);
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
         * This method is used to create a new instance of an Nationality object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Nationality} nationality An Nationality object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Nationality data is provided then the method returns null.
         */
        function create(nationality, callback) {
            var deferred = $q.defer();
            if (nationality != undefined && nationality != null) {
                $http.post(url, nationality).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('nationality-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Nationality ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing Nationality object.
         *
         * @param  {Nationality} nationality An Nationality object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Nationality data is provided then the method returns null.
         */
        function save(nationality, callback) {
            var deferred = $q.defer();
            if (nationality && nationality.id) {
                $http.put(url + nationality.id, nationality).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('nationality-saved', response.data);
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
