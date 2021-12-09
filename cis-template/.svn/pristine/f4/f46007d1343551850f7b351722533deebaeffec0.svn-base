angular.module('cid.tests').controller('TestTablesController', function($log, $scope, $rootScope, Student, TextLookup) {
    var vm = this;

    this.studentId = 160902;

    this.student = {};
    this.enrolments = [];
    this.results = [];
    vm.optionEntries = [];
    vm.textLookups = [];

    this.init = function() {
        this.getEnrolments();
        this.getTextLookups();
    };

    $rootScope.$on('exam-results-saved', function(data) {
        vm.getEnrolments(vm.student.id);
    });

    this.getEnrolments = function() {
        Student.get(vm.studentId).then(function(response) {
            vm.student = response.data;
            vm.enrolments = response.data.enrolments;

            $log.log("II Data Loaded");
        }, function(response) {
            $log.log("EE - Failed to retrieve data for person");
        });


        Student.results(vm.studentId).then(function(response) {
            vm.results = response.data;

            $log.log("II Data Loaded");
        }, function(response) {
            $log.log("EE - Failed to retrieve data for person");
        });

        Student.optionEntries(vm.studentId).then(function(response) {
            vm.optionEntries = response.data;
        }, function(response) {
            $log.log("Error");
        });


    };


    this.getTextLookups = function() {
        TextLookup.query().then(function(response) {
            vm.textLookups = response.data;
        }, function(response) {
            $log.log("EE - Failed to retrieve data for person");
        });

    };

    this.init();

});
