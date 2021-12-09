(function() {

    angular
        .module('SelectionBoxes')
        .directive('possibleGradeSetSelection', PossibleGradeSetSelectionDirective);

    PossibleGradeSetSelectionDirective.$inject = ['PossibleGradeSet'];

    function PossibleGradeSetSelectionDirective(PossibleGradeSet) {
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
            controller: ['PossibleGradeSet', function(PossibleGradeSet) {
                var vm = this;
                vm.possibleGradeSets = [];
                PossibleGradeSet.query().then(function(response) {
                    vm.possibleGradeSets = response.data;
                }, function(err) {
                    alert("Error Retrieving PossibleGradeSets");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/possibleGradeSet/possible-grade-set.selection.html',
        };
    }

})();
