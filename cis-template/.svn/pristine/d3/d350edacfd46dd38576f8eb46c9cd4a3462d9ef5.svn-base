angular.module('cid.tests').controller('TestSearchesController', function($log, $scope, Student) {
    var vm = this;

    this.loaded = false;
    this.student = {};

    this.init = function() {
        $log.log('StudentRecordsController::init called');
    };

    this.loadStudent = function(id) {
        $log.log('StudentRecordsController::loadStudent called');
        Student.get(id).then(function(response) {
            $log.log('II - Student with ID: ' + id + ' retireved.');
            vm.student = response.data;
        }, function(response) {
            $log.log('EE - An error occurred trying to retireve the student with ID: ' + id);
            alert("Failed to retrieve student with ID: " + id);
        });
        //alert(id);
    };

    this.init();

});
