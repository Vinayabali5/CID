/**
 * This is the PastoralMonitor Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */



(function() {
    'use strict';

    angular
        .module('PastoralMonitorEditorDirective')
        .controller('PastoralMonitorEditorController', PastoralMonitorEditorController);

    PastoralMonitorEditorController.$inject = ['$log', '$scope', '$rootScope', '$uibModal', 'PastoralMonitor'];

    function PastoralMonitorEditorController($log, $scope, $rootScope, $uibModal, PastoralMonitor) {
        /* jshint validthis:true */
        var vm = this;
        vm.dialog = {};
        vm.message = '';

        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.pastoralMonitor = vm.pastoralMonitor ? vm.pastoralMonitor : {};
        vm.init = init;
        vm.loadPastoralMonitor = loadPastoralMonitor;
        vm.editPastoralMonitor = editPastoralMonitor;


        function init() {
            $log.log('PastoralMonitorDetailsDirectiveController::init called');
            vm.loadPastoralMonitor(vm.studentId);
        }

        function loadPastoralMonitor(studentId) {
            PastoralMonitor.get(studentId).then(function(response) {
                $log.info('II PastoralMonitor Loaded');
                vm.pastoralMonitor = response.data;
            });
        }

        //update the PastoralMonitor information
        function editPastoralMonitor(studentId) {
            $log.log('PastoralMonitorDetailsDirectiveController::editContact called');
            //var pastoralMonitorId = id;
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/pastoral-monitor-editor/views/pastoral-monitor-editorDialog.html',
                controller: 'PastoralMonitorEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    pastoralMonitorEntity: ['PastoralMonitor', function(PastoralMonitor) {
                        return PastoralMonitor.get(studentId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadPastoralMonitor(vm.studentId);
            });
        }

        $scope.hasData = function() {
            if ($scope.pastoralMonitor && $scope.pastoralMonitor !== undefined) {
                return true;
            } else {
                return false;
            }
        };
    }

})();
