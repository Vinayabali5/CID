(function() {

    angular
        .module('SelectionBoxes')
        .directive('studentTypeSelection', StudentTypeSelectionDirective);

    StudentTypeSelectionDirective.$inject = ['StudentType'];

    function StudentTypeSelectionDirective(StudentType) {
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
            controller: ['StudentType', function(StudentType) {
                var vm = this;
                vm.studentTypes = [];
                StudentType.query().then(function(response) {
                    vm.studentTypes = response.data;
                }, function(err) {
                    alert("Error Retrieving StudentTypes");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/studentType/student-type.selection.html',
        };
    }

})();
