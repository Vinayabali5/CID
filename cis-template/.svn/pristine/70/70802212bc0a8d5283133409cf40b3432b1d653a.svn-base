/**
 * This is the factory definition for the StudentFile Data Service. This defines how to handle data about StudentFile objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('StudentFileService', ['cid.app.constants', 'ui-notification'])
        .factory('StudentFile', studentFileFactory);

    studentFileFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Notification'];

    function studentFileFactory($q, $http, $rootScope, GLOBAL, Notification) {
        /* jshint validthis:true */
        var url = GLOBAL.API + '/';

        var factory = {
            getByStudentId: getByStudentId,
            create: create
        };

        return factory;

        /**
         * This method is used to retrieve a collection of a StudentFile of a Student from the API collection.
         * @param  {int} studentId of the StudentFile object that is to be retrieved.
         * @return {StudentFile} An An array of StudentFiles object as identified by the studentId.
         */
        function getByStudentId(studentId) {
            var deferred = $q.defer();
            if (studentId != undefined && studentId != null) {
                $http.get(url + 'student-files/' + studentId).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('student-files.loaded', response.data);
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
         * This method is used to post the StudentFile object.
         *
         * @param  {StudentFile} studentFile An StudentFile object with the data.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no studentFile data is provided then the method returns null.
         */
        function create(studentFile, callback) {
            var deferred = $q.defer();
            if (studentFile) {
                var fileName = studentFile.filename;
                $http.post(url + 'student-files/retrieve', studentFile, {
                    responseType: 'arraybuffer'
                }).then(function(response) {
                    var contentType = response.headers('content-type');
                    var linkElement = document.createElement('a');
                    try {
                        var blob = new Blob([response.data], {
                            type: contentType
                        });
                        var url = window.URL.createObjectURL(blob);

                        linkElement.setAttribute('href', url);
                        linkElement.setAttribute("download", fileName);
                        var clickEvent = new MouseEvent("click", {
                            "view": window
                        });
                        linkElement.dispatchEvent(clickEvent);
                    } catch (ex) {
                        console.log(ex);
                    }
                    deferred.resolve(response);
                    $rootScope.$emit('student-file.updated', response.data);
                }, function(response) {
                    deferred.reject(response);
                });
            }
        }

    }
})();
