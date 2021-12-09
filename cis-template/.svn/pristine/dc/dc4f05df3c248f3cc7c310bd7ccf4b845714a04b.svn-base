angular.module('cid.tests').controller('TestPersonController', function($log, $scope, Person) {
    var vm = this;

    this.personId = 1;

    this.person = {};

    this.init = function() {
        $log.log('PersonRecordsController::loadPerson called');
        this.getPerson();
    };

    this.getPerson = function(id) {
        var lookupPersonId = id ? id : this.personId;
        // if (id) {
        // 	lookupPersonId = id;
        // } else {
        // 	lookupPersonId = this.personId;
        // }
        $log.log('Getting Person: ' + lookupPersonId);
        Person.get(vm.personId).then(function(response) {
            vm.person = response.data;
        }, function(response) {
            $log.log("EE - Failed to retrieve data for person");
        });
    };

    this.init();
});
