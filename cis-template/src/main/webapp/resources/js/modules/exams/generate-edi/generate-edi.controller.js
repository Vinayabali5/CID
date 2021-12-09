/**
 * The ExamSyllabusViewer module for viewing Syllabus basedata for an individual examBoard
 */
(function() {
    angular
        .module('cid.exams.generate-edi')
        .controller('GenerateEdiFileViewerController', GenerateEdiFileViewerController);

    GenerateEdiFileViewerController.$inject = ['$log', '$scope', '$rootScope', '$http', 'ExamSeries', 'EdiDataGenerator', 'examSeriesList', 'Auth', 'GLOBAL', 'APP'];

    function GenerateEdiFileViewerController($log, $scope, $rootScope, $http, ExamSeries, EdiDataGenerator, examSeriesList, Auth, GLOBAL, APP) {
        var vm = this;

        // Public Interface

        vm.examSeriesList = examSeriesList != null ? examSeriesList.data : [];
        vm.generatedMessage = [];
        vm.generateEdiFiles = generateEdiFiles;
        $scope.loadExamSeriesByYear = loadExamSeriesByYear;
        // Private Interface

        /*****************************************************/
        /**	Generate edi files for all selected examSeries	**/
        /*****************************************************/
        function generateEdiFiles(ev) {
            vm.generatedMessage = [];
            for (i = 0; i < vm.examSeriesList.length; i++) {
                if (vm.examSeriesList[i].selected) {
                    EdiDataGenerator.generateEDIFile(vm.examSeriesList[i].examYear, vm.examSeriesList[i].examSeries, vm.examSeriesList[i].examBoard.id).then(
                        processGenerateEdiFileResponse(vm.examSeriesList[i]),
                        processGenerateEdiFileError(vm.examSeriesList[i])
                    );
                }
            }
        }

        // loads course lists based on year change
        $scope.$on('$destroy', $rootScope.$on("current-year-changed", function(data) {
            $scope.loadExamSeriesByYear(APP.getYear());
        }));

        function loadExamSeriesByYear(year) {
            $log.log('ExamSeriesListController::loadExamSeriesByYear called');
            ExamSeries.getByYear(year.id).then(function(response) {
                $log.info('II Successfully retrieved ExamSeriesByYear');
                vm.examSeriesList = response.data;
            }, function(response) {
                $log.error('EE Error retrieving ExamSeries');
            });
        }

        function processGenerateEdiFileResponse(examSeries) {
            vm.generatedMessage.push(examSeries.examBoard.description + ", " + examSeries.examYear + ' - ' + examSeries.examSeries + " EDI file generated.");
        }

        function processGenerateEdiFileError(examSeries) {
            vm.generatedMessage.push("ERROR occurred generating EDI file for " + examSeries.examBoard.description + ", " + examSeries.examSeries);
        }
    }

})();
