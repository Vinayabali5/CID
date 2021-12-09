/**
 * This is the factory definition for the LetterTemplate Service.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('LetterTemplateService', ['cid.app.constants', 'ui-notification'])
        .factory('LetterTemplate', letterTemplateService);

    letterTemplateService.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function letterTemplateService($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/letterTemplates/';

        var factory = {
            query: getAll,
            get: getById,
            save: save,
            create: create
        };

        return factory;

        /**
         * This method is used to retrieve all the LetterTemplate from the API collection.
         *
         * @return {LetterTemplate} An array of LetterTemplate objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url, {
                params: {
                    showAll: 'true'
                }
            }).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('letter-templates-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a LetterTemplate from the API collection.
         * @param  {int} id of the Gender object that is to be retrieved.
         * @return {LetterTemplate} An Gender object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('letter-template-loaded', response.data);
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
         * This method is used to create a new instance of an LetterTemplate object in the database by POSTing the
         * required data to the API.
         *
         * @param  {LetterTemplate} gender An Gender object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no LetterTemplate data is provided then the method returns null.
         */
        function create(letterTemplate, callback) {
            var deferred = $q.defer();
            if (letterTemplate != undefined && letterTemplate != null) {
                $http.post(url, letterTemplate).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('letter-template-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No LetterTemplate ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing Gender object.
         *
         * @param  {LetterTemplate} gender An LetterTemplate object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no LetterTemplate data is provided then the method returns null.
         */
        function save(letterTemplate, callback) {
            var deferred = $q.defer();
            if (letterTemplate && letterTemplate.id) {
                $http.put(url + letterTemplate.id, letterTemplate).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('letter-template-saved', response.data);
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
