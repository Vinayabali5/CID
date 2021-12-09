/**
 * This is the factory definition for the Staff Data Service. This defines how to handle data about Staff objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('StaffService', [
            'cid.app.constants',
            'cid.app.variables',
            'ui-notification'
        ])
        .factory('Staff', staffFactory);

    staffFactory.$inject = ['$q', '$http', '$rootScope', 'GLOBAL', 'APP', 'Notification'];

    function staffFactory($q, $http, $rootScope, GLOBAL, APP, Notification) {
        var MAX_RETURN = 9999;
        /* jshint validthis:true */
        var url = GLOBAL.API + '/staff/';

        var staffListAll;
        var staffListCurrent;

        var factory = {
            query: getAll,
            queryPage: getAllByPage,
            get: getById,
            create: create,
            save: save,
            getTimetable: getTimetable,
            getCourseGroups: getCourseGroups,
            getTeachingGroups: getTeachingGroups,
            getCourseLeaderGroups: getCourseLeaderGroups,
            getHodGroups: getHodGroups,
        };

        return factory;

        /**
         * This method is used to retrieve the Staff from the API collection.
         *
         * @return {Staff} An array of Staff objects.
         */
        function get(current) {
            if (current === undefined) {
                current = true;
            }
            var request = '';
            if (current == true) {
                return getCurrent();
            } else {
                return getAll();
            }
        }

        function getCurrent() {
            var deferred = $q.defer();
            if (staffListCurrent !== undefined) {
                deferred.resolve({
                    data: staffListCurrent
                });
            } else {
                $http.get(url + 'current').then(function(response) {
                    staffListCurrent = response.data;
                    deferred.resolve(response);
                    $rootScope.$emit('staffs-loaded', response.data);
                }, function(response) {
                    deferred.reject(response);
                });
            }
            return deferred.promise;
        }

        function getAll() {
            var deferred = $q.defer();
            if (staffListAll !== undefined) {
                deferred.resolve({
                    data: staffListAll
                });
            } else {
                $http.get(url + 'all/').then(function(response) {
                    //  staffListAll = response.data;
                    deferred.resolve(response);
                    $rootScope.$emit('staffs-loaded', response.data);
                }, function(response) {
                    deferred.reject(response);
                });
            }
            return deferred.promise;
        }


        /**
         * This method is used to retrieve all the Staff using sort by page,size from the API collection.
         *
         * @return {Staff} An array of Staff objects.
         */
        function getAllByPage(page, size, sort) {
            var request = '?current=1&';
            if (page && page !== 0) {
                request += 'page=' + page + '&';
            }
            if (size && size !== 0) {
                request += 'size=' + size + '&';
            } else {
                request += 'size=' + MAX_RETURN + '&';
            }
            if (sort && sort !== '') {
                request += 'sort=' + sort + '&';
            }
            $http.get(url + request).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('staff-loaded', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

        /**
         * This method is used to retrieve an instance of a Staff from the API collection.
         * @param  {int} id of the Staff object that is to be retrieved.
         * @return {Staff} An Staff object as identified by the id.
         */
        function getById(id) {
            var deferred = $q.defer();
            if (id != undefined && id != null) {
                $http.get(url + id).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staff-loaded', response.data);
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
         * This method is used to create a new instance of an Staff object in the database by POSTing the
         * required data to the API.
         *
         * @param  {Staff} Staff An staff object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Staff data is provided then the method returns null.
         */
        function create(staff, callback) {
            var deferred = $q.defer();
            if (staff != undefined && staff != null) {
                $http.post(url, staff).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staff-saved', response.data);
                    if (callback) {
                        callback();
                    }
                }, function(response) {
                    deferred.reject(response);
                    Notification.error("Error:" + response.data.message);
                });
            } else {
                deferred.reject({
                    message: "No Staff ID Supplied"
                });
            }
            return deferred.promise;
        }

        /**
         * This method is used to save changes to an existing Staff object.
         *
         * @param  {Staff} Staff An staff object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no Staff data is provided then the method returns null.
         */
        function save(staff, callback) {
            var deferred = $q.defer();
            if (staff && staff.id) {
                $http.put(url + staff.id, staff).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staff-saved', response.data);
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

        /**
         * This method is used to retrieve the timetable data for the supplied staffId.
         *
         * @param  {Integer} staffId the ID for a memeber of staff
         * @return {promise}         a promise to the staff timetable API
         */
        function getTimetable(staffId) {
            var deferred = $q.defer();
            var year = APP.getYear();
            if (staffId !== undefined && staffId !== null) {
                $http.get(url + staffId + '/timetable', {
                    params: {
                        yearId: year.id
                    }
                }).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staff-loaded', response.data);
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
         * This method is used to retrieve the course groups data for the supplied staffId.
         *
         * @param  {Integer} staffId the ID for a memeber of staff
         * @return {promise}         a promise to the staff course-groups API
         */
        function getCourseGroups(staffId) {
            var deferred = $q.defer();
            var year = APP.getYear();
            if (staffId !== undefined && staffId !== null) {
                $http.get(url + staffId + '/course-groups', {
                    params: {
                        yearId: year.id
                    }
                }).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staff-loaded', response.data);
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
         * This method is used to retrieve the course groups data for the supplied staffId.
         *
         * @param  {Integer} staffId the ID for a memeber of staff
         * @return {promise}         a promise to the staff course-groups API
         */
        function getTeachingGroups(staffId) {
            var deferred = $q.defer();
            var year = APP.getYear();
            if (staffId !== undefined && staffId !== null) {
                $http.get(url + staffId + '/teaching-groups', {
                    params: {
                        yearId: year.id
                    }
                }).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staff-loaded', response.data);
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
         * This method is used to retrieve the course groups data for the supplied staffId.
         *
         * @param  {Integer} staffId the ID for a memeber of staff
         * @return {promise}         a promise to the staff course-groups API
         */
        function getCourseLeaderGroups(staffId) {
            var deferred = $q.defer();
            var year = APP.getYear();
            if (staffId !== undefined && staffId !== null) {
                $http.get(url + staffId + '/course-leader-groups', {
                    params: {
                        yearId: year.id
                    }
                }).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staff-loaded', response.data);
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
         * This method is used to retrieve the course groups data for the supplied staffId.
         *
         * @param  {Integer} staffId the ID for a memeber of staff
         * @return {promise}         a promise to the staff course-groups API
         */
        function getHodGroups(staffId) {
            var deferred = $q.defer();
            var year = APP.getYear();
            if (staffId !== undefined && staffId !== null) {
                $http.get(url + staffId + '/hod-groups', {
                    params: {
                        yearId: year.id
                    }
                }).then(function(response) {
                    deferred.resolve(response);
                    $rootScope.$emit('staff-loaded', response.data);
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
