angular.module('cid.tests').controller('TestLetterController', function($log, $scope, Letter) {
    var vm = this;

    this.letters = [];

    Letter.getAllAuthorised().then(function(response) {
        vm.letters = response.data;
    }, function(response) {
        Logger.error("Failed to load Letters");
    });
});
