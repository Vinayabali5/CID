(function() {
    'use strict';

    angular
        .module('dialogs-edit-course')
        .controller('EditCourseDirectiveController', EditCourseDirectiveController);

    EditCourseDirectiveController.$inject = ['Logger', '$scope', '$uibModalInstance', 'Course', 'CourseEntry'];

    function EditCourseDirectiveController(Logger, $scope, $uibModalInstance, Course, CourseEntry) {
        $scope.course = CourseEntry.data !== undefined ? CourseEntry.data : null;

        $scope.save = save;
        $scope.cancel = cancel;

        /**
         * This saves the courses and closes that dialog box
         */
        function save() {
            Logger.log('EditCourseDirectiveController::save called');
            if ($scope.course.id != undefined) {
                Course.save($scope.course, closeDialog);
            } else {
                Course.create($scope.course, closeDialog);
            }
        }

        /**
         * This closes the courses editor dialog box without saving
         */
        function cancel() {
            Logger.log('EditCourseDirectiveController::cancel called');
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
