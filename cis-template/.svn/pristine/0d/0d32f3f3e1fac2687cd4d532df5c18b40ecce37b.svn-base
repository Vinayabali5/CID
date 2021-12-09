(function() {

    angular
        .module('SelectionBoxes')
        .directive('studentRemarkPermissionSelection', StudentRemarkPermissionSelectionDirective);

    StudentRemarkPermissionSelectionDirective.$inject = ['StudentRemarkPermission'];

    function StudentRemarkPermissionSelectionDirective(StudentRemarkPermission) {
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
            controller: ['StudentRemarkPermission', function(StudentRemarkPermission) {
                var vm = this;

                vm.studentRemarkPermissions = [];

                StudentRemarkPermission.query().then(function(response) {
                    vm.studentRemarkPermissions = response.data;
                }, function(err) {
                    alert("Error Retrieving StudentRemarkPermissions");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/studentRemarkPermission/student-remark-permission.selection.html',
        };
    }

})();
