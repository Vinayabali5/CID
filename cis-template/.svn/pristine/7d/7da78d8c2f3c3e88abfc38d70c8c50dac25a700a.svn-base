/**
 * This is the CurrentYearSelectorDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 *  @type Directive
 */

(function() {
    'use strict';

    angular
        .module('CurrentYearSelectorDirective', [
            'cid.service.logger',
            'AcademicYearService'
        ])
        .directive('currentYearSelector', currentYearSelector);

    function currentYearSelector() {
        var directive = {
            restrict: 'E',
            scope: {
                readonly: '=?'
            },
            controller: 'CurrentYearSelectorController',
            controllerAs: 'ctrl',
            //template: 'Current Year: <academic-year-selection class="form-control" ng-model="ctrl.currentYear.id"></academic-year-selection>',
            templateUrl: 'js/directives/current-year-selector/current-year-selector.html'
        };

        return directive;
    }

})();
