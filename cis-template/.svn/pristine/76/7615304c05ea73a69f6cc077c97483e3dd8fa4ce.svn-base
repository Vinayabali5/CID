angular.module('cid.tests').controller('TestDetailsController', function($log, $scope, Person, Student) {
    var vm = this;
    this.personId = 10002;
    this.studentId = 160001;

    this.person = {};
    this.student = {};

    this.init = function() {
        Person.get(vm.personId).then(function(response) {
            vm.person = response.data;
            $log.log("II Data Loaded");
        }, function(response) {
            $log.log("EE - Failed to retrieve data for person");
        });
        Student.get(vm.studentId).then(function(response) {
            vm.student = response.data;
            $log.log("II Data Loaded");
        }, function(response) {
            $log.log("EE - Failed to retrieve data for student");
        });
    };

    this.init();

});
