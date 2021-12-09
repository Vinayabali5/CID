/**
 * This is the StudentTimetable Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StudentTimetableDirective')
        .controller('StudentTimetableController', StudentTimetableController);

    StudentTimetableController.$inject = ['$log', '$scope', '$rootScope', '$uibModal', 'GLOBAL'];

    function StudentTimetableController($log, $scope, $rootScope, $uibModal, GLOBAL) {
        /* jshint validthis:true */
        var vm = this;

        this.loadStudentTimetable = function() {
            if (vm.studentId !== undefined) {
                // var modalInstance = $uibModal.open({
                //     templateUrl: 'js/directives/student-timetable/views/student-timetable-dialog.html',
                //     controller: 'StudentTimetableDialogController',
                //             controllerAs: 'ctrl',
                //             size: 'lg',
                //             resolve: {
                //                 StudentId: function () {
                //                     return $scope.studentId;
                //                 }
                //             }
                //         });
            }
        };

        this.studentTimetableUrl = function() {
            if (vm.studentId !== undefined) {
                var url = GLOBAL.REPORT_URL + '?/CID/Timetabling/Timetable+Student+-+Square&rc:Toolbar=false&rs:Command=Render&StudentList=' + vm.studentId;
                return url;
            } else {
                return '';
            }
        };
    }
})();
