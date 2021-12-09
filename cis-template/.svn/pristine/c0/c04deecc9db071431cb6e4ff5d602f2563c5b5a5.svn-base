(function() {

    angular
        .module('SelectionBoxes')
        .directive('staffTypeSelection', StaffTypeSelectionDirective);

    StaffTypeSelectionDirective.$inject = ['StaffType'];

    function StaffTypeSelectionDirective(StaffType) {
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
            controller: ['StaffType', function(StaffType) {
                var vm = this;

                vm.staffTypes = [];

                StaffType.query().then(function(response) {
                    vm.staffTypes = response.data;
                }, function(err) {
                    alert("Error Retrieving StaffTypes");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/staffType/staff-type.selection.html',
        };
    }

})();
