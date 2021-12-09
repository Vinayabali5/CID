/**
 * This is the factory definition for the AcademicYear Data Service. This
 * defines how to handle data about AcademicYear objects.
 * 
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052,
 * Y053, Y090, Y091]
 * 
 * @type Data Service
 */
(function() {
    angular
        .module('StudentAlternativeUciService', [])
        .factory('StudentAlternativeUci', studentAlternativeUciFactory);

    studentAlternativeUciFactory.$inject = ['$http', 'GLOBAL', '$window'];

    function studentAlternativeUciFactory($http, GLOBAL, $window) {
        // Variables and Constants
        var url = GLOBAL.API + '/students/';

        // Public Interface
        var factory = {
            getByStudent: getByStudent,
            create: create,
            save: save,
            delete: deleteByIds,
            getByStudentAndExamBoardId: getByStudentAndExamBoardId
        };

        return factory;

        // Private Interface

        function getByStudent(studentId) {
            if (studentId) {
                return $http.get(url + studentId + '/alternative-ucis');
            } else
                return null;
        }

        function getByStudentAndExamBoardId(studentId, examBoardId) {
            if (studentId && examBoardId) {
                return $http.get(url + studentId + '/alternative-ucis/' + examBoardId);
            } else
                return null;

        }

        function create(studentAlternativeUci, callback) {
            if (studentAlternativeUci) {
                return $http.post(url + studentAlternativeUci.studentId + '/alternative-ucis', studentAlternativeUci).then(function(response) {
                    if (callback) {
                        callback();
                    }
                    return response.data;
                }, function(response) {
                    $window.alert("Invalid Data Entry");
                    return {
                        status: response.status,
                        error: response.data
                    };
                });
            } else {
                return null;
            }
        }

        function save(studentAlternativeUci, callback) {
            if (studentAlternativeUci) {
                return $http.put(url + studentAlternativeUci.studentId + '/alternative-ucis/' + studentAlternativeUci.examBoardId, studentAlternativeUci).then(function(response) {
                    if (callback) {
                        callback();
                    }
                    return response.data;
                }, function(response) {
                    $window.alert("Invalid Data Entry");
                    return {
                        status: response.status,
                        error: response.data
                    };
                });
            } else {
                return null;
            }
        }

        function deleteByIds(studentId, examBoardId) {
            return $http.delete(url + studentId + '/alternative-ucis/' + examBoardId);
        }

    }


})();
