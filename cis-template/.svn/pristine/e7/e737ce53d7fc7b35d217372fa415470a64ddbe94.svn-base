angular.module('cid.tests').controller('TestEnrolmentCheckerController', function($log, $scope, $http) {
    var vm = this;

    this.ttCheck = {
        specs: [
            'L-MAH',
            'L-BIH',
            'L-CHH',
            'L-PSH'
        ],
        status: 'PENDING',
        options: []
    };

    this.page = 1;
    this.size = 10;
    this.totalItems = 0;

    this.getTotalItems = function() {
        if (this.ttCheck.options) {
            return this.ttCheck.options.size;
        } else {
            return 0;
        }
    };

    this.init = function() {
        $log.log('II TestEnrolmentCheckerController::loadAddress called');
    };

    this.check = function() {
        vm.ttCheck.options = [];
        vm.totalItems = 0;

        $http.post('api/enrolmentChecker', vm.ttCheck.specs).then(function(response) {
            vm.ttCheck.options = response.data;
            vm.totalItems = response.data.length;
            $log.log(vm.ttCheck);
        }, function(response) {
            vm.ttCheck.options = [];
            $log.log(vm.ttCheck);
        });
    };

    this.requestCount = function() {
        return vm.ttCheck.specs.length;
    };

    this.addRequest = function(request) {
        vm.ttCheck.specs.push(request);
    };

    this.removeRequest = function(request) {
        vm.ttCheck.specs.splice(vm.ttCheck.specs.indexOf(request), 1);
    };

    this.selectOption = function(option) {
        $log.info(option);
    };

    this.next = function() {
        this.page++;
    };

    this.previous = function() {
        this.page--;
    };

    this.init();
});
