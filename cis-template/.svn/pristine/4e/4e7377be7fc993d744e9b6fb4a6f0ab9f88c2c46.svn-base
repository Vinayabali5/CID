/**
 * This is the Duplication Detections Directive definition.
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
        .module('DuplicateDetectionDirective', ['EntityServices'])
        .directive('duplicateDetection', duplicateDetection);

    function duplicateDetection() {

        var directive = {
            restrict: 'E',
            scope: {
                duplicates: '=?',
            },
            controller: 'DuplicateDetectionController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/admissions/duplicate-detection/views/duplicate-detection.html',
        };

        return directive;

    }
})();
