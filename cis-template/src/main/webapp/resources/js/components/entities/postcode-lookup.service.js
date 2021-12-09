/**
 * This is the factory definition for the PostcodeLookup Data Service. This defines how to handle data about PostcodeLookup objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('PostcodeLookupService', ['cid.app.constants', 'ui-notification'])
        .factory('PostcodeLookup', postCodeFactory);

    postCodeFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function postCodeFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/postcodes';

        var factory = {
            search: search,
            retrieve: retrieve
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the PostcodeLookup from the API collection.
         * @param  {String} postcode The Unique Postcode to retrieve the address
         * @return {PostcodeLookup} An array of PostcodeLookup objects.
         */
        function search(postcode) {
            var deferred = $q.defer();
            $http.get(url + '/search/' + postcode).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('postcode-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a PostcodeLookup from the API collection.
         * @param  {int} id The Unique Id of the Postcode to retrieve the address
         * @return {PostcodeLookup} An PostcodeLookup object as identified by the id.
         */
        function retrieve(id) {
            var deferred = $q.defer();
            $http.get(url + '/retrieve/' + id).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('postcode-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }
    }

})();
