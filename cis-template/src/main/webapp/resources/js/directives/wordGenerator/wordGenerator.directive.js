/**
 * This is the AcademicYears Editor Directive definition.
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
        .module('WordGeneratorDirective', [])
        .directive('wordGenerator', wordGenerator);

    wordGenerator.$inject = ['$log', '$rootScope', 'GLOBAL'];

    function wordGenerator($log, $rootScope, GLOBAL) {
        return {
            restrict: 'E',
            scope: {
                studentId: '=',
            },
            controller: 'WordGeneratorDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/wordGenerator/wordGenerator.html',
        };
    }
})();
