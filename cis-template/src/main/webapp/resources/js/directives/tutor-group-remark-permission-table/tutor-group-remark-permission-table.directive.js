/**
 * This is the TutorGroupRemarkPermissionTable Directive definition.
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
        .module('TutorGroupRemarkPermissionTableDirective', ['EntityServices'])
        .directive('tutorGroupRemarkPermissionTable', tutorGroupRemarkPermissionTable);

    function tutorGroupRemarkPermissionTable() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudentYear: '=?',
                remarkPermission: '=',
            },
            //	controller: 'TutorGroupRemarkPermissionTableDirectiveController',
            //	controllerAs: 'ctrl',
            templateUrl: 'js/directives/tutor-group-remark-permission-table/tutor-group-remark-permission-table.html',
        };
    }
})();
