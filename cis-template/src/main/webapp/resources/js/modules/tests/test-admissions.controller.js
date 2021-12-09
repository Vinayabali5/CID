(function() {

    angular
        .module('cid.tests')
        .controller('TestAdmissionsController', testAdmissionsController);

    testAdmissionsController.$inject = ['$log', 'StudentCollegeFundPaid'];

    function testAdmissionsController($log, StudentCollegeFundPaid) {

        var vm = this;
        vm.studentId = '160008';
        vm.studentCollegeFundPaid = "";

        vm.init = init;

        function init() {
            StudentCollegeFundPaid.get(vm.studentId).then(function(response) {
                vm.studentCollegeFundPaid = response.data;
            });
        }



        vm.init();
    }

})();
