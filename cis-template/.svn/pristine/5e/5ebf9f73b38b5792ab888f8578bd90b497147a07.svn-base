/**
 * This is the ApplicationStatus Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('ApplicationStatusesEditorDirective')
        .controller('ApplicationStatusesEditorDialogController', ApplicationStatusesEditorDialogController);

    ApplicationStatusesEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'ApplicationStatus', 'applicationStatusesEntity'];

    function ApplicationStatusesEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, ApplicationStatus, applicationStatusesEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.applicationStatuses = applicationStatusesEntity !== undefined ? applicationStatusesEntity : {};

        vm.cancel = cancel;
        vm.save = save;

        var onSaveFinished = function(result) {
            $scope.$emit('application-statuses-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.applicationStatuses.id) {
                ApplicationStatus.save(vm.applicationStatuses, onSaveFinished);
            } else {
                if (vm.applicationStatuses.id !== null) {
                    ApplicationStatus.create(vm.applicationStatuses, onSaveFinished);
                }
            }
        }

    }


})();
