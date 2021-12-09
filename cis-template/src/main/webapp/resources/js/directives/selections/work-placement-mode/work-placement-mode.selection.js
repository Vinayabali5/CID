(function() {

    angular
        .module('SelectionBoxes')
        .directive('workPlacementModeSelection', WorkPlacementModeSelectionDirective);

    WorkPlacementModeSelectionDirective.$inject = ['WorkPlacementMode'];

    function WorkPlacementModeSelectionDirective(WorkPlacementMode) {
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
            controller: ['WorkPlacementMode', function(WorkPlacementMode) {
                var vm = this;
                vm.workPlacementModes = [];
                WorkPlacementMode.query().then(function(response) {
                    vm.workPlacementModes = response.data;
                }, function(err) {
                    alert("Error Retrieving WorkPlacementModes");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/work-placement-mode/work-placement-mode.selection.html',
        };
    }

})();
