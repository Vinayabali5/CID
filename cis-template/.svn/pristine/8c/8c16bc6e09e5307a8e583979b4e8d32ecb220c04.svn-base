angular.module('cid.tests').controller('TestStudentAdmissionsController', function($log, $scope, Student) {
    var vm = this;

    this.studentAdmissions = {};

    this.studentId = 131168;

    this.yearId = 16;

    this.init = function() {
        $log.log('StudentAdmissionsRecordsController::loadStudentAdmissions called');
        this.getStudentAdmissions();
    };

    this.getStudentAdmissions = function(id) {
        var lookupStudentAdmissionsId;
        if (id) {
            lookupStudentAdmissionsId = id;
        } else {
            lookupStudentAdmissionsId = this.studentId;
        }
        $log.log('Getting StudentAdmissions: ' + lookupStudentAdmissionsId);
        Student.admissions(this.studentId).then(function(response) {
            vm.studentAdmissions = response.data;

            $log.info(vm.student);
        });
    };

    this.init();
});
