(function() {
    'use strict';

    angular
        .module('dialogs-mass-praise-email')
        .controller('MassPraiseEmailDirectiveController', MassPraiseEmailDirectiveController);

    MassPraiseEmailDirectiveController.$inject = ['Logger', '$scope', '$uibModalInstance', '$cidConfig', 'Enrolments', 'MassLetters', 'MassLetter', 'StatementBankData'];

    function MassPraiseEmailDirectiveController(Logger, $scope, $uibModalInstance, $cidConfig, Enrolments, MassLetters, MassLetter, StatementBankData) {
        /* jshint validthis:true */
        var vm = this;

        $scope.letter = MassLetters.data !== undefined ? MassLetters.data : null;
        $scope.studentList = Enrolments.data !== undefined ? Enrolments.data : null;
        $scope.statementBank = StatementBankData !== undefined ? StatementBankData.data : null;

        vm.create = create;
        vm.cancel = cancel;

        /**
         * This saves the courseGroups and closes that dialog box
         */
        function create() {
            Logger.log('massLetter DirectiveController::save called');
            if ($scope.letter) {
                MassLetter.createPraiseEmail($scope.letter, closeDialog);
            }
        }

        /**
         * This closes the mass Letter ialog box without saving
         */
        function cancel() {
            Logger.log('MassLetterDirectiveController::cancel called');
            $uibModalInstance.dismiss('cancel');
        }
        /**
         * This is used to close the dialog box once the save is clicked.
         */
        function closeDialog() {
            $uibModalInstance.close();
        }

    }

}());
