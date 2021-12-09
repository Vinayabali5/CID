/**
 * This is the factory definition for the Syllabus Data Service. This defines how to handle data about Syllabus objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {

    angular
        .module('SyllabusService', [])
        .factory('Syllabus', SyllabusService);

    SyllabusService.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'APP', 'Notification'];

    function SyllabusService($q, $http, $rootScope, GLOBAL, APP, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/syllabi/';

        var factory = {
            query: getAll,
            search: search,
            searchByYear: searchByYear,
            get: getById,
            create: create,
            save: save,
            getOptions: getOptions
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the Syllabus from the API collection.
         *
         * @return {Syllabus} An array of Syllabus objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('syllabus-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve all the Syllabus from the API collection.
         *
         * @return {Syllabus} An array of Syllabus objects.
         */
        function search(options) {
            var deferred = $q.defer();
            var params = {};
            var year = APP.getYear();
            if (options.syllabusCode && options.syllabusCode !== '') {
                params.syllabusCode = options.syllabusCode;
            }
            params.yearId = year.id;
            $http.get(GLOBAL.API + '/search/syllabus', {
                params: params
            }).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('syllabus-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        function searchByYear(year, options) {
            var deferred = $q.defer();
            var params = {};
            if (options.syllabusCode && options.syllabusCode !== '') {
                params.syllabusCode = options.syllabusCode;
            }
            params.year = year.code;
            $http.get(GLOBAL.API + '/searchByYear/syllabus', {
                params: params
            }).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('syllabus-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a Syllabus from the API collection.
         *
         * @param  {int} id of the Syllabus object that is to be retrieved.
         * @return {Syllabus} An Syllabus object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('syllabus-loaded', response.data);
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
         * This method is used to create a new instance of an Syllabus object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Syllabus} Syllabus A Syllabus object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Course data is provided then the method returns null.
         */
        function create(syllabus, callback) {
            var deferred = $q.defer();
            if (syllabus != undefined && syllabus != null) {
                $http.post(url, Syllabus).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('syllabus-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Syllabus ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing Syllabus object.
         *
         * @param  {Syllabus} Syllabus An Syllabus object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Syllabus data is provided then the method returns null.
         */
        function save(syllabuse, callback) {
            var deferred = $q.defer();
            $http.put(url + syllabus.id, syllabus).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('syllabus-saved', response.data);
                if (callback) {
                    callback();
                }
            }, function(response) {
                deferred.reject(response);
                Notification.error("Error:" + response.data.message);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a Syllabus from the API collection.
         *
         * @param  {int} id of the Syllabus object that is to be retrieved.
         * @return {Syllabus} An Syllabus object as identified by the id.
         */
        function getOptions(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id + '/options').then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('syllabus-loaded', response.data);
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

    }

})();
