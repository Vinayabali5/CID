/**
 * This is the StudentSpecialCategory Directive definition.
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
        .module('StudentSpecialCategoryDetailsDirective', ['EntityServices'])
        .directive('studentSpecialCategoryDetails', studentSpecialCategoryDetails);

    function studentSpecialCategoryDetails() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                specialCategories: '=',
            },
            controller: 'StudentSpecialCategoryDetailsDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/studentSpecialCategoryDetails/studentSpecialCategoryDetails.html',
        };
    }
})();
