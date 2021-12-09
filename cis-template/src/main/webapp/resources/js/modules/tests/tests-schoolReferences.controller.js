angular.module('cid.tests').controller('TestSchoolReferencesController', function($log, $scope, SchoolReference) {
    var vm = this;

    this.student = {};

    this.studentId = 210065;


    this.init = function() {
        $log.log('SchoolReferencesController::loadStudent called');
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
        SchoolReference.get(this.studentId).then(function(response) {
            vm.student = response.data;

            $log.info(vm.student);
        });
    };

    this.init();
});
