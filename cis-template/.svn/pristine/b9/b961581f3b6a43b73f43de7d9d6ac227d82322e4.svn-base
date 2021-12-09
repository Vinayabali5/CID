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
        .module('StudentSpecialCategoryEditorDirective')
        .controller('StudentSpecialCategoryEditorDialogController', studentSpecialCategoryEditorDialogController);

    studentSpecialCategoryEditorDialogController.$inject = ['$log', '$scope', '$state', '$uibModalInstance', '$uibModal', '$rootScope', 'studentSpecialCategoryEntity', 'StudentSpecialCategory'];

    function studentSpecialCategoryEditorDialogController($log, $scope, $state, $uibModalInstance, $uibModal, $rootScope, studentSpecialCategoryEntity, StudentSpecialCategory) {
        /* jshint validthis:true */
        var vm = this;
        vm.specialCategory = studentSpecialCategoryEntity !== undefined ? studentSpecialCategoryEntity : {};

        vm.requestDate = new Date();
        vm.classificationDate = new Date();
        vm.closedDate = new Date();
        vm.save = save;
        vm.cancel = cancel;


        var onSaveFinished = function(result) {
            $scope.$emit('student-special-category-saved', result);
            $uibModalInstance.close(result);
        };

        function save() {
            $log.log('StudentSpecialCategoryDialogController::save called');
            $log.info(vm.specialCategory);
            if (vm.specialCategory.id) {
                //update the contact information
                StudentSpecialCategory.save(vm.specialCategory, onSaveFinished);
            } else {
                if (vm.specialCategory.id !== null) {
                    StudentSpecialCategory.create(vm.specialCategory, onSaveFinished);
                }
            }
        }

        function cancel() {
            $log.log('StudentSpecialCategoryDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }

    }
})();
