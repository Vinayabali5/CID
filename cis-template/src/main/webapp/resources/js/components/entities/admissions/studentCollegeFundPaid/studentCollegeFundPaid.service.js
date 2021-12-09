(function() {

    angular
        .module('StudentCollegeFundPaidService', ['cid.app.constants'])
        .factory('StudentCollegeFundPaid', studentCollegeFundPaid);

    studentCollegeFundPaid.$inject = ['$http', 'GLOBAL'];


    function studentCollegeFundPaid($http, GLOBAL) {

        // Variable and Constants
        var url = GLOBAL.API + '/students/';

        var factory = {

            get: getById,
            save: save

        };

        return factory;


        // get method
        function getById(studentId) {
            if (studentId)
                return $http.get(url + studentId + '/collegeFund');
            else
                return null;
        }


        // put method
        function save(studentCollegeFundPaid, callback) {
            if (studentCollegeFundPaid && studentCollegeFundPaid.studentId) {
                return $http.put(url + studentCollegeFundPaid.studentId + '/collegeFund', studentCollegeFundPaid).then(function(response) {
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
