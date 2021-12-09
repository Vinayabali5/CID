/**
 * This is the StudentWithdrawalDialogController, it is used to handle the student withdrawal dialog data and controls.
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */
(function() {
    'use strict';

    angular
        .module('StudentWithdrawalDirective')
        .controller('StudentWithdrawalDialogController', StudentWithdrawalDialogController);

    StudentWithdrawalDialogController.$inject = ['$log', '$rootScope', '$uibModalInstance', 'studentYearEntity', 'Student'];

    function StudentWithdrawalDialogController($log, $rootScope, $uibModalInstance, studentYearEntity, Student) {
        // *** Public Interface
        /* jshint validthis:true */
        var vm = this;

        // Data
        vm.studentYear = studentYearEntity ? studentYearEntity : undefined;
        vm.withdrawalRequest = {};

        // Operations
        vm.withdraw = withdrawStudent;
        vm.cancel = cancel;
        vm.formValidation = formValidation;

        init();

        // *** Private Interface

        /**
         * This function initialises the data required for the form
         *
         * @return nothing returned
         */
        function init() {
            vm.withdrawalRequest = {
                studentId: vm.studentYear.studentId,
                yearId: vm.studentYear.yearId,
                destinationId: vm.studentYear.destinationId !== null ? vm.studentYear.destinationId : null,
                withdrawalDate: vm.studentYear.endDate !== null ? vm.studentYear.endDate : null,
                withdrawalResonId: vm.studentYear.withdrawalResonId !== null ? vm.studentYear.withdrawalResonId : null,
                collegeEmployer: vm.studentYear.destinationCollegeEmployer !== null ? vm.studentYear.destinationCollegeEmployer : null,
                courseCareer: vm.studentYear.destinationCourseCareer !== null ? vm.studentYear.destinationCourseCareer : null,
            };
        }

        /**
         * This method is used to withdraw a student for a specified year.
         *
         * @return nothing returned
         */
        function withdrawStudent() {
            if (vm.studentYear && vm.withdrawalRequest) {
                $log.info(vm.withdrawalRequest);
                Student.withdraw(vm.studentYear.studentId, vm.withdrawalRequest).then(function(response) {
                    $log.info(response);
                    onSaveFinished(response.data);
                }, function(response) {
                    $log.info('EE Student Withdrawal - Failed');
                    //                $uibModalInstance.close(result);
                });
            }
        }

        /**
         * This closes the student withdrawl dialog box without saving
         *
         * @return nothing returned
         */
        function cancel() {
            $log.log('StudentWithdrawalDialogController::cancel called');
            $uibModalInstance.dismiss('cancel');
        }

        function formValidation() {
            if (vm.withdrawalRequest.withdrawalDate !== null && vm.withdrawalRequest.destinationId == 95) {
                return false;
            }
            if (vm.withdrawalRequest.withdrawalDate === null && vm.withdrawalRequest.destinationId != 95) {
                return false;
            }
            return true;
        }

        function onSaveFinished(result) {
            $log.info('II Student Withdrawal - Success');
            $rootScope.$emit('student-withdrawn', result);
            $uibModalInstance.close(result);
        }

    }
})();
