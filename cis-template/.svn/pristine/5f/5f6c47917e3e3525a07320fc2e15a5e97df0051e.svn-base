angular.module('cid.tests').controller('TestStudentCollegeFundPaymentController', function($log, $scope, CollegeFundPayment) {
    var vm = this;

    this.collegeFundPayment = [];

    this.studentId = 131168;

    this.init = function() {
        $log.log('StudentCollegeFundPaymentRecordsController::loadStudentCollegeFundPayment called');
        this.getStudentCollegeFundPayment();
    };

    this.getStudentCollegeFundPayment = function(id) {
        var lookupStudentCollegeFundPaymentId;
        if (id) {
            lookupStudentCollegeFundPaymentId = id;
        } else {
            lookupStudentCollegeFundPaymentId = this.studentId;
        }
        $log.log('Getting StudentCollegeFundPayment: ' + lookupStudentCollegeFundPaymentId);
        CollegeFundPayment.getByStudent(vm.studentId).then(function(response) {
            vm.collegeFundPayment = response.data;
        }, function(response) {
            $log.log("EE - Failed to retrieve data for studentCollegeFundPayment");
        });
    };

    this.init();
});
