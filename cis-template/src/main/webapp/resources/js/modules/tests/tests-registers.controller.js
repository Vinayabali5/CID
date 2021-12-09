angular.module('cid.tests').controller('TestRegistersController', function($log, $scope, MasterRegister) {
    var vm = this;


    this.registers = [];
    this.studentId = 160001;


    this.init = function() {
        $log.log('RegisterRecordsController::loadRegister called');
        this.getRegisters();
    };

    this.getRegisters = function(id) {
        var lookupRegisterId;
        if (id) {
            lookupRegisterId = id;
        } else {
            lookupRegisterId = this.studentId;
        }

        MasterRegister.get(vm.studentId).then(function(response) {
            $log.log(response.data);
            vm.registers = response.data;
        }, function(response) {
            $log.log("EE - Failed to retrieve data for register");
        });
    };

    this.init();
});
