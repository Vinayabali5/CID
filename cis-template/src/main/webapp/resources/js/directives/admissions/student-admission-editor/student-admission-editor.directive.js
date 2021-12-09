(function() {
    'use strict';

    angular
        .module('StudentAdmissionEditorDirective', ['ui.bootstrap.modal', 'EntityServices'])
        .directive('studentAdmissionEditor', studentAdmissionEditor);


    function studentAdmissionEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                studentAdmission: '=?'
            },
            templateUrl: 'js/directives/admissions/student-admission-editor/views/student-admission-editor.html',
            controller: 'StudentAdmissionEditorController',
            controllerAs: 'ctrl'
        };

        return directive;

    }


})();
