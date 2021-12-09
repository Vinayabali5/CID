/**
 * This is the studentCourseSupportTypeType Table Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StudentCourseSupportTypesEditorDirective')
        .controller('StudentCourseSupportTypesEditorDialogDirectiveController', StudentCourseSupportTypesEditorDialogDirectiveController);

    StudentCourseSupportTypesEditorDialogDirectiveController.$inject = ['$log', '$scope', '$rootScope', '$uibModalInstance', 'StudentCourseSupportType', 'studentCourseSupportTypeEntity', 'studentCourses', 'studentSupportTypes'];

    function StudentCourseSupportTypesEditorDialogDirectiveController($log, $scope, $rootScope, $uibModalInstance, StudentCourseSupportType, studentCourseSupportTypeEntity, studentCourses, studentSupportTypes) {
        var vm = this;

        // Public Interface

        $scope.supportType = studentCourseSupportTypeEntity ? studentCourseSupportTypeEntity : undefined;
        $scope.supportTypes = studentSupportTypes ? studentSupportTypes.data : undefined;
        $scope.courses = studentCourses ? studentCourses.data : undefined;

        $scope.save = saveConcession;
        $scope.cancel = cancel;

        // Private Interface

        // Event Listener
        $scope.$on('$destroy', $rootScope.$on('course-supportType-saved', function(data) {
            StudentCourseSupportType.getByStudentId($scope.supportType.studentId).then(function(response) {
                vm.courseConcessions = response.data;
            });
        }));

        var onSaveFinished = function(result) {
            $log.info('II StudentCourseSupportType Saved');
            $scope.$emit('course-support-types-saved', result);
            $uibModalInstance.close(result);
        };

        function saveConcession() {
            if ($scope.supportType !== undefined) {
                if ($scope.supportType.new === true) {
                    StudentCourseSupportType.create($scope.supportType, onSaveFinished);
                } else {
                    StudentCourseSupportType.save($scope.supportType, onSaveFinished);
                }
            }
        }

        function cancel() {
            $log.log('II Add/Edit StudentCourseSupportType Cancelled');
            $uibModalInstance.dismiss('cancel');
        }

    }


})();
