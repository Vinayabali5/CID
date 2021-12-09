(function() {

    angular
        .module('SelectionBoxes')
        .directive('llddHealthProblemSelection', LLDDHealthProblemSelectionDirective);

    LLDDHealthProblemSelectionDirective.$inject = ['LLDDHealthProblem'];

    function LLDDHealthProblemSelectionDirective(LLDDHealthProblem) {
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
            controller: ['LLDDHealthProblem', function(LLDDHealthProblem) {
                var vm = this;
                vm.llddHealthProblems = [];
                LLDDHealthProblem.query().then(function(response) {
                    vm.llddHealthProblems = response.data;
                }, function(err) {
                    alert("Error Retrieving LLDDHealthProblems");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/llddHealthProblem/lldd-health-problem.selection.html',
        };
    }

})();
