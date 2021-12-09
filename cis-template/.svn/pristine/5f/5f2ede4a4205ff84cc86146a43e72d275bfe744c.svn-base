/**
 * This is the StudentTimetable Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StudentTimetableDirective')
        .controller('StudentTimetableDialogController', StudentTimetableDialogController);

    StudentTimetableDialogController.$inject = ['$log', 'StudentId', 'GLOBAL'];

    function StudentTimetableDialogController($log, StudentId, GLOBAL) {
        /* jshint validthis:true */
        var vm = this;

        this.reportUrl = function() {
            if (StudentId !== undefined) {
                return GLOBAL.REPORT_URL + '?/CID/Timetabling/Timetable+Student+-+Square&rc:Toolbar=false&rs:Command=Render&StudentList=' + StudentId;
            } else {
                return '';
            }
        };
    }
})();
