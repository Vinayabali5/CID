/**
 * This is the Report Link Directive definition.
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
        .module('ReportLinkDirective', [])
        .directive('reportLink', reportLink);

    function reportLink() {
        return {
            restrict: 'E',
            scope: {},
            bindToController: {
                class: '@?',
                reportPath: '=',
                reportParams: '=?',
                reportToolbar: '=?',
                reportFormat: '=?',
                includeYear: '=?',
                previousYear: '=?',
                showParams: '=?',
            },
            link: function(scope, element, attrs) {
                element[0].removeAttribute('class');
            },
            controller: 'ReportLinkDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/report-link/report-link.html',
            transclude: true,
        };
    }
})();
