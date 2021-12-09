/**
 * This is the Tutor Groups Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('TutorGroupsEditorDirective')
        .controller('TutorGroupsEditorDialogController', TutorGroupsEditorDialogController);

    TutorGroupsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'TutorGroup', 'tutorGroupsEntity'];

    function TutorGroupsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, TutorGroup, tutorGroupsEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.tutorGroups = tutorGroupsEntity !== undefined ? tutorGroupsEntity : {};

        vm.cancel = cancel;
        vm.save = save;


        var onSaveFinished = function(result) {
            $scope.$emit('tutor-groups-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.tutorGroups.id) {
                TutorGroup.save(vm.tutorGroups, onSaveFinished);
            } else {
                if (vm.tutorGroups.id !== null) {
                    TutorGroup.create(vm.tutorGroups, onSaveFinished);
                }
            }
        }

    }


})();
