angular.module('cid.tests').controller('TestStudentLearningSupportController', function($log, $scope, StudentLearningSupport) {
    var vm = this;

    this.studentLearningSupport = {};
    this.studentId = 140147;

    this.init = function() {
        $log.log('StudentLearningSupportRecordsController::loadStudentLearningSupport called');
        this.getStudentLearningSupports();
    };

    this.getStudentLearningSupports = function(id) {
        $log.log(vm.studentLearningSupport);
        var lookupId;
        if (id) {
            lookupId = id;
        } else {
            lookupId = this.studentId;
        }
        StudentLearningSupport.get(vm.studentId).then(function(response) {
            $log.log(response.data);
            vm.studentLearningSupport = response.data;
        }, function(response) {
            $log.error("EE Failed to load interimReports' interimReports: ");
        });
    };

    this.init();
});
