(function() {

    angular
        .module('SelectionBoxes')
        .directive('periodSelection', PeriodSelectionDirective);

    PeriodSelectionDirective.$inject = ['Period'];

    function PeriodSelectionDirective(Period) {
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
            controller: ['Period', function(Period) {
                var vm = this;
                vm.periods = [];
                Period.query().then(function(response) {
                    vm.periods = response.data;
                }, function(err) {
                    alert("Error Retrieving Periods");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/period/period.selection.html',
        };
    }

})();
