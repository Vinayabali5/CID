/**
 * This is the Enrolments Editor Group Change Dialog Controller used by EnrolmentsEditorDirective
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('EnrolmentsEditorDirective')
        .controller('EnrolmentsEditorGroupChangeDialogController', enrolmentsEditorGroupChangeDialogController);

    enrolmentsEditorGroupChangeDialogController.$inject = ['$log', '$rootScope', '$uibModalInstance', 'enrolmentEntity', 'courseGroups'];

    function enrolmentsEditorGroupChangeDialogController($log, $rootScope, $uibModalInstance, enrolmentEntity, courseGroups) {
        /* jshint validthis:true */
        var vm = this;
        vm.courseGroupOptions = courseGroups.data;
        vm.enrolment = enrolmentEntity.data;
        vm.dateOfChange = new Date();
        vm.dialogTitle = "Change Group";
        vm.selectCourseGroup = selectCourseGroup;
        vm.cancel = cancel;

        var onSaveFinished = function(result) {
            $rootScope.$emit('enrolment-group-change-selected', result);
            $log.log(result);
            $uibModalInstance.close(result);
        };

        function selectCourseGroup(courseGroup) {
            onSaveFinished(courseGroup);
        }

        function cancel() {
            $log.log('II EnrolmentsEditorGroupChangeDialogController :: cancel called');
            $rootScope.$emit('enrolment-group-change-cancelled');
            $uibModalInstance.dismiss('cancel');
        }
    }

})();
