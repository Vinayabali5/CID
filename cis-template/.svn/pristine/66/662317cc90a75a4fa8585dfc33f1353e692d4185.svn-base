(function() {

    angular
        .module('SelectionBoxes')
        .directive('riskLevelSelection', RiskLevelSelectionDirective);

    RiskLevelSelectionDirective.$inject = ['RiskLevel'];

    function RiskLevelSelectionDirective(RiskLevel) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                name: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel',
                ngRequired: '=',
                altNullText: '=altNullText'
            },
            link: function(scope, element, attrs, controller) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['RiskLevel', function(RiskLevel) {
                var vm = this;
                vm.riskLevels = [];
                RiskLevel.query().then(function(response) {
                    vm.riskLevels = response.data;
                }, function(err) {
                    alert("Error Retrieving RiskLevels");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/risk-level/risk-level.selection.html',
        };
    }

})();
