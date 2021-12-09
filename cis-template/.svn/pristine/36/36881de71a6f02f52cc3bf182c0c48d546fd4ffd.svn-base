angular.module('cid.tests').controller('TestStudentInterimReportController', function($log, $scope, StudentInterimReport) {
    var vm = this;

    this.studentInterimReports = [];
    this.studentId = 131168;

    this.init = function() {
        $log.log('StudentInterimReportRecordsController::loadStudentInterimReport called');
        this.getStudentInterimReports();
    };

    this.getStudentInterimReports = function(id) {
        $log.log(vm.studentInterimReport);
        var lookupId;
        if (id) {
            lookupId = id;
        } else {
            lookupId = this.studentId;
        }
        StudentInterimReport.get(vm.studentId).then(function(response) {
            $log.log(response.data);
            vm.studentInterimReports = response.data;
        }, function(response) {
            $log.error("EE Failed to load interimReports' interimReports: ");
        });
    };

    this.init();
});
