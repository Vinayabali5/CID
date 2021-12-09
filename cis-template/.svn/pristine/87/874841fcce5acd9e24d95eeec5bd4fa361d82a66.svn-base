//

(function() {

    angular
        .module('cid.service.data.admission.application-form', ['cid.app.constants', 'cid.service.logger'])
        .factory('ApplicationForm', ApplicationForm);

    ApplicationForm.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'Logger', 'Notification'];

    function ApplicationForm($q, $http, $rootScope, GLOBAL, Logger, Notification) {
        var url = GLOBAL.API + '';

        var service = {};
        service.query = getAll;
        service.get = getById;
        service.getByStudentId = getByStudentId;
        service.saveInterview = saveInterview;
        service.search = search;
        service.save = save;
        service.create = create;
        service.duplicateDetection = duplicateDetection;
        return service;

        // Private Interface

        function getAll(id) {
            return $http.get(url + '/applications/');
        }

        function getById(id) {
            return $http.get(url + '/applications/' + id);
        }

        function getByStudentId(id) {
            return $http.get(url + '/interviews/getByStudent/' + id);
        }

        function search(search) {
            return $http.get(url + '/applications/search/' + search);
        }

        function create(applicationForm, callback) {
            var deferred = $q.defer();
            if (applicationForm != undefined) {
                $http.post(url + '/applications/', applicationForm).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('application-form-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No ApplicationForm ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an ApplicationForm object.
         *
         * @param  {ApplicationForm} applicationForm An ApplicationForm object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no ApplicationForm data is provided then the method returns null.
         */
        function save(applicationForm, callback) {
            var deferred = $q.defer();
            if (applicationForm != undefined) {
                if (applicationForm.id !== undefined) {
                    $http.put(url + '/applications/' + applicationForm.id, applicationForm).then(function(response) {
                        deferred.resolve(response);
                        $rootScope.$emit('application-form-saved', response.data);
                        Notification.success("Message: Application Details Successfully Saved");
                        if (callback) {
                            callback();
                        }
                    }, function(response) {
                        deferred.reject(response);
                        Notification.error("Error:" + response.data.message);
                    });
                }
            }
            return deferred.promise;
        }

        function saveInterview(applicationForm, callback) {
            var deferred = $q.defer();
            if (applicationForm != undefined) {
                if (applicationForm.studentId !== undefined) {
                    $http.put(url + '/interviews/' + applicationForm.studentId, applicationForm).then(function(response) {
                        deferred.resolve(response);
                        $rootScope.$emit('application-form-saved', response.data);
                        Notification.success("Message: Interview Details Successfully Saved");
                        if (callback) {
                            callback();
                        }
                    }, function(response) {
                        deferred.reject(response);
                        Notification.error("Error:" + response.data.message);
                    });
                }
            }
            return deferred.promise;
        }

        function duplicateDetection(applicationForm, callback) {
            var deferred = $q.defer();
            if (applicationForm !== null) {
                $http.post(url + '/duplicate-detection', applicationForm).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('application-duplicate-detection', response.data);
                    if (callback) {
                        callback();
                    }
                });
            } else {
                deferred.reject({
                    message: "No ApplicationForm ID Supplied"
                });
            }
            return deferred.promise;
        }
    }

})();
