(function() {

    angular
        .module('SelectionBoxes')
        .directive('departmentSelection', DepartmentSelectionDirective);

    DepartmentSelectionDirective.$inject = ['Department'];

    function DepartmentSelectionDirective(Department) {
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
            controller: ['Department', function(Department) {
                var vm = this;
                vm.departments = [];
                Department.query().then(function(response) {
                    vm.departments = response.data;
                }, function(err) {
                    alert("Error Retrieving Departments");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/department/department.selection.html',
        };
    }

})();
