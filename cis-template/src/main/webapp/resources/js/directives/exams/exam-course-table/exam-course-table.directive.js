/**
 * 
 */
(function() {
    angular
        .module('ExamCourseTableDirective', ['ngResource', 'ui.bootstrap'])
        .directive('examCourseTable', examCourseTableDirective);

    examCourseTableDirective.$inject = [];

    function examCourseTableDirective() {
        var directive = {
            scope: {},
            controller: 'ExamCourseTableDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/exams/exam-course-table/views/exam-course-table.html'
        };

        return directive;
    }
})();
