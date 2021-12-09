/**
 * This is the Student Bursary Editor Directive definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]
 *  
 */

(function() {
    'use strict';

    angular
        .module('StudentBursaryEditorDirective', ['ui.bootstrap.modal', 'EntityServices', 'StudentBursaryDetailsDirective'])
        .directive('studentBursaryEditor', studentBursaryEditor);

    function studentBursaryEditor() {

        var directive = {

            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
            },
            bindToController: {
                studentBursary: '=',
            },
            controller: 'StudentBursaryEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/studentBursaryEditor/views/studentBursaryEditor.html',
        };
        return directive;
    }

})();
