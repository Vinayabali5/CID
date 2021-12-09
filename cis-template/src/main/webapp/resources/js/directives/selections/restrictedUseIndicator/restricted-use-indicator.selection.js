(function() {

    angular
        .module('SelectionBoxes')
        .directive('restrictedUseIndicatorSelection', RestrictedUseIndicatorSelectionDirective);

    RestrictedUseIndicatorSelectionDirective.$inject = ['RestrictedUseIndicator'];

    function RestrictedUseIndicatorSelectionDirective(RestrictedUseIndicator) {
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
            controller: ['RestrictedUseIndicator', function(RestrictedUseIndicator) {
                var vm = this;

                vm.restrictedUseIndicators = [];

                RestrictedUseIndicator.query().then(function(response) {
                    vm.restrictedUseIndicators = response.data;
                }, function(err) {
                    alert("Error Retrieving RestrictedUseIndicators");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/restrictedUseIndicator/restricted-use-indicator.selection.html',
        };
    }

})();
