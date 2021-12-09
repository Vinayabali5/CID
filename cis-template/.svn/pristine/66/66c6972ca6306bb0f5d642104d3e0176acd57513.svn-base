/**
 * This is the StudentConcessionType Table Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StudentConcessionEditorDirective')
        .controller('StudentConcessionEditorDialogDirectiveController', StudentConcessionEditorDialogDirectiveController);

    StudentConcessionEditorDialogDirectiveController.$inject = ['$log', '$scope', '$rootScope', '$uibModalInstance', 'StudentCourseConcession', 'concessionEntity', 'studentCourses', 'BulkStudentCourseConcession'];

    function StudentConcessionEditorDialogDirectiveController($log, $scope, $rootScope, $uibModalInstance, StudentCourseConcession, concessionEntity, studentCourses, BulkStudentCourseConcession) {
        var vm = this;

        // Public Interface

        $scope.concession = concessionEntity ? concessionEntity : undefined;
        //   $scope.bulkCourseConcession = bulkCourseConcessionEntity ? bulkCourseConcessionEntity : undefined;
        $scope.courses = studentCourses ? studentCourses.data : undefined;

        $scope.save = saveConcession;
        $scope.saveBulkCourseConcession = saveBulkCourseConcession;
        $scope.cancel = cancel;

        // Private Interface

        // Event Listener
        $scope.$on('$destroy', $rootScope.$on('course-concession-saved', function(data) {
            StudentCourseConcession.getByStudentId($scope.concession.studentId).then(function(response) {
                vm.courseConcessions = response.data;
            });
        }));

        var onSaveFinished = function(result) {
            $log.info('II StudentCourseConcession Saved');
            $scope.$emit('course-concession-saved', result);
            $uibModalInstance.close(result);
        };

        function saveConcession() {
            if ($scope.concession !== undefined) {
                if ($scope.concession.new === true) {
                    StudentCourseConcession.create($scope.concession, onSaveFinished);
                } else {
                    StudentCourseConcession.save($scope.concession, onSaveFinished);
                }
            }
        }

        function saveBulkCourseConcession() {
            if ($scope.concession !== undefined) {
                if ($scope.concession) {
                    BulkStudentCourseConcession.create($scope.concession, onSaveFinished);
                }
            }
        }

        function cancel() {
            $log.log('II Add/Edit StudentCourseConcession Cancelled');
            $uibModalInstance.dismiss('cancel');
        }

    }


})();
