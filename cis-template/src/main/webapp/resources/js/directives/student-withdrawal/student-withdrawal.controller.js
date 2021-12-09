/**
 * This is the StudentWithdrawalController, it is used to handle the student withdrawal directive
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */
(function() {
    'use strict';

    angular
        .module('StudentWithdrawalDirective')
        .controller('StudentWithdrawalController', StudentWithdrawalController);

    StudentWithdrawalController.$inject = ['$log', '$uibModal', 'Student'];

    function StudentWithdrawalController($log, $uibModal, Student) {
        // *** Public Interface
        /* jshint validthis:true */
        var vm = this;

        // Data
        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.yearId = vm.yearId ? vm.yearId : undefined;

        // Mehtods
        vm.withdrawStudent = loadWithdrawStudentDialog;

        // *** Private Interface
        var dialogSettings = {
            templateUrl: 'js/directives/student-withdrawal/views/student-withdrawal-dialog.html',
            controller: 'StudentWithdrawalDialogController',
            controllerAs: 'ctrl',
            size: 'lg',
            resolve: {
                studentYearEntity: ['Student', function(Student) {
                    return Student.studentYears(vm.studentId, vm.yearId).then(function(response) {
                        return response.data;
                    }, function(response) {
                        bootbox.alert("failed to retrieve");
                    });
                }]
            }
        };

        function loadWithdrawStudentDialog() {
            $log.log('StudentWithdrawalDialogDirectiveController::editAddress called');
            if (vm.studentId !== undefined && vm.yearId !== undefined) {
                $uibModal.open(dialogSettings);
            }
        }

    }
})();
