/**
 * This directive is used to display a the Medical Notes 
 *
 * Applied Styles:
 *
 * @type Directive
 * 
 */

(function() {
    'use strict';

    angular
        .module('MedicalNotesEditorDirective', ['ui.bootstrap.modal', 'EntityServices'])
        .directive('medicalNotesEditor', medicalNotesEditor);

    function medicalNotesEditor() {
        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                showStudentId: '=?',
                id: '@id',
            },
            bindToController: {
                student: '=',
                studentId: '=?'
            },
            controller: 'MedicalNotesEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/medical-notes-editor/views/medical-notes-editor.html'
        };

        return directive;
    }

})();
