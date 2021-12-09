/**
 * This is the Timetable Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('TimetableEditorDirective')
        .controller('TimetableEditorController', TimetableEditorController);

    TimetableEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'Timetable', 'CourseGroup'];

    function TimetableEditorController($log, $scope, $state, $rootScope, $uibModal, Timetable, CourseGroup) {
        /* jshint validthis:true */
        var vm = this;
        vm.dialog = {};

        vm.courseGroupId = vm.courseGroupId ? vm.courseGroupId : undefined;
        vm.timetable = vm.timetable ? vm.timetable : [];
        vm.init = init;
        vm.loadTimetable = loadTimetable;
        vm.editTimetable = editTimetable;
        vm.deleteTimetable = deleteTimetable;
        vm.addTimetable = addTimetable;

        function init() {
            $log.info('II EntryQualifications Editor Initialised');
            vm.loadTimetable();
        }

        function loadTimetable(courseGroupId) {
            $log.info('II Loading EntryQualifications Data');
            CourseGroup.timetables(courseGroupId).then(function(response) {
                $log.log('TimetableEditorController::loadTimetable called');
                vm.timetable = response.data;
            }, function(response) {
                $log.error('EE Timetable could not be loaded');
            });
        }

        function editTimetable(id) {
            $log.log('TimetableEditorController::editContact called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/timetable-editor/views/timetable-editor-dialog.html',
                controller: 'TimetableEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    timetableEntity: ['Timetable', function(Timetable) {
                        return Timetable.get(id).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });
            // Reload Contacts after dialog closed
            modalInstance.result.then().finally(function() {
                vm.loadTimetable(vm.courseGroupId);
            });
        }

        function deleteTimetable(id) {
            $log.log('TimetableEditorController::deleteTimetable called');
            if (id) {
                var msg = "Are you sure you want to delete this Timetable?";
                if (window.confirm(msg)) {
                    Timetable.delete(id).then(function(response) {
                        $log.info("II Timetable ($studentId) has been deleted");
                    }, function(response) {
                        $log.info("EE A problem occurred trying to delete Timetable ($studentId)");
                    }).finally(function() {
                        vm.loadTimetable(vm.courseGroupId);
                    });
                }
            }
        }

        //Create New Timetable
        function addTimetable(courseGroupId) {
            $log.log('TimetableEditorController:: AddTimetable called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/timetable-editor/views/timetable-editor-dialog.html',
                controller: 'TimetableEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    timetableEntity: [function() {
                        var timetable = {};
                        timetable.courseGroupId = courseGroupId;
                        return timetable;
                    }]
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadTimetable(vm.courseGroupId);
            });
        }

    }
})();
