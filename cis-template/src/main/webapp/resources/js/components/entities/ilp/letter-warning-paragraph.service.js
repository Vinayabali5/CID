/**
 * This is the factory definition for the LetterWarningParagraph Data Service. This defines how to handle data about LetterWarningParagraph objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('LetterWarningParagraphService', ['ui-notification'])
        .factory('LetterWarningParagraph', letterWarningParagraphFactory);

    letterWarningParagraphFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function letterWarningParagraphFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/letter-warning-paragraphs/';

        var factory = {
            query: getAll,
            get: getById,
        };

        return factory;

        // Private Interface

        /**
         * This method is used to retrieve all the LetterWarningParagraph from the API collection.
         *
         * @return {LetterWarningParagraph} An array of LetterWarningParagraph objects.
         */
        function getAll() {
            var deferred = $q.defer();
            $http.get(url).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('ilp-letter-warning-paragraph-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a LetterWarningParagraph from the API collection.
         * @param  {int} id of the LetterWarningParagraph object that is to be retrieved.
         * @return {LetterWarningParagraph} An LetterWarningParagraph object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('ilp-letter-warning-paragraph-loaded', response.data);
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
