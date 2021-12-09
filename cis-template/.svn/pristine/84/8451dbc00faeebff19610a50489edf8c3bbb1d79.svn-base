(function() {

    angular
        .module('SelectionBoxes')
        .directive('llddHealthProblemCategorySelection', LLDDHealthProblemCategorySelectionDirective);

    LLDDHealthProblemCategorySelectionDirective.$inject = ['LLDDHealthProblemCategory'];

    function LLDDHealthProblemCategorySelectionDirective(LLDDHealthProblemCategory) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                name: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel',
                ngRequired: '='
            },
            link: function(scope, element, attrs, controller) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['LLDDHealthProblemCategory', function(LLDDHealthProblemCategory) {
                var vm = this;
                vm.lLDDHealthProblemCategories = [];
                LLDDHealthProblemCategory.query().then(function(response) {
                    vm.lLDDHealthProblemCategories = response.data;
                }, function(err) {
                    alert("Error Retrieving LLDDHealthProblemCategories");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/llddHealthProblemCategory/lldd-health-problem-category.selection.html',
        };
    }

})();
