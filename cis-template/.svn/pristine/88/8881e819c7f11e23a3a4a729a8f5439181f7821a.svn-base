/**
 * This is the factory definition for the MassLetter Data Service. This defines how to handle data about MassLetter objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */
(function() {
    'use strict';

    angular
        .module('MassLetterService', ['cid.app.constants', 'ui-notification'])
        .factory('MassLetter', massLetterFactory);

    massLetterFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function massLetterFactory($q, $http, $rootScope, GLOBAL, Notification) {
        // Variable and Constants
        var url = GLOBAL.API + '/mass-letters/';

        // Public Interface
        var factory = {
            create: create
        };

        return factory;

        // Private Interface

        /**
         * This method is used to create a new instance of an MassLetter object in the database by POSTing the
         * required data to the API.
         *
         * @param  {MassLetter} massLetter An MassLetter object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no MassLetterType data is provided then the method returns null.
         */
        function create(massLetter, callback) {
            var deferred = $q.defer();
            if (massLetter != undefined && massLetter != null) {
                $http.post(url, massLetter).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('mass-letter-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error: Missing fields");
                });
            } else {
                deferred.reject({
                    message: "No Mass Letter ID Supplied"
                });
            }
            return deferred.promise;
        }

    }
})();
