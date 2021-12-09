(function() {
    'use strict';

    angular
        .module('SelectionBoxes')
        .directive('mathsConditionOfFundingSelection', MathsConditionOfFundingSelectionDirective);

    MathsConditionOfFundingSelectionDirective.$inject = ['MathsConditionOfFunding'];

    function MathsConditionOfFundingSelectionDirective(MathsConditionOfFunding) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel',
                includeBlank: '=?'
            },
            link: function(scope, element, attrs) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['MathsConditionOfFunding', function(MathsConditionOfFunding) {
                var vm = this;
                vm.mathsConditionOfFundings = [];
                MathsConditionOfFunding.query().then(function(response) {
                    vm.mathsConditionOfFundings = response.data;
                }, function(response) {
                    bootbox.alert("Error Retrieving MathsConditionOfFundings");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/mathsConditionOfFunding/maths-condition-of-funding.selection.html',

        };
    }

})();
