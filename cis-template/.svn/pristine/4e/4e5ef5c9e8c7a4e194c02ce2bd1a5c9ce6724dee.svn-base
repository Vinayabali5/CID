/**
 * This is the StudentWithdrawalDirective definition, it is used to handle the student withdrawal directive
 *
 * @type Directive
 */
(function() {
    'use strict';

    angular
        .module('StudentWithdrawalDirective', ['ui.bootstrap.modal'])
        .directive('studentWithdrawal', studentWithdrawal);

    studentWithdrawal.$inject = [];

    function studentWithdrawal() {
        return {
            restrict: 'E',
            scope: {
                id: '@id',
            },
            bindToController: {
                studentId: '=',
                yearId: '='
            },
            controller: 'StudentWithdrawalController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-withdrawal/views/student-withdrawal.html',
        };
    }
})();
