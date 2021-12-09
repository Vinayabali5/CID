angular.module('cid.tests').controller('TestExternalResultsArchiveController', function($log, $scope, ExternalResultsArchive) {
    var vm = this;

    this.externalResultsArchive = [];

    this.studentId = 131168;

    this.init = function() {
        $log.log('ExternalResultsArchiveRecordsController::loadExternalResultsArchive called');
        this.getExternalResultsArchive();
    };

    this.getExternalResultsArchive = function(id) {
        var lookupExternalResultsArchiveId;
        if (id) {
            lookupExternalResultsArchiveId = id;
        } else {
            lookupExternalResultsArchiveId = this.studentId;
        }
        $log.log('Getting ExternalResultsArchive: ' + lookupExternalResultsArchiveId);
        ExternalResultsArchive.get(vm.studentId).then(function(response) {
            vm.externalResultsArchive = response.data;
        }, function(response) {
            $log.log("EE - Failed to retrieve data for externalResultsArchive");
        });
    };

    this.init();
});
