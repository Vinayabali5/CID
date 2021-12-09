/**
 * This is the Course Bursary Editor Dialog Controller, it is used to handle the course editor dialog controller 
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('CourseEditorDirective')
        .controller('CourseEditorDialogController', CourseEditorDialogController);

    CourseEditorDialogController.$inject = ['$log', '$scope', '$state', '$uibModalInstance', '$uibModal', '$rootScope', 'courseEntity', 'Course'];

    function CourseEditorDialogController($log, $scope, $state, $uibModalInstance, $uibModal, $rootScope, courseEntity, Course) {
        /* jshint validthis:true */
        var vm = this;
        vm.course = courseEntity !== undefined ? courseEntity : {};
        vm.save = save;
        vm.cancel = cancel;


        var onSaveFinished = function(result) {
            $log.info('II Course  Saved');
            $scope.$emit('course-saved', result);
            $uibModalInstance.close(result);
        };


        /**
         * This saves the course and closes that dialog box
         */
        function save() {
            $log.log('CourseDialogController::save called');
            $log.info(vm.course);
            if (vm.course) {
                Course.save(vm.course, onSaveFinished);
            } else {
                return null;
            }
        }


        /**
         * This closes the course editor dialog box without saving
         */
        function cancel() {
            $log.log('CourseDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }

    }

})();
