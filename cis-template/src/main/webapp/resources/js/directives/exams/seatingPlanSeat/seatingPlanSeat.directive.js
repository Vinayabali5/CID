angular.module('SeatingPlanSeatDirective', ['ngResource', 'ui.bootstrap', 'EntityServices']).directive('seatingPlanSeat', function() {
    return {
        scope: {
            student: '=',
            callback: '&'
        },
        //replace: true,
        controller: 'SeatingPlanSeatDirectiveController',
        controllerAs: 'ctrl',
        templateUrl: 'js/directives/exams/seatingPlanSeat/seatingPlanSeat.html',
    };
});
