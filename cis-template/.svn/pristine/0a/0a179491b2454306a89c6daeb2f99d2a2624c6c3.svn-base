/**
 * This is the factory definition for the Address Data Service. This defines how to handle data about Address objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('InterviewCategoryService', ['ui-notification'])
        .factory('InterviewCategory', interviewCategoryFactory);

    interviewCategoryFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function interviewCategoryFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/interview-categories/';

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
         * This method is used to retrieve all the InterviewCategory from the API collection.
         *
         * @return {InterviewCategory} An array of InterviewCategory objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('interview-categories-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a InterviewCategory from the API collection.
         * @param  {int} id of the InterviewCategory that is to be retrieved.
         * @return {InterviewCategory} An InterviewCategory object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('interview-category-loaded', response.data);
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
         * This method is used to create a new instance of an InterviewCategory object in the database by POSTing the
         * required data to the API.
         *
         * @param  {InterviewCategory} interviewCategory An InterviewCategory object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no InterviewCategory data is provided then the method returns null.
         */
        function create(interviewCategory, callback) {
            var deferred = $q.defer();
            if (interviewCategory != undefined && interviewCategory != null) {
                $http.post(url, interviewCategory).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('interview-category-created', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No InterviewCategory ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing InterviewCategory object.
         *
         * @param  {InterviewCategory} interviewCategory An InterviewCategory object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no InterviewCategory data is provided then the method returns null.
         */
        function save(interviewCategory, callback) {
            var deferred = $q.defer();
            $http.put(url + interviewCategory.id, interviewCategory).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('interview-category-saved', response.data);
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
