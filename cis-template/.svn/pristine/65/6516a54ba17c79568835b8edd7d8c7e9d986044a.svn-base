(function() {
    angular
        .module('SeatingPlanStudentDirective', ['ngResource', 'ui.bootstrap', 'EntityServices'])
        .directive('seatingPlanStudent', function() {
            return {
                scope: {
                    student: '=',
                    displayOptions: '=',
                },
                //replace: true,
                controller: 'SeatingPlanStudentDirectiveController',
                controllerAs: 'ctrl',
                templateUrl: 'js/directives/exams/seatingPlanStudent/seatingPlanStudent.html',
            };
        });
}());
