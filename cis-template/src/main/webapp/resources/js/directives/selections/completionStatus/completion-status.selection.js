(function() {

    angular
        .module('SelectionBoxes')
        .directive('completionStatusSelection', CompletionStatusSelectionDirective);

    CompletionStatusSelectionDirective.$inject = ['CompletionStatus'];

    function CompletionStatusSelectionDirective(CompletionStatus) {
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
            controller: ['CompletionStatus', function(CompletionStatus) {
                var vm = this;
                vm.completionStatuss = [];
                CompletionStatus.query().then(function(response) {
                    vm.completionStatuses = response.data;
                }, function(err) {
                    alert("Error Retrieving CompletionStatuses");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/completionStatus/completion-status.selection.html',
        };
    }

})();
