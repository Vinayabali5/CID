angular
    .module('CourseEnrolmentTableDirective', [
        'ngResource',
        'ui.bootstrap',
    ])
    .directive('courseEnrolmentTable', function() {
        return {
            scope: {
                group: "=",
            },
            transclude: true,
            controller: 'CourseEnrolmentTableDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/exams/course-enrolment-table/courseEnrolmentTable.html'
        };
    });
