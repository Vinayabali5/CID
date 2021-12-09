(function() {

    angular
        .module('SelectionBoxes')
        .directive('aimTypeSelection', AimTypeSelectionDirective);

    AimTypeSelectionDirective.$inject = ['AimType'];

    function AimTypeSelectionDirective(AimType) {
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
            controller: ['AimType', function(AimType) {
                var vm = this;
                vm.aimTypes = [];
                AimType.query().then(function(response) {
                    vm.aimTypes = response.data;
                }, function(err) {
                    alert("Error Retrieving AimTypes");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/aim-type/aim-type.selection.html',
        };
    }

})();
