angular.module('cid.tests').controller('TestTutorGroupRemarkPermissionsController', function($log, $scope, StudentYear) {
    var vm = this;


    this.remarkPermission = [];

    this.tutorGroupId = 4;


    this.init = function() {
        $log.log('TutorGroupRemarkPermissionRecordsController::loadTutorGroupRemarkPermission called');
        this.getTutorGroupRemarkPermissions();
    };

    this.getTutorGroupRemarkPermissions = function(id) {
        var lookupId;
        if (id) {
            lookupId = id;
        } else {
            lookupId = this.tutorGroupId;
        }

        StudentYear.get(vm.tutorGroupId).then(function(response) {
            $log.log(response.data);
            vm.remarkPermission = response.data;
        }, function(response) {
            $log.log("EE - Failed to retrieve data for tutorGroupRemarkPermission");
        });
    };

    this.init();
});
