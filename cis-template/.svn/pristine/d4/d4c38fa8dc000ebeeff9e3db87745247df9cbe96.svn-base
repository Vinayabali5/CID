(function() {

    angular
        .module('SelectionBoxes')
        .directive('offerTypeSelection', OfferTypeSelectionDirective);

    OfferTypeSelectionDirective.$inject = ['OfferType'];

    function OfferTypeSelectionDirective(OfferType) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                name: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel',
                altNullText: '=altNullText'
            },
            link: function(scope, element, attrs, controller) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['OfferType', function(OfferType) {
                var vm = this;
                vm.offerTypes = [];
                OfferType.query().then(function(response) {
                    vm.offerTypes = response.data;
                }, function(err) {
                    alert("Error Retrieving OfferTypes");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/offerType/offer-type.selection.html',
        };
    }

})();
