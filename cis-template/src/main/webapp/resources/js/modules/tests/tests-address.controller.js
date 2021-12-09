angular.module('cid.tests').controller('TestAddressController', function($log, $scope, Address) {
    var vm = this;

    this.addressId = 1;

    this.address = {};

    this.init = function() {
        $log.log('AddressRecordsController::loadAddress called');
        this.getAddress();
    };

    this.getAddress = function(id) {
        var lookupAddressId;
        if (id) {
            lookupAddressId = id;
        } else {
            lookupAddressId = this.addressId;
        }
        $log.log('Getting Address: ' + lookupAddressId);
        Address.get(vm.addressId).then(function(response) {
            vm.address = response.data;
        }, function(response) {
            $log.log("EE - Failed to retrieve data for address");
        });
    };

    this.init();
});
