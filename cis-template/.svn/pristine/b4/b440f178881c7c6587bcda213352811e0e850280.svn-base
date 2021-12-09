/**
 * This is the Enrolments Editor Directive Controller.
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';
    angular
        .module('EnrolmentsEditorDirective')
        .controller('EnrolmentsEditorCourseChangeDialogController', enrolmentsEditorCourseChangeDialogController);

    enrolmentsEditorCourseChangeDialogController.$inject = ['$log', '$rootScope', '$uibModalInstance', 'enrolmentEntity', 'courseGroups'];

    function enrolmentsEditorCourseChangeDialogController($log, $rootScope, $uibModalInstance, enrolmentEntity, courseGroups) {
        /* jshint validthis:true */
        var vm = this;
        vm.courseGroupOptions = courseGroups.data;
        vm.enrolment = enrolmentEntity.data;
        vm.dateOfChange = new Date();
        vm.dialogTitle = "Change Group";
        vm.onSaveFinished = onSaveFinished;
        vm.selectCourseGroup = selectCourseGroup;
        vm.selectCourse = selectCourse;

        function onSaveFinished(result) {
            $rootScope.$emit('enrolment-course-change-selected', result);
            $log.log(result);
            $uibModalInstance.close(result);
        }

        function selectCourse(id) {
            $log.info(id);
        }

        function selectCourseGroup(courseGroup) {
            onSaveFinished(courseGroup);
        }

        function cancel() {
            $log.log('II EnrolmentsEditorCourseChangeDialogController :: cancel called');
            $rootScope.$emit('enrolment-course-change-cancelled');
            $uibModalInstance.dismiss('cancel');
        }
    }

})();
