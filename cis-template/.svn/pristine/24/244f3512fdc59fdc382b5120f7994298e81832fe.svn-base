(function() {

    angular
        .module('SelectionBoxes')
        .directive('yearGroupSelection', YearGroupSelectionDirective);

    YearGroupSelectionDirective.$inject = ['YearGroup'];

    function YearGroupSelectionDirective(YearGroup) {
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
            controller: ['YearGroup', function(YearGroup) {
                var vm = this;
                vm.yearGroups = [];
                YearGroup.query().then(function(response) {
                    vm.yearGroups = response.data;
                }, function(err) {
                    alert("Error Retrieving YearGroups");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/yearGroup/year-group.selection.html',
        };
    }

})();
