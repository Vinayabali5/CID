/**
 * This is the AcademicYears Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */
(function() {
    'use strict';

    angular
        .module('SchoolsEditorDirective')
        .controller('SchoolsEditorDialogController', SchoolsEditorDialogController);

    SchoolsEditorDialogController.$inject = ['$uibModal', '$log', 'School', 'schoolsEntity', '$uibModalInstance', '$scope'];

    function SchoolsEditorDialogController($uibModal, $log, School, schoolsEntity, $uibModalInstance, $scope) {
        /* jshint validthis:true */
        var vm = this;
        vm.schools = schoolsEntity;

        vm.cancel = cancel;
        vm.save = save;


        var onSaveFinished = function(result) {
            $scope.$emit('schools-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.schools.id) {
                School.save(vm.schools, onSaveFinished);
            } else {
                if (vm.schools.id !== null) {
                    School.create(vm.schools, onSaveFinished);
                }
            }

        }

    }

})();
