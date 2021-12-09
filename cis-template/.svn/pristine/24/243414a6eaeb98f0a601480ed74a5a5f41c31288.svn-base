(function() {
    'use strict';

    angular
        .module('dialogs-edit-course-group')
        .controller('EditCourseGroupDirectiveController', EditCourseGroupDirectiveController);

    EditCourseGroupDirectiveController.$inject = ['Logger', '$scope', '$uibModalInstance', 'CourseGroup', 'CourseGroupEntry', 'timetableList'];

    function EditCourseGroupDirectiveController(Logger, $scope, $uibModalInstance, CourseGroup, CourseGroupEntry, timetableList) {
        var vm = this;

        $scope.courseGroup = CourseGroupEntry.data !== undefined ? CourseGroupEntry.data : null;
        $scope.timetable = timetableList !== undefined ? timetableList.data : null;
        $scope.save = save;
        $scope.cancel = cancel;
        //$scope.courseGroupId = $scope.courseGroup.id;

        /**
         * This saves the courseGroups and closes that dialog box
         */
        function save() {
            Logger.log('EditCourseGroupDirectiveController::save called');
            if ($scope.courseGroup.id != undefined) {
                CourseGroup.save($scope.courseGroup, closeDialog);
            } else {
                CourseGroup.create($scope.courseGroup, closeDialog);
            }
        }

        /**
         * This closes the courseGroups editor dialog box without saving
         */
        function cancel() {
            Logger.log('EditCourseGroupDirectiveController::cancel called');
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
