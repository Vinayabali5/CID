(function() {

    angular
        .module('SelectionBoxes')
        .directive('facultySelection', FacultySelectionDirective);

    FacultySelectionDirective.$inject = ['Faculty'];

    function FacultySelectionDirective(Faculty) {
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
            controller: ['Faculty', function(Faculty) {
                var vm = this;
                vm.faculties = [];
                Faculty.query().then(function(response) {
                    vm.faculties = response.data;
                }, function(err) {
                    alert("Error Retrieving Facultys");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/faculty/faculty.selection.html',
        };
    }

})();
