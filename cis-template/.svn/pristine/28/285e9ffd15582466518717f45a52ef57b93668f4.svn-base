/**
 * This is the RiskLevels Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('RiskLevelsEditorDirective')
        .controller('RiskLevelsEditorController', RiskLevelsEditorController);

    RiskLevelsEditorController.$inject = ['$log', '$uibModal', '$scope', 'RiskLevel'];

    function RiskLevelsEditorController($log, $uibModal, $scope, RiskLevel) {
        /* jshint validthis:true */
        var vm = this;

        vm.editRiskLevels = editRiskLevels;
        vm.addRiskLevels = addRiskLevels;

        function loadRiskLevels() {
            RiskLevel.query().then(function(response) {
                $scope.riskLevels = response.data;
                $log.info("Loading RiskLevels ");
            }, function(response) {
                $log.error("Failed to load RiskLevels");
            });
        }

        function editRiskLevels(riskLevelId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/risk-levels-editor/views/risk-levels-editorDialog.html',
                controller: 'RiskLevelsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    riskLevelsEntity: ['RiskLevel', function(RiskLevel) {
                        return RiskLevel.get(riskLevelId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });

            modalInstance.result.then().finally(function() {
                loadRiskLevels();
            });
        }

        function addRiskLevels() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/risk-levels-editor/views/risk-levels-editor-addDialog.html',
                controller: 'RiskLevelsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    riskLevelsEntity: [function() {
                        var riskLevels = {};
                        return riskLevels;
                    }]
                }
            });

            modalInstance.result.then().finally(function() {
                loadRiskLevels();
            });
        }
    }

})();
