/**
 * This is the Letter Template Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('LetterTemplateEditorDirective')
        .controller('LetterTemplateEditorDialogController', LetterTemplateEditorDialogController);

    LetterTemplateEditorDialogController.$inject = ['letterTemplateEntity', 'LetterTemplate', '$scope', '$uibModalInstance'];

    function LetterTemplateEditorDialogController(letterTemplateEntity, LetterTemplate, $scope, $uibModalInstance) {
        /* jshint validthis:true */
        var vm = this;
        vm.letterTemplate = letterTemplateEntity !== undefined ? letterTemplateEntity : {};

        vm.cancel = cancel;
        vm.save = save;

        var onSaveFinished = function(result) {
            $scope.$emit('letter-template-updated', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.letterTemplate.id) {
                LetterTemplate.save(vm.letterTemplate, onSaveFinished);
            } else {
                if (vm.letterTemplate.id !== null) {
                    LetterTemplate.create(vm.letterTemplate, onSaveFinished);
                }
            }
        }
    }

})();
