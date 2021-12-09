/**
 * This directive is used to display a the School References 
 *
 * Applied Styles:
 *
 * @type Directive
 * 
 */

(function() {
    'use strict';

    angular
        .module('SchoolReferencesDetailsDirective', [])
        .directive('schoolReferencesDetails', schoolReferencesDetails);

    function schoolReferencesDetails() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                student: '=',
            },
            templateUrl: 'js/directives/school-references-details/school-references-details.html',
            transclude: true,
        };

        return directive;
    }
})();
