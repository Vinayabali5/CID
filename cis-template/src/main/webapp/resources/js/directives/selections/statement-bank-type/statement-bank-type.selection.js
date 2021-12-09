(function() {

    angular
        .module('SelectionBoxes')
        .directive('statementBankTypeSelection', StatementBankTypeSelectionDirective);

    StatementBankTypeSelectionDirective.$inject = ['StatementBankType'];

    function StatementBankTypeSelectionDirective(StatementBankType) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                name: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel'
            },
            link: function(scope, element, attrs, controller) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['StatementBankType', function(StatementBankType) {
                var vm = this;
                vm.statementBankTypes = [];
                StatementBankType.query().then(function(response) {
                    vm.statementBankTypes = response.data;
                }, function(err) {
                    alert("Error Retrieving StatementBankTypes");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/statement-bank-type/statement-bank-type.selection.html',
        };
    }

})();
