/**
 * This is the Possible Grades Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('PossibleGradesEditorDirective')
        .controller('PossibleGradesEditorDialogController', PossibleGradesEditorDialogController);

    PossibleGradesEditorDialogController.$inject = ['$uibModal', '$log', '$state', '$uibModalInstance', '$scope', 'PossibleGrade', 'possibleGradesEntity'];

    function PossibleGradesEditorDialogController($uibModal, $log, state, $uibModalInstance, $scope, PossibleGrade, possibleGradesEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.possibleGrades = possibleGradesEntity;

        vm.cancel = cancel;
        vm.save = save;


        var onSaveFinished = function(result) {
            $scope.$emit('possible-grades-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.possibleGrades.id) {
                PossibleGrade.save(vm.possibleGrades, onSaveFinished);
            } else {
                if (vm.possibleGrades.id !== null) {
                    PossibleGrade.create(vm.possibleGrades, onSaveFinished);
                }
            }
        }

    }


})();
