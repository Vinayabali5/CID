angular.module('cid.tests').controller('TestStudentYearController', function($log, $scope, Student) {
    var vm = this;

    this.studentYear = {};

    this.studentId = 131168;

    this.yearId = 16;

    this.init = function() {
        $log.log('StudentYearRecordsController::loadStudentYear called');
        this.getStudentYear();
    };

    this.getStudentYear = function(id) {
        var lookupStudentYearId;
        if (id) {
            lookupStudentYearId = id;
        } else {
            lookupStudentYearId = this.studentId;
        }
        $log.log('Getting StudentYear: ' + lookupStudentYearId);
        Student.studentYears(this.studentId, this.yearId).then(function(response) {
            vm.studentYear = response.data;

            $log.info(vm.student);
        });
    };

    this.init();
});
