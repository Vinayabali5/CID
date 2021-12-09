/**
 * This is the StatementBanks Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StatementBanksEditorDirective')
        .controller('StatementBanksEditorController', StatementBanksEditorController);

    StatementBanksEditorController.$inject = ['$log', '$uibModal', '$scope', 'StatementBank'];

    function StatementBanksEditorController($log, $uibModal, $scope, StatementBank) {
        /* jshint validthis:true */
        var vm = this;

        vm.editStatementBanks = editStatementBanks;
        vm.addStatementBanks = addStatementBanks;

        function loadStatementBanks() {
            StatementBank.query().then(function(response) {
                $scope.statementBanks = response.data;
            }, function(response) {
                $log.error("Failed to load StatementBanks");
            });
        }

        function editStatementBanks(statementBankId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/statement-banks-editor/views/statement-banks-editorDialog.html',
                controller: 'StatementBanksEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    statementBanksEntity: function(StatementBank) {
                        return StatementBank.get(statementBankId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadStatementBanks();
            });
        }

        function addStatementBanks() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/statement-banks-editor/views/statement-banks-editorDialog.html',
                controller: 'StatementBanksEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    statementBanksEntity: [function() {
                        var statementBanks = {};
                        return statementBanks;
                    }]
                }
            });

            modalInstance.result.then().finally(function() {
                loadStatementBanks();
            });
        }

    }

})();
