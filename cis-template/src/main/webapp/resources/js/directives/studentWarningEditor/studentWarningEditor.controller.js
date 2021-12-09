/**
 * This is the Student Special Warning Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */



(function() {
    'use strict';

    angular
        .module('StudentWarningEditorDirective')
        .controller('StudentWarningEditorController', StudentWarningEditorController);

    StudentWarningEditorController.$inject = ['$log', '$scope', '$rootScope', '$uibModal', 'StudentWarning'];

    function StudentWarningEditorController($log, $scope, $rootScope, $uibModal, StudentWarning) {
        /* jshint validthis:true */
        var vm = this;
        vm.dialog = {};
        vm.message = '';

        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.studentWarning = vm.studentWarning ? vm.studentWarning : {};
        vm.init = init;
        vm.loadStudentWarning = loadStudentWarning;
        vm.editStudentWarning = editStudentWarning;


        function init() {
            $log.log('StudentWarningDetailsDirectiveController::init called');
            vm.loadStudentWarning(vm.studentId);
        }

        function loadStudentWarning(studentId) {
            StudentWarning.get(studentId).then(function(response) {
                $log.info('II StudentWarning Loaded');
                vm.studentWarning = response.data;
            });
        }

        //update the StudentWarning information
        function editStudentWarning(studentId) {
            $log.log('StudentWarningDetailsDirectiveController::editContact called');
            //var studentWarningId = id;
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/studentWarningEditor/views/studentWarningEditorDialog.html',
                controller: 'StudentWarningEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentWarningEntity: ['StudentWarning', function(StudentWarning) {
                        return StudentWarning.get(studentId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadStudentWarning(vm.studentId);
            });
        }

        $scope.hasData = function() {
            if ($scope.studentWarning && $scope.studentWarning !== undefined) {
                return true;
            } else {
                return false;
            }
        };
    }

})();
