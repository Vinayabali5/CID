(function() {
    angular
        .module('SeatingPlanStudentDirective')
        .controller('SeatingPlanStudentDirectiveController', ["$rootScope", "$scope",
            function($rootScope, $scope) {
                var vm = this;
                console.log('SeatingPlanStudentDirectiveController loaded');

            }
        ]);
}());
