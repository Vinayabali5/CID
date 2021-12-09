angular.module('StudentExamTableDirective', [
    'ngResource',
    'ui.bootstrap',
    'StudentService',
]).directive('studentExamTable', function() {
    return {
        scope: {
            studentList: '=',
        },
        transclude: true,
        controller: 'StudentExamTableDirectiveController',
        controllerAs: 'ctrl',
        templateUrl: 'js/directives/exams/studentExamTable/studentExamTable.html'
    };
});
