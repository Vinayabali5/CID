/**
 * This is the Student Bursary Editor Dialog Controller, it is used to handle the student bursary editor dialog controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('TextLookupEditorDirective')
        .controller('TextLookupEditorDialogController', TextLookUpEditorDialogController);

    TextLookUpEditorDialogController.$inject = ['$log', '$scope', '$state', '$uibModalInstance', '$uibModal', '$rootScope', 'textLookupEntity', 'TextLookup'];

    function TextLookUpEditorDialogController($log, $scope, $state, $uibModalInstance, $uibModal, $rootScope, textLookupEntity, TextLookup) {
        /* jshint validthis:true */
        var vm = this;
        vm.textLookup = textLookupEntity !== undefined ? textLookupEntity : {};

        vm.save = save;
        vm.cancel = cancel;


        var onSaveFinished = function(result) {
            $scope.$emit('text-lookup-saved', result);
            $uibModalInstance.close(result);
        };


        /**
         * This saves the TextLookup and closes that dialog box
         */
        function save() {
            $log.log('TextLookupDialogController::save called');
            $log.info(vm.textLookup);
            if (vm.textLookup) {
                TextLookup.save(vm.textLookup, onSaveFinished);
            } else {
                return null;
            }
        }


        /**
         * This closes the TextLookup editor dialog box without saving
         */
        function cancel() {
            $log.log('TextLookupDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }

    }

})();
