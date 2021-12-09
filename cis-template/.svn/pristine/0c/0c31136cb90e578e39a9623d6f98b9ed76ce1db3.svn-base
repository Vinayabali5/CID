/**
 * This is the AcademicYears Editor Directive definition.
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
        .module('StudentFilesDirective', ['ui.bootstrap.modal'])
        .directive('studentFiles', studentFiles);

    function studentFiles() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                studentFiles: '=?',
            },
            templateUrl: 'js/directives/student-files/student-files.html',
            controller: 'StudentFilesController',
            controllerAs: 'ctrl'
        };

        return directive;

    }


})();
