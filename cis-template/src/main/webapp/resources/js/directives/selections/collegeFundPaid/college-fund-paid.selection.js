(function() {

    angular
        .module('SelectionBoxes')
        .directive('collegeFundPaidSelection', CollegeFundPaidSelectionDirective);

    CollegeFundPaidSelectionDirective.$inject = ['CollegeFundPaid'];

    function CollegeFundPaidSelectionDirective(CollegeFundPaid) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                name: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel'
            },
            link: function(scope, element, attrs, controller) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['CollegeFundPaid', function(CollegeFundPaid) {
                var vm = this;
                vm.collegeFundPaids = [];
                CollegeFundPaid.query().then(function(response) {
                    vm.collegeFundPaids = response.data;
                }, function(err) {
                    alert("Error Retrieving CollegeFundPaids");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/collegeFundPaid/college-fund-paid.selection.html',
        };
    }

})();
