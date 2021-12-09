/**
 * This is the PersonDetails Directive
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Directive
 */
(function() {
    'use strict';

    angular
        .module('PersonDetailsDirective', ['EntityServices'])
        .directive('personDetails', personDetails);

    function personDetails() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showDob: '=?',
                showGender: '=?',
                showLegalSex: '=?',
                showTelephoneNos: '=?',
                showEmail: '=?',
                person: '=',
            },
            controller: 'PersonDetailsDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/personDetails/personDetailsFormatted.html',
        };
    }
})();
