(function() {
    'use strict';

    angular
        .module('StudentCollegeFundPaidDirective')
        .controller('StudentCollegeFundPaidEditorController', StudentCollegeFundPaidEditorController);

    StudentCollegeFundPaidEditorController.$inject = ['collegeFundEntity', 'StudentCollegeFundPaid', '$uibModalInstance', '$scope'];

    function StudentCollegeFundPaidEditorController(collegeFundEntity, StudentCollegeFundPaid, $uibModalInstance, $scope) {
        /* jshint validthis:true */
        var vm = this;

        vm.studentCollegeFundPaid = collegeFundEntity !== undefined ? collegeFundEntity : {};

        vm.save = save;
        vm.cancel = cancel;

        var onSaveFinished = function(result) {
            $scope.$emit("fund-paid-updated", result);
            $uibModalInstance.close(result);
        };

        function save() {
            StudentCollegeFundPaid.save(vm.studentCollegeFundPaid, onSaveFinished);
        }

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }


    }


})();
