angular.module('cid.tests').controller('TestILPInterviewsController', function($log, $scope, ILPInterview) {
    var vm = this;


    this.ilpInterviews = [];
    this.studentId = 131168;


    this.init = function() {
        $log.log('ILPInterviewRecordsController::loadILPInterview called');
        this.getILPInterviews();
    };

    this.getILPInterviews = function(id) {
        var lookupILPInterviewId;
        if (id) {
            lookupILPInterviewId = id;
        } else {
            lookupILPInterviewId = this.studentId;
        }

        ILPInterview.getByStudentId(vm.studentId).then(function(response) {
            $log.log(response.data);
            vm.ilpInterviews = response.data;
        }, function(response) {
            $log.log("EE - Failed to retrieve data for iLPInterview");
        });
    };

    this.init();
});
