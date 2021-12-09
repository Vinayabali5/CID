/**
 * This is the PersonDetailsLookupDirective Editor Directive definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 *  @type Directive
 *
 *
 *   */
(function() {
    'use strict';

    angular
        .module('PersonDetailsLookupDirective', ['EntityServices'])
        .directive('personDetailsLookup', personDetailsLookup);

    function personDetailsLookup($log) {

        return {
            restrict: 'E',
            scope: {
                showDob: '=?',
                showGender: '=?',
                showLegalSex: '=?',
                showAll: '=?',
            },
            bindToController: {
                personId: '=?',
            },
            link: function(scope, element, attrs, controllers) {
                scope.$watch(attrs.person, function(newValue, oldValue) {
                    $log.log("II Person object changed on PersonDetailsLookupDirective");
                });
            },
            controller: 'PersonDetailsLookupDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/personDetailsLookup/personDetailsLookup.html',
            transclude: true,
        };
    }
})();
