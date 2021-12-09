(function() {
    'use strict';

    angular
        .module('StudentCollegeFundPaidDirective', ['ui.bootstrap.modal'])
        .directive('studentCollegeFundPaid', studentCollegeFundPaid);

    function studentCollegeFundPaid() {

        var directive = {
            restrict: 'E',
            scope: {
                studentCollegeFundPaid: '=',
                showActions: '=?'
            },
            templateUrl: 'js/directives/admissions/student-college-fund-paid/views/student-college-fund-paid.html',
            controller: 'StudentCollegeFundPaidController',
            controllerAs: 'ctrl'
        };

        return directive;


    }
})();
