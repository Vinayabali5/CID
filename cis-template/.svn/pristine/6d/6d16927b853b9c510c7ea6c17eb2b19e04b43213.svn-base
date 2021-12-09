/**
 * This is the PersonContactDetailsLookupDirective Directive
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Directive
 */
(function() {
    'use strict';

    angular.module('PersonContactDetailsLookupDirective', ['EntityServices'])
        .directive('personContactDetailsLookup', personContactDetailsLookup);

    function personContactDetailsLookup() {
        return {
            restrict: 'E',
            scope: {},
            bindToController: {
                personId: '=?',
            },
            link: function(scope, element, attrs, controller) {
                scope.$watch(controller.personId, function() {
                    controller.init();
                });
            },
            controller: 'PersonContactDetailsLookupDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/personContactDetailsLookup/personContactDetailsLookup.html',
            transclude: true,
        };
    }

})();
