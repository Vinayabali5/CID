/**
 * This is the Student Details Lookup Directive definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]
 *  
 */
(function() {
    'use strict';

    angular
        .module('StudentDetailsLookupDirective', ['EntityServices'])
        .directive('studentDetailsLookup', studentDetailsLookup);

    function studentDetailsLookup($log, $rootScope) {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showDob: '=?',
                showGender: '=?',
            },
            bindToController: {
                studentId: '=?',
            },
            link: function(scope, element, attrs, ctrl) {
                scope.$watch('student', function(newValue, oldValue) {
                    $log.log('Student changed');
                    $log.log(oldValue);
                    $log.log(newValue);
                }, true);
            },
            controller: 'StudentDetailsLookupDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/studentDetailsLookup/studentDetailsLookup.html',
            transclude: true,

        };

        return directive;
    }
})();
