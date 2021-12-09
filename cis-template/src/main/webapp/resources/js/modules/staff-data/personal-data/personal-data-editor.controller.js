/**
 * This is the Staff Personal data Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';
    angular
        .module('cid.staff-data.personal-data')
        .controller('PersonalDataEditorController', PersonalDataEditorController);

    PersonalDataEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'Staff', 'staffEntity'];

    function PersonalDataEditorController($log, $scope, $state, $rootScope, $uibModalInstance, Staff, staffEntity) {
        /* jshint validthis:true */
        var vm = this;
        $scope.staff = staffEntity !== undefined ? staffEntity : {};

        $scope.cancel = cancel;
        $scope.save = save;

        var onSaveFinished = function(result) {
            $scope.$emit('staff-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if ($scope.staff.id) {
                Staff.save($scope.staff, onSaveFinished);
            }
        }

    }


})();
