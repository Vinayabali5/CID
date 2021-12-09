(function() {

    angular
        .module('SelectionBoxes')
        .directive('fundingModelSelection', FundingModelSelectionDirective);

    FundingModelSelectionDirective.$inject = ['FundingModel'];

    function FundingModelSelectionDirective(FundingModel) {
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
            controller: ['FundingModel', function(FundingModel) {
                var vm = this;
                vm.fundingModels = [];
                FundingModel.query().then(function(response) {
                    vm.fundingModels = response.data;
                }, function(err) {
                    alert("Error Retrieving FundingModels");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/fundingModel/funding-model.selection.html',
        };
    }

})();
