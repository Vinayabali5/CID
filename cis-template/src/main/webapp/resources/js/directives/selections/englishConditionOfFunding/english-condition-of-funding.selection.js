(function() {
    'use strict';

    angular
        .module('SelectionBoxes')
        .directive('englishConditionOfFundingSelection', EnglishConditionOfFundingSelectionDirective);

    EnglishConditionOfFundingSelectionDirective.$inject = ['EnglishConditionOfFunding'];

    function EnglishConditionOfFundingSelectionDirective(EnglishConditionOfFunding) {
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
            controller: ['EnglishConditionOfFunding', function(EnglishConditionOfFunding) {
                var vm = this;
                vm.englishConditionOfFundings = [];
                EnglishConditionOfFunding.query().then(function(response) {
                    vm.englishConditionOfFundings = response.data;
                }, function(response) {
                    bootbox.alert("Error Retrieving EnglishConditionOfFundings");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/englishConditionOfFunding/english-condition-of-funding.selection.html',

        };
    }

})();
