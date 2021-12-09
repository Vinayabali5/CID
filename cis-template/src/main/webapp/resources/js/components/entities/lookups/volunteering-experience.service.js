/**
 * This is the factory definition for the VolunteeringExperience Data Service. This defines how to handle data about Address objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('VolunteeringExperienceService', ['ui-notification'])
        .factory('VolunteeringExperience', volunteeringExperienceFactory);

    volunteeringExperienceFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function volunteeringExperienceFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/volunteering-experiences/';

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
         * This method is used to retrieve all the VolunteeringExperience from the API collection.
         *
         * @return {VolunteeringExperience} An array of VolunteeringExperience objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('volunteering-experiences-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a VolunteeringExperience from the API collection.
         * @param  {int} id of the VolunteeringExperience that is to be retrieved.
         * @return {VolunteeringExperience} An VolunteeringExperience object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('volunteering-experiences-loaded', response.data);
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
         * This method is used to create a new instance of an VolunteeringExperience object in the database by POSTing the
         * required data to the API.
         *
         * @param  {VolunteeringExperience} volunteeringExperience An VolunteeringExperience object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no VolunteeringExperience data is provided then the method returns null.
         */
        function create(volunteeringExperience, callback) {
            var deferred = $q.defer();
            if (volunteeringExperience != undefined && volunteeringExperience != null) {
                $http.post(url, volunteeringExperience).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('volunteering-experience-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No VolunteeringExperience ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing VolunteeringExperience object.
         *
         * @param  {VolunteeringExperience} volunteeringExperience An VolunteeringExperience object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no VolunteeringExperience data is provided then the method returns null.
         */
        function save(volunteeringExperience, callback) {
            var deferred = $q.defer();
            $http.put(url + volunteeringExperience.id, volunteeringExperience).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('volunteering-experience-saved', response.data);
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
