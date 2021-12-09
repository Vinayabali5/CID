angular.module('cid.tests').controller('TestStudentWarningController', function($log, $scope, StudentWarning) {
    var vm = this;

    this.studentWarning = {};

    this.studentId = 131168;

    this.init = function() {
        $log.log('StudentWarningRecordsController::loadStudentWarning called');
        this.getStudentWarning();
    };

    this.getStudentWarning = function(id) {
        var lookupStudentWarningId;
        if (id) {
            lookupStudentWarningId = id;
        } else {
            lookupStudentWarningId = this.studentId;
        }
        $log.log('Getting StudentWarning: ' + lookupStudentWarningId);
        StudentWarning.get(vm.studentId).then(function(response) {
            vm.studentWarning = response.data;
        }, function(response) {
            $log.log("EE - Failed to retrieve data for studentWarning");
        });
    };

    this.init();
});
