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
        .module('ILPLetterEditorDirective')
        .controller('ILPLetterEditorDialogController', ILPLetterEditorDialogController);

    ILPLetterEditorDialogController.$inject = ['$scope', '$uibModalInstance', '$cidConfig', 'Letter', 'letterEntity'];

    function ILPLetterEditorDialogController($scope, $uibModalInstance, $cidConfig, Letter, letterEntity) {

        $scope.tinymceOptions = $cidConfig.tinymceOptions;


        $scope.letter = letterEntity;

        $scope.save = save;
        $scope.send = send;
        $scope.cancel = cancel;
        $scope.cancelSending = cancelSending;

        var onSaveFinished = function(result) {
            $scope.$emit('ilp-letter-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            Letter.save($scope.letter, onSaveFinished);
        }

        function send() {
            $scope.letter.processingFlag = 1;
            save();
        }

        function cancelSending() {
            $scope.letter.processingFlag = 0;
            save();
        }
    }

})();
