/**
 * This is the StatementBankTypes Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StatementBankTypesEditorDirective')
        .controller('StatementBankTypesEditorController', StatementBankTypesEditorController);

    StatementBankTypesEditorController.$inject = ['$log', '$uibModal', '$scope', 'StatementBankType'];

    function StatementBankTypesEditorController($log, $uibModal, $scope, StatementBankType) {
        /* jshint validthis:true */
        var vm = this;

        vm.editStatementBankTypes = editStatementBankTypes;
        vm.addStatementBankTypes = addStatementBankTypes;

        function loadStatementBankTypes() {
            StatementBankType.query().then(function(response) {
                $scope.statementBankTypes = response.data;
            }, function(response) {
                $log.error("Failed to load StatementBankTypes");
            });
        }

        function editStatementBankTypes(statementBankTypeId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/statement-bank-types-editor/views/statement-bank-types-editorDialog.html',
                controller: 'StatementBankTypesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    statementBankTypesEntity: function(StatementBankType) {
                        return StatementBankType.get(statementBankTypeId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadStatementBankTypes();
            });
        }

        function addStatementBankTypes() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/statement-bank-types-editor/views/statement-bank-types-editor-addDialog.html',
                controller: 'StatementBankTypesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    statementBankTypesEntity: [function() {
                        var statementBankTypes = {};
                        return statementBankTypes;
                    }]
                }
            });

            modalInstance.result.then().finally(function() {
                loadStatementBankTypes();
            });
        }

    }

})();
