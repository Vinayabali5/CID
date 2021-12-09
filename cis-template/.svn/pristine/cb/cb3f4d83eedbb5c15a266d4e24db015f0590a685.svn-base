/**
 * This is the factory definition for the MasterRegister Data Service. This defines how to handle data about MasterRegister objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {
    'use strict';

    angular
        .module('MasterRegisterService', ['cid.app.constants'])
        .factory('MasterRegister', masterRegisterFactory);

    masterRegisterFactory.$inject = ['$http', 'GLOBAL', 'APP'];

    function masterRegisterFactory($http, GLOBAL, APP) {
        /* jshint validthis:true */
        var vm = this;
        var url = GLOBAL.API + '/';

        var factory = {
            query: getAll,
            get: getByStudentId,
            create: create,
            save: save,
            getById: getById
        };

        return factory;
        // Private Interface

        /**
         * This method is used to retrieve all the MasterRegister from the API collection.
         *
         * @return {MasterRegister} An array of MasterRegister objects.
         */
        function getAll() {
            return $http.get(url);
        }

        /**
         * This method is used to retrieve an instance of a MasterRegister from the API collection.
         * @param  {int} id of the MasterRegister object that is to be retrieved.
         * @return {MasterRegister} An MasterRegister object as identified by the id.
         */
        function getById(id) {
            return $http.get(url + 'masterRegisters/' + id);
        }

        /**
         * This method is used to retrieve an instance of a MasterRegister from the API collection for a specific student.
         * @param  {int} id of the Student of whose Master Register is to be retrieved.
         * @return {MasterRegister} MasterRegister objects as identified by the student id.
         */
        function getByStudentId(id) {
            year = APP.getYear();
            if (id !== undefined && id !== null) {
                return $http.get(url + 'students/' + id + '/masterRegisters', {
                    params: {
                        yearId: year.id
                    }
                });
            } else {
                return null;
            }
        }

        /**
         * This method is used to create a new instance of an MasterRegister object in the database by POSTing the
         * required data to the API.
         *
         * @param  {MasterRegister} masterRegister An MasterRegister object to persist to the database.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no MasterRegister data is provided then the method returns null.
         */
        function create(masterRegister, callback) {
            if (masterRegister) {
                return $http.post(url + 'masterRegisters', masterRegister).then(function(response) {
                    if (callback) {
                        callback();
                    }
                    return response.data;
                }, function(response) {
                    return {
                        status: response.status,
                        error: response.data
                    };
                });
            } else {
                return null;
            }
        }

        /**
         * This method is used to save changes to an existing MasterRegister object.
         *
         * @param  {MasterRegister} masterRegister An MasterRegister object with the data to be updated.
         * @param  {Function} callback (Optional) A function to be called on a successful call to the API
         * @return {various} This method will return different things depending on the success or failure of the API call.
         * On a success full call the data returned from the API is returned, in the event of an error on the API call the
         * status and data are returned, if no MasterRegister data is provided then the method returns null.
         */
        function save(masterRegister, callback) {
            if (masterRegister && masterRegister.id) {
                return $http.put(url + 'masterRegisters/' + masterRegister.id, masterRegister).then(function(response) {
                    if (callback) {
                        callback();
                    }
                    return response.data;
                }, function(response) {
                    return {
                        status: response.status,
                        error: response.data
                    };
                });
            } else {
                return null;
            }
        }
    }
})();
