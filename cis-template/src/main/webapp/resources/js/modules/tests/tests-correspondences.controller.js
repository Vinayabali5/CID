angular.module('cid.tests').controller('TestCorrespondencesController', function($log, $scope, Correspondence) {
    var vm = this;


    this.correspondences = [];
    this.studentId = 161163;


    this.init = function() {
        $log.log('CorrespondenceRecordsController::loadCorrespondence called');
        this.getCorrespondences();
    };

    this.getCorrespondences = function(id) {
        var lookupCorrespondenceId;
        if (id) {
            lookupCorrespondenceId = id;
        } else {
            lookupCorrespondenceId = this.studentId;
        }

        Correspondence.get(vm.studentId).then(function(response) {
            $log.log(response.data);
            vm.correspondences = response.data;
        }, function(response) {
            $log.log("EE - Failed to retrieve data for correspondence");
        });
    };

    this.init();
});
