(function() {
    'use strict';

    angular
        .module('dialogs-mass-ilp')
        .controller('MassILPInterviewDirectiveController', MassILPInterviewDirectiveController);

    MassILPInterviewDirectiveController.$inject = ['Logger', '$scope', '$uibModalInstance', '$cidConfig', 'Enrolments', 'MassILPInterviews', 'MassILPInterview'];

    function MassILPInterviewDirectiveController(Logger, $scope, $uibModalInstance, $cidConfig, Enrolments, MassILPInterviews, MassILPInterview) {
        /* jshint validthis:true */
        var vm = this;

        $scope.tinymceOptions = $cidConfig.tinymceOptions;

        $scope.ilpInterview = MassILPInterviews.data !== undefined ? MassILPInterviews.data : null;
        $scope.studentList = Enrolments.data !== undefined ? Enrolments.data : null;

        vm.create = create;
        vm.cancel = cancel;

        /**
         * This saves the courseGroups and closes that dialog box
         */
        function create() {
            Logger.log('massILPInterview DirectiveController::save called');
            if ($scope.ilpInterview) {
                $scope.ilpInterview.interviewTypeId = $scope.ilpInterview.interviewType.id;
                MassILPInterview.create($scope.ilpInterview, closeDialog);
            }
        }

        /**
         * This closes the mass ILPInterview dialog box without saving
         */
        function cancel() {
            Logger.log('MassILPInterviewDirectiveController::cancel called');
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
