/**
 * This is the Entry Qualifications Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('StudentInterimReportsEditorDirective')
        .controller('StudentInterimReportsEditorController', StudentInterimReportsEditorController);

    StudentInterimReportsEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'StudentInterimReport'];

    function StudentInterimReportsEditorController($log, $scope, $state, $rootScope, $uibModal, StudentInterimReport) {
        /* jshint validthis:true */
        var vm = this;
        vm.dialog = {};
        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.studentInterimReports = vm.studentInterimReports ? vm.studentInterimReports : [];
        vm.init = init;
        //   vm.loadStudentInterimReports = loadStudentInterimReports;
        vm.editStudentInterimReport = editStudentInterimReport;

        function init() {
            $log.info('II InterimReports Editor Initialised');
            //  vm.loadStudentInterimReports(vm.studentId);
        }



        function editStudentInterimReport(studentInterimReportId) {
            $log.log('InterimReportsEditorController::editContact called');

            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-interim-reports-editor/views/student-interim-reports-editor-dialog.html',
                controller: 'StudentInterimReportsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentInterimReportEntity: ['StudentInterimReport', function(StudentInterimReport) {
                        return StudentInterimReport.get(studentInterimReportId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });
            // Reload Contacts after dialog closed

        }


    }
})();
