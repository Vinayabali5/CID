(function() {

    angular
        .module('SelectionBoxes')
        .directive('courseSelection', CourseSelectionDirective);

    CourseSelectionDirective.$inject = ['Course'];

    function CourseSelectionDirective(Course) {
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
            controller: ['Course', function(Course) {
                var vm = this;
                vm.courses = [];
                Course.query().then(function(response) {
                    vm.courses = response.data;
                }, function(err) {
                    alert("Error Retrieving Courses");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/course/course.selection.html',
        };
    }

})();
