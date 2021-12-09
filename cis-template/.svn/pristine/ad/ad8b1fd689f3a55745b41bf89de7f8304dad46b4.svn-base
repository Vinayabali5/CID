/**
 * This is the Person Editor Dialog Table Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */
(function() {
    'use strict';
    angular
        .module('PersonEditorDirective')
        .controller('PersonEditorDialogController', PersonEditorDialogController);

    PersonEditorDialogController.$inject = ['$log', '$scope', '$state', '$uibModalInstance', '$uibModal', '$rootScope', 'personEntity', 'Person'];

    function PersonEditorDialogController($log, $scope, $state, $uibModalInstance, $uibModal, $rootScope, personEntity, Person) {
        /* jshint validthis:true */
        var vm = this;

        vm.person = personEntity;
        vm.save = save;
        vm.cancel = cancel;

        var onSaveFinished = function(result) {
            $log.info('II Person Saved - Success');
            $scope.$emit("person-save-success", result);
            $uibModalInstance.close(result);
        };

        var onSaveFailed = function(result) {
            $log.info('II Person Saved - Failed');
            $scope.$emit("person-save-failed", result);
            $uibModalInstance.close(result);
        };

        /**
         * This saves the person and closes that dialog box
         */
        function save() {
            $log.log('PersonDialogController::save called');
            if (vm.person.id) {
                //update the contact information
                Person.save(vm.person, onSaveFinished);
            }
        }

        /**
         * This closes the person editor dialog box without saving 
         */
        function cancel() {
            $log.log('PersonDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }

    }

})();
