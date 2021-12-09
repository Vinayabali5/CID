(function() {
    angular.module('cid.exams.seating-plan', ['ui.router',
        'ui.bootstrap',
        'ngResource',
        'dndLists',
        'SeatingPlanStudentDirective',
        'SeatingPlanSeatDirective',
        'CourseEnrolmentTableDirective',
        'ExpandDirective',
        'IndeterminateCheckboxDirective'
    ]);
})();
