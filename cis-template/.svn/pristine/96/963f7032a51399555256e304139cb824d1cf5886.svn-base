/**
 * This is the Entry Qualifications Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('StudentRiskAssessmentEditorDirective')
        .controller('StudentRiskAssessmentEditorDialogController', StudentRiskAssessmentEditorDialogController);

    StudentRiskAssessmentEditorDialogController.$inject = ['Logger', '$scope', '$uibModalInstance', 'StudentRiskAssessment', 'studentRiskAssessmentEntity'];

    function StudentRiskAssessmentEditorDialogController(Logger, $scope, $uibModalInstance, StudentRiskAssessment, studentRiskAssessmentEntity) {
        $scope.studentRiskAssessment = studentRiskAssessmentEntity !== undefined ? studentRiskAssessmentEntity : {};

        $scope.save = save;
        $scope.cancel = cancel;

        function save() {
            Logger.log('RiskAssessmentDialogController::save called');
            if ($scope.studentRiskAssessment.studentId !== null) {
                StudentRiskAssessment.save($scope.studentRiskAssessment, onSaveFinished);
            } else {
                $scope.studentRiskAssessment.studentId = $scope.studentId;
                StudentRiskAssessment.create($scope.studentRiskAssessment, onSaveFinished);
            }
        }

        var onSaveFinished = function(result) {
            $scope.$emit('student-risk-assessment-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }
    }
})();
