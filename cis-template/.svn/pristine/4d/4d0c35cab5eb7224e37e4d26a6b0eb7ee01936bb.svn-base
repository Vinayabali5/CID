/**
 * This is the CourseSearchDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 * 
 */

(function() {
    'use strict';

    angular
        .module('CourseSearchDirective', ['EntityServices', 'cid.search.course'])
        .directive('courseSearch', courseSearch);

    function courseSearch() {

        var directive = {
            restrict: 'E',
            scope: {},
            bindToController: {
                'callback': '&onSelect',
            },
            transclude: true,
            controller: 'CourseSearchController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/course-search/courseSearch.html'
        };

        return directive;

    }
})();
