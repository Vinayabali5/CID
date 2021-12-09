(function() {
    'use strict';
    angular
        .module('InductionDetailsDirective', [])
        .directive('inductionDetails', inductionDetails);

    function inductionDetails() {
        var directive = {
            restrict: 'E',
            scope: {
                studentAdmissions: '='
            },
            templateUrl: 'js/directives/admissions/induction-details/induction-details.html'
        };

        return directive;
    }
})();
