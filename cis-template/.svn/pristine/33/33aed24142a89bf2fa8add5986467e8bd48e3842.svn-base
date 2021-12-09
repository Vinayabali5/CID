(function() {

    angular
        .module('SelectionBoxes')
        .directive('bursaryTypeSelection', BursaryTypeSelectionDirective);

    BursaryTypeSelectionDirective.$inject = ['BursaryType'];

    function BursaryTypeSelectionDirective(BursaryType) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel'
            },
            link: function(scope, element, attrs, controller) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['BursaryType', function(BursaryType) {
                var vm = this;
                vm.bursaryTypes = [];
                BursaryType.query().then(function(response) {
                    vm.bursaryTypes = response.data;
                }, function(err) {
                    alert("Error Retrieving BursaryTypes");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/bursary-type/bursary-type.selection.html',
        };
    }

})();
