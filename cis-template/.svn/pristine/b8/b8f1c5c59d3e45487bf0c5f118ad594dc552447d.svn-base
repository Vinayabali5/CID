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
        .module('AddressService', ['ui-notification'])
        .factory('Address', addressFactory);

    addressFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function addressFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/addresses/';

        // Public Interface
        var factory = {
            query: getAll,
            get: getById,
            create: create,
            save: save

        };

        return factory;

        //Private Interface
        /**
         * This method is used to retrieve all the Address from the API collection.
         *
         * @return {Address} An array of Address objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('addresses-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }


        /**
         * This method is used to retrieve an instance of a Address from the API collection.
         * @param  {int} addressId that is to be retrieved.
         * @return {Address} An Address object as identified by the addressId.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('address-loaded', response.data);
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
         * This method is used to create a new instance of an Address object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Address} address An Address object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Address data is provided then the method returns null.
         */
        function create(address, callback) {
            var deferred = $q.defer();
            if (address != undefined && address != null) {
                return $http.post(url, address).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('address-saved', response.data);
                    if (callback) {
                        callback(response.data);
                    }
                    return response.data;
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Address ID Supplied"
                });
            }
            return deferred.promise;
        }


        /**
         * This method is used to save changes to an existing Address object.
         *
         * @param  {Address} address An Address object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Address data is provided then the method returns null.
         */
        function save(address, callback) {
            var deferred = $q.defer();
            $http.put(url + address.id, address).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('address-saved', response.data);
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
