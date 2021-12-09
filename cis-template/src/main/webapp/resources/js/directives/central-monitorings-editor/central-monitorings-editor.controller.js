/**
 * This is the CentralMonitorings Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('CentralMonitoringsEditorDirective')
        .controller('CentralMonitoringsEditorController', CentralMonitoringsEditorController);

    CentralMonitoringsEditorController.$inject = ['$log', '$uibModal', '$scope', 'CentralMonitoring'];

    function CentralMonitoringsEditorController($log, $uibModal, $scope, CentralMonitoring) {
        /* jshint validthis:true */
        var vm = this;

        vm.editCentralMonitorings = editCentralMonitorings;
        vm.addCentralMonitorings = addCentralMonitorings;

        function loadCentralMonitorings() {
            CentralMonitoring.query().then(function(response) {
                $scope.centralMonitorings = response.data;
                $log.info("Loading Faculty ");
            }, function(response) {
                $log.error("Failed to load Faculties");
            });
        }


        function editCentralMonitorings(centralMonitoringId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/central-monitorings-editor/views/central-monitorings-editorDialog.html',
                controller: 'CentralMonitoringsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    centralMonitoringsEntity: function(CentralMonitoring) {
                        return CentralMonitoring.get(centralMonitoringId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadCentralMonitorings();
            });
        }


        function addCentralMonitorings() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/central-monitorings-editor/views/central-monitorings-editor-addDialog.html',
                controller: 'CentralMonitoringsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    centralMonitoringsEntity: function() {
                        var centralMonitorings = {};
                        return centralMonitorings;
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadCentralMonitorings();
            });
        }

    }

})();
