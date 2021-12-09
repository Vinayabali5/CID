/**
 * This is the Department Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('DepartmentsEditorDirective')
        .controller('DepartmentsEditorDialogController', DepartmentsEditorDialogController);

    DepartmentsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'Department', 'departmentsEntity'];

    function DepartmentsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, Department, departmentsEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.departments = departmentsEntity !== undefined ? departmentsEntity : {};

        vm.cancel = cancel;
        vm.save = save;

        var onSaveFinished = function(result) {
            $scope.$emit('departments-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.departments.id) {
                Department.save(vm.departments, onSaveFinished);
            } else {
                if (vm.departments.id !== null) {
                    Department.create(vm.departments, onSaveFinished);
                }

            }
        }

    }


})();
