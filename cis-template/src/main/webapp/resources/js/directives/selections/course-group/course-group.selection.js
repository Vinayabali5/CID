(function() {

    angular
        .module('SelectionBoxes')
        .directive('courseGroupSelection', CourseGroupSelectionDirective);

    CourseGroupSelectionDirective.$inject = [];

    function CourseGroupSelectionDirective() {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                name: '@',
                courseGroups: '=',
                readonly: '=?',
                ngRequired: '=',
                ngmodelvar: '=ngModel',
            },
            link: function(scope, element, attrs, controller) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['$scope', function($scope) {
                var vm = this;
                vm.courseGroups = $scope.courseGroups != null ? $scope.courseGroups : [];
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/course-group/course-group.selection.html',
        };
    }

})();
