angular.module('cid.tests').controller('TestStudentEntryQualificationsController', function($log, $scope, StudentEntryQualification) {
    var vm = this;

    this.entryQualifications = [];
    this.studentId = 150985;

    this.init = function() {
        $log.log('StudentEntryQualificationRecordsController::loadStudentEntryQualification called');
        this.getStudentEntryQualifications();
    };

    this.getStudentEntryQualifications = function(id) {
        $log.log(vm.entryQualification);
        var lookupId;
        if (id) {
            lookupId = id;
        } else {
            lookupId = this.studentId;
        }
        StudentEntryQualification.get(vm.studentId).then(function(response) {
            $log.log(response.data);
            vm.entryQualifications = response.data;
        }, function(response) {
            $log.error("EE Failed to load entryQualifications' entryQualifications: ");
        });
    };

    this.init();
});
