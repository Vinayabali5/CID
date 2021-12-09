/**
 * This is the Student Search Directive definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]
 *
 */

(function() {
    'use strict';

    angular
        .module('StudentSearchDirective', ['cid.search.student'])
        .directive('studentSearch', studentSearch);

    function studentSearch() {

        var directive = {

            restrict: 'E',
            scope: {},
            bindToController: {
                showCandidateNo: '&?',
                'callback': '&onSelect',
            },
            transclude: true,
            controller: 'StudentSearchController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/studentSearch/studentSearch.html'

        };

        return directive;
    }
})();
