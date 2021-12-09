angular.module('cid.tests').controller('TestContactsController', function($log, $scope, Person, Contact) {
    var vm = this;

    this.contacts = [];
    this.personId = 1;

    this.init = function() {
        $log.log('ContactRecordsController::loadStudent called');
        this.getContacts();
    };

    this.getContacts = function(id) {
        $log.log(vm.contact);
        var lookupId;
        if (id) {
            lookupId = id;
        } else {
            lookupId = this.personId;
        }
        Person.contacts(vm.personId).then(function(response) {
            $log.log(response.data);
            vm.contacts = response.data;
        }, function(response) {
            $log.log("EE - Failed to retrieve data for contact");
        });

    };


    this.init();
});
