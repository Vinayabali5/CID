/**
 * This is the EntryQualification Editor Directive definition.
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
        .module('EntryQualificationsEditorDirective', ['EntityServices'])
        .directive('entryQualificationsEditor', entryQualificationsEditorDirective);

    function entryQualificationsEditorDirective() {

        var directive = {
            restrict: 'E',
            scope: {
                entryQualifications: '=?',
                showActions: '=?'
            },
            controller: 'EntryQualificationsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/entry-qualifications-editor/views/entry-qualifications-editor.html',
        };

        return directive;

    }
})();
