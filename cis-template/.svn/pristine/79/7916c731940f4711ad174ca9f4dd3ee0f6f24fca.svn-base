(function() {

    angular
        .module('SelectionBoxes')
        .directive('studentRoleSelection', StudentRoleSelectionDirective);

    StudentRoleSelectionDirective.$inject = ['StudentRole'];

    function StudentRoleSelectionDirective(StudentRole) {
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
            controller: ['StudentRole', function(StudentRole) {
                var vm = this;
                vm.studentRoles = [];
                StudentRole.query().then(function(response) {
                    vm.studentRoles = response.data;
                }, function(err) {
                    alert("Error Retrieving StudentRoles");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/student-role/student-role.selection.html',
        };
    }

})();
