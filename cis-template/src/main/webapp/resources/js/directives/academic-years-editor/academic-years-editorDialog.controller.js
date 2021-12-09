/**
 * This is the AcademicYear Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('AcademicYearsEditorDirective')
        .controller('AcademicYearsEditorDialogController', academicYearsEditorDialogController);

    academicYearsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'AcademicYear', 'academicYearsEntity'];

    function academicYearsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, AcademicYear, academicYearsEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.academicYears = academicYearsEntity !== undefined ? academicYearsEntity : {};

        vm.cancel = cancel;
        vm.save = save;
        vm.add = add;

        var onSaveFinished = function(result) {
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function add() {
            if (vm.academicYears.id !== null) {
                AcademicYear.create(vm.academicYears, onSaveFinished);
            }
        }

        function save() {
            if (vm.academicYears.id) {
                AcademicYear.save(vm.academicYears, onSaveFinished);
            }
        }

    }


})();
