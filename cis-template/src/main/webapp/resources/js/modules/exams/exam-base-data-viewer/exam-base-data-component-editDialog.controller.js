/**
 * 
 */

(function() {
    'use strict';

    angular
        .module('cid.exams.base-data-viewer')
        .controller('ExamBaseDataComponentEditDialogController', examBaseDataComponentEditDialogController);

    examBaseDataComponentEditDialogController.$inject = ['$log', '$scope', '$uibModalInstance', 'entity', 'Component', 'OptionComponent'];

    function examBaseDataComponentEditDialogController($log, $scope, $uibModalInstance, entity, Component, OptionComponent) {
        /*jshint validthis: true */
        var vm = this;

        vm.cancel = cancel;
        vm.save = save;
        vm.component = entity.component !== undefined ? entity.component : {};
        vm.component.examSeries = entity.option.syllabus.examSeries;

        var onComponentSaveFinished = function(result) {
            if (!vm.component.id) {
                OptionComponent.create({
                    examOption: {
                        examOptionId: entity.option.examOptionId
                    },
                    examComponent: {
                        examComponentId: result.data.id
                    }
                }, onSaveFinished);
            } else {
                onSaveFinished(result);
            }
        };

        var onSaveFinished = function(result) {
            $scope.$emit('exam-component-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $log.log('ExamBaseDataComponentEditDialogController::clear called');
            $scope.$emit('exam-component-saved');
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.component.id) {
                Component.save(vm.component, onComponentSaveFinished);
            } else {
                Component.create(vm.component, onComponentSaveFinished);
            }
        }
    }
})();
