(function() {

    angular
        .module('SelectionBoxes')
        .directive('outcomeSelection', OutcomeSelectionDirective);

    OutcomeSelectionDirective.$inject = ['Outcome'];

    function OutcomeSelectionDirective(Outcome) {
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
            controller: ['Outcome', function(Outcome) {
                var vm = this;
                vm.outcomes = [];
                Outcome.query().then(function(response) {
                    vm.outcomes = response.data;
                }, function(err) {
                    alert("Error Retrieving Outcomes");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/outcome/outcome.selection.html',
        };
    }

})();
