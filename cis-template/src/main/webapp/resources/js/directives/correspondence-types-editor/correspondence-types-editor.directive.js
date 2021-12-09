/**
 * This is the CorrespondenceType Editor Directive definition.
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
        .module('CorrespondenceTypesEditorDirective', ['EntityServices'])
        .directive('correspondenceTypesEditor', correspondenceTypesEditor);

    function correspondenceTypesEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                correspondenceTypes: '=?',
                showActions: '=?'
            },
            controller: 'CorrespondenceTypesEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/correspondence-types-editor/views/correspondence-types-editor.html',
        };

        return directive;

    }
})();
