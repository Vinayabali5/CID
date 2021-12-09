/**
 * This is the Student Files Uploader Directive definition.
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
        .module('StudentFilesUploaderDirective', ['ui.bootstrap.modal', 'EntityServices'])
        .directive('studentFilesUploader', studentFilesUploader);

    function studentFilesUploader() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudentId: '=?',
                id: '@id',
            },
            bindToController: {
                studentId: '=',
            },
            controller: 'StudentFilesUploaderController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-files-uploader/views/student-files-uploader.html',
        };

        return directive;
    }

})();
