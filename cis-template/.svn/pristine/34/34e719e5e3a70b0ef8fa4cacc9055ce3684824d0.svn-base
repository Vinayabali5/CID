/**
 * This is the Student Special Category Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StudentRiskLevelEditorDirective')
        .controller('StudentRiskLevelEditorDialogController', studentRiskLevelEditorDialogController);

    studentRiskLevelEditorDialogController.$inject = ['$log', '$scope', '$state', '$uibModalInstance', '$uibModal', '$rootScope', 'studentRiskLevelEntity', 'StudentRiskLevel'];

    function studentRiskLevelEditorDialogController($log, $scope, $state, $uibModalInstance, $uibModal, $rootScope, studentRiskLevelEntity, StudentRiskLevel) {
        /* jshint validthis:true */
        var vm = this;
        vm.studentRiskLevel = studentRiskLevelEntity !== undefined ? studentRiskLevelEntity : {};

        vm.dateForReview = new Date();
        vm.save = save;
        vm.cancel = cancel;



        var onSaveFinished = function(result) {
            $scope.$emit('student-risk-level-saved', result);
            $uibModalInstance.close(result);
        };

        function save() {
            $log.log('StudentRiskLevelDialogController::save called');
            $log.info(vm.studentRiskLevel);
            if (vm.studentRiskLevel.id) {
                //update the contact information
                StudentRiskLevel.save(vm.studentRiskLevel, onSaveFinished);
            } else {
                if (vm.studentRiskLevel.id !== null) {
                    StudentRiskLevel.create(vm.studentRiskLevel, onSaveFinished);
                }
            }
        }

        function cancel() {
            $log.log('StudentRiskLevelDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }

    }
})();
