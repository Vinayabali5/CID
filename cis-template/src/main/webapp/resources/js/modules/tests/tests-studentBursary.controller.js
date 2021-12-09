angular.module('cid.tests').controller('TestStudentBursaryController', function($log, $scope, StudentBursary) {
    var vm = this;

    this.studentBursary = {};

    this.studentId = 131168;

    this.init = function() {
        $log.log('StudentBursaryRecordsController::loadStudentBursary called');
        this.getStudentBursary();
    };

    this.getStudentBursary = function(id) {
        var lookupStudentBursaryId;
        if (id) {
            lookupStudentBursaryId = id;
        } else {
            lookupStudentBursaryId = this.studentId;
        }
        $log.log('Getting StudentBursary: ' + lookupStudentBursaryId);
        StudentBursary.get(vm.studentId).then(function(response) {
            vm.studentBursary = response.data;
        }, function(response) {
            $log.log("EE - Failed to retrieve data for studentBursary");
        });
    };

    this.init();
});
