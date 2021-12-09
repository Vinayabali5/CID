(function() {

    angular
        .module('SelectionBoxes')
        .directive('concessionSelection', ConcessionSelectionDirective);

    ConcessionSelectionDirective.$inject = ['ConcessionType'];

    function ConcessionSelectionDirective(ConcessionType) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                name: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel',
                ngRequired: '='
            },
            link: function(scope, element, attrs, controller) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['ConcessionType', function(ConcessionType) {
                var vm = this;
                vm.concessions = [];
                ConcessionType.query().then(function(response) {
                    vm.concessions = response.data;
                }, function(err) {
                    alert("Error Retrieving Concessions");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/concession/concession.selection.html',
        };
    }

})();
