/**
 * This is the Course Editor Controller, it is used to handle the course editor controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */



(function() {
    'use strict';

    angular
        .module('CourseEditorDirective')
        .controller('CourseEditorController', CourseEditorController);

    CourseEditorController.$inject = ['$log', '$scope', '$rootScope', '$uibModal', 'Course'];

    function CourseEditorController($log, $scope, $rootScope, $uibModal, Course) {
        /* jshint validthis:true */
        var vm = this;
        vm.dialog = {};
        vm.message = '';
        vm.course = vm.course ? vm.course : undefined;

        //Operations
        vm.init = init;
        vm.loadCourse = loadCourse;
        vm.editCourse = editCourse;
        vm.hasData = hasData;

        //Private Interface
        function init() {
            $log.log('CourseEditorDirectiveController::init called');
            this.loadCourse(vm.course.id);
        }

        function loadCourse(id) {
            Course.bursary(id).then(function(response) {
                $log.info('II Course Loaded');
                vm.course = response.data;
            });
        }

        function editCourse(id) {
            $log.log('CourseEditorDirectiveController::editContact called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/course-editor/views/course-editor-dialog.html',
                controller: 'CourseEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    courseEntity: ['Course', function(Course) {
                        return Course.get(id).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadCourse(vm.course.id);
            });
        }

        function hasData() {
            if (vm.course && vm.course !== undefined) {
                return true;
            } else {
                return false;
            }
        }
    }

})();
