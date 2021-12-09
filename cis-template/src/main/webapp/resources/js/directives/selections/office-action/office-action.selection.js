(function() {

    angular
        .module('SelectionBoxes')
        .directive('officeActionSelection', OfficeActionSelectionDirective);

    OfficeActionSelectionDirective.$inject = ['OfficeAction'];

    function OfficeActionSelectionDirective(OfficeAction) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                name: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel',
                ngchange: '=ngChange'
            },
            link: function(scope, element, attrs, controller) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['$scope', 'OfficeAction', function($scope, OfficeAction) {
                var vm = this;
                vm.officeActions = [];
                OfficeAction.query().then(function(response) {
                    vm.officeActions = response.data;
                }, function(err) {
                    alert("Error Retrieving OfficeActions");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/office-action/office-action.selection.html',
        };
    }

})();
