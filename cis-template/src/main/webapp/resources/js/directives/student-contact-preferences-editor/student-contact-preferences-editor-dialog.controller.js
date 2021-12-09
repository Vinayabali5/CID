/**
 * This is the Student Contact Preferences Editor Dialog Controller
 * 
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 * 
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('StudentContactPreferencesEditorDirective')
        .controller('StudentContactPreferencesEditorDialogController', StudentContactPreferencesEditorDialogController);

    StudentContactPreferencesEditorDialogController.$inject = ['$log', '$scope', '$state', '$uibModalInstance', '$uibModal', '$rootScope', 'studentEntity', 'Student'];

    function StudentContactPreferencesEditorDialogController($log, $scope, $state, $uibModalInstance, $uibModal, $rootScope, studentEntity, Student) {
        /* jshint validthis:true */
        var vm = this;

        vm.student = studentEntity !== undefined ? studentEntity : {};
        vm.save = save;
        vm.cancel = cancel;


        var onSaveFinished = function(result) {
            $log.info('II StudentContactPreferences Saved');
            $scope.$emit('studentContactPreferences-saved', result);
            $uibModalInstance.close(result);
        };


        function save() {
            $log.log('StudentContactPreferencesDialogController::save called');
            $log.info(vm.student);
            if (vm.student.id) {
                Student.save(vm.student, onSaveFinished);
            } else {
                return null;
            }
        }


        function cancel() {
            $log.log('StudentContactPreferencesDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }

    }

})();
