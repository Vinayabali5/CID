angular.module('cid.tests').controller('TestOtherController', function($log, $scope, $state, Person, Student) {
    var vm = this;
    this.personId = 10002;
    this.studentId = 160001;

    this.person = {};
    this.student = {};

    $scope.reportParamsObj = {
        studentId: this.studentId
    };

    this.init = function() {
        Person.get(vm.personId).then(function(response) {
            vm.person = response.data;
            $log.log("II Person Data Loaded");
        }, function(response) {
            $log.log("EE - Failed to retrieve data for person");
        });
        Student.get(vm.studentId).then(function(response) {
            vm.student = response.data;
            $log.log("II Student Data Loaded");
        }, function(response) {
            $log.log("EE - Failed to retrieve data for student");
        });
    };

    this.gotoStudent = function(id) {
        $state.go('student-viewer.view', {
            studentId: id
        });
    };

    this.init();

});
