/**
 * This is the factory definition for the Title Data Service. This defines how to handle data about Title objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('TitleService', ['cid.app.constants', 'ui-notification'])
        .factory('Title', titleFactory);

    titleFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function titleFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/titles/';
        var factory = {

            query: getAll,
            get: getById,
            create: create,
            save: save
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the Title from the API collection.
         *
         * @return {Title} An array of Title objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('titles-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a Title from the API collection.
         * @param  {int} id of the Title object that is to be retrieved.
         * @return {Title} An Title object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('title-loaded', response.data);
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
         * This method is used to create a new instance of an Title object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Title} title An Title object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no title data is provided then the method returns null.
         */
        function create(title, callback) {
            var deferred = $q.defer();
            if (title != undefined && title != null) {
                $http.post(url, title).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('title-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Title ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing Title object.
         *
         * @param  {Title} title An Title object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no title data is provided then the method returns null.
         */
        function save(title, callback) {
            var deferred = $q.defer();
            if (title && title.id) {
                $http.put(url + title.id, title).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('title-saved', response.data);
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
