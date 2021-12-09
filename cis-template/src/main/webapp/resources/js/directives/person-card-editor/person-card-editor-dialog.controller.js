/**
 * This is the PersonCardEditorDialogController
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('PersonCardEditorDirective')
        .controller('PersonCardEditorDialogController', PersonCardEditorDialogController);

    PersonCardEditorDialogController.$inject = ['$log', '$scope', '$state', '$uibModalInstance', '$uibModal', '$rootScope', 'personCardEntity', 'Person'];

    function PersonCardEditorDialogController($log, $scope, $state, $uibModalInstance, $uibModal, $rootScope, personCardEntity, Person) {
        /* jshint validthis:true */
        //Public Interface
        var vm = this;
        vm.personCard = personCardEntity !== undefined ? personCardEntity : {};
        vm.save = save;
        vm.cancel = cancel;

        var onSaveFinished = function(result) {
            $log.info('II Person crad Saved');
            $scope.$emit('person-save-success', result);
            $uibModalInstance.close(result);
        };

        /**
         * This saves the Person card and closes that dialog box
         */
        function save() {
            $log.log('PersonDialogController::save called');
            if (vm.personCard.id) {
                //update the Person card information
                Person.save(vm.personCard, onSaveFinished);
            }
        }

        /**
         * This closes the PersonCard editor dialog box without saving 
         */
        function cancel() {
            $log.log('PersonCardDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }

})();
