angular.module('cid.tests').controller('TestStudentOverallAttendanceController', function($log, $scope, StudentOverallAttendance) {
    var vm = this;

    this.studentOverallAttendance = {};

    this.studentId = 160005;

    this.init = function() {
        $log.log('StudentOverallAttendanceRecordsController::loadStudentOverallAttendance called');
        this.getStudentOverallAttendance();
    };

    this.getStudentOverallAttendance = function(id) {
        vm.studentOverallAttendance = {};

        var lookupStudentOverallAttendanceId;

        if (id) {
            lookupStudentOverallAttendanceId = id;
        } else {
            lookupStudentOverallAttendanceId = this.studentId;
        }

        $log.log('Getting StudentOverallAttendance: ' + lookupStudentOverallAttendanceId);

        StudentOverallAttendance.get(vm.studentId).then(function(response) {
            vm.studentOverallAttendance = response.data;
        }, function(response) {
            $log.log("EE - Failed to retrieve data for studentOverallAttendance");
        });
    };

    this.init();
});
