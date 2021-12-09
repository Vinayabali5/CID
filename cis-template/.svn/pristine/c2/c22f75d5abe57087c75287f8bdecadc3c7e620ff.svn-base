angular.module('cid.tests').controller('TestStudentMedicalNotesController', function($log, $scope, Student) {
    var vm = this;

    this.student = {};

    this.studentId = 200004;


    this.init = function() {
        $log.log('StudentMedicalNotesController::loadStudent called');
        this.getStudent();
    };

    this.getStudent = function(id) {
        var lookupStudentId;
        if (id) {
            lookupStudentId = id;
        } else {
            lookupStudentId = this.studentId;
        }
        $log.log('Getting Student: ' + lookupStudentId);
        Student.get(this.studentId).then(function(response) {
            vm.student = response.data;

            $log.info(vm.student);
        });
    };

    this.init();
});
