/**
 * This is the Student Special LearningSupport Editor Dialog Controller 
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('StudentLearningSupportEditorDirective')
        .controller('StudentLearningSupportEditorDialogController', StudentLearningSupportEditorDialogController);

    StudentLearningSupportEditorDialogController.$inject = ['$log', '$scope', '$state', '$uibModalInstance', '$uibModal', '$rootScope', 'studentLearningSupportEntity', 'StudentLearningSupport'];

    function StudentLearningSupportEditorDialogController($log, $scope, $state, $uibModalInstance, $uibModal, $rootScope, studentLearningSupportEntity, StudentLearningSupport) {
        /* jshint validthis:true */
        var vm = this;

        vm.studentLearningSupport = studentLearningSupportEntity !== undefined ? studentLearningSupportEntity : {};

        vm.save = save;
        vm.cancel = cancel;


        var onSaveFinished = function(result) {
            $log.info('II StudentLearningSupport Saved');
            $scope.$emit('studentLearningSupport-saved', result);
            $uibModalInstance.close(result);
        };

        /**
         * This saves the studentLearningSupport and closes that dialog box
         */
        function save() {
            $log.log('StudentLearningSupportDialogController::save called');
            $log.info(vm.studentLearningSupport);
            if (studentLearningSupportEntity.studentId !== null) {
                StudentLearningSupport.save(vm.studentLearningSupport, onSaveFinished);
            } else {
                vm.studentLearningSupport.studentId = $scope.studentId;
                StudentLearningSupport.create(vm.studentLearningSupport, onSaveFinished);
            }

        }

        /**
         * This closes the studentLearningSupport editor dialog box without saving 
         */
        function cancel() {
            $log.log('StudentLearningSupportDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }
})();
