/**
 * This is the PersonContactDetails Directive
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Directive
 */
(function() {
    'use strict';

    angular
        .module('PersonContactDetailsDirective', ['EntityServices'])
        .directive('personContactDetails', personContactDetails);

    function personContactDetails() {
        return {
            restrict: 'E',
            scope: {
                person: '=?',
            },
            controller: 'PersonContactDetailsDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/personContactDetails/personContactDetailsFormatted.html',
        };
    }

})();
