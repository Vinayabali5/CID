(function() {

    angular
        .module('SelectionBoxes')
        .directive('destinationSelection', DestinationSelectionDirective);

    DestinationSelectionDirective.$inject = ['Destination'];

    function DestinationSelectionDirective(Destination) {
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
            controller: ['Destination', function(Destination) {
                var vm = this;
                vm.destinations = [];
                Destination.query().then(function(response) {
                    vm.destinations = response.data;
                }, function(err) {
                    alert("Error Retrieving Destinations");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/destination/destination.selection.html',
        };
    }

})();
