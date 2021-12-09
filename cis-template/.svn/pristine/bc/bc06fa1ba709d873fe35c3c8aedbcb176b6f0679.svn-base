/**
 * This is the FAculty Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('FacultiesEditorDirective')
        .controller('FacultiesEditorDialogController', FacultiesEditorDialogController);

    FacultiesEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'Faculty', 'facultiesEntity'];

    function FacultiesEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, Faculty, facultiesEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.faculties = facultiesEntity !== undefined ? facultiesEntity : {};

        vm.cancel = cancel;
        vm.save = save;

        var onSaveFinished = function(result) {
            $scope.$emit('faculties-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.faculties.id) {
                Faculty.save(vm.faculties, onSaveFinished);
            } else {
                if (vm.faculties.id !== null) {
                    Faculty.create(vm.faculties, onSaveFinished);
                }
            }
        }

    }


})();
