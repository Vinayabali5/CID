(function() {

    angular
        .module('SelectionBoxes')
        .directive('roleSelection', RoleSelectionDirective);

    RoleSelectionDirective.$inject = ['Role'];

    function RoleSelectionDirective(Role) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                name: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel',
                altNullText: '=altNullText'
            },
            link: function(scope, element, attrs, controller) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['Role', function(Role) {
                var vm = this;
                vm.roles = [];
                Role.query().then(function(response) {
                    vm.roles = response.data;
                }, function(err) {
                    alert("Error Retrieving Roles");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/role/role.selection.html',
        };
    }

})();
