(function() {
    angular
        .module('EdiDataGeneratorService', [])
        .factory('EdiDataGenerator', ediDataGeneratorService);

    ediDataGeneratorService.$inject = ["$http", "GLOBAL"];

    function ediDataGeneratorService($http, GLOBAL) {
        var vm = this;
        var url = GLOBAL.API + '/ediDataGenerator/';

        // Public Interface

        var factory = {
            generateStudentOptionEntries: generateStudentOptionEntries,
            generateEDIFile: generateEDIFile
        };

        return factory;

        // Private Interface

        /*	create function POST call generates the student option entries	*/
        function generateStudentOptionEntries() {
            return $http.post(url + 'studentOptionEntries');
        }

        /*	get function POST call generates audit records, updates student option entries, and returns edi file contents	*/
        function generateEDIFile(examYear, examSeries, examBoardId) {
            if (examYear && examSeries && examBoardId) {
                var request = '?' + 'examYear=' + examYear + '&examSeries=' + examSeries + '&examBoardId=' + examBoardId;
                return $http.post(url + 'ediFile' + request);
            } else {
                return null;
            }
        }
    }

}());
