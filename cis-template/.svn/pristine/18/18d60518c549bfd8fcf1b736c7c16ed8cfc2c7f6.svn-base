(function() {

    angular
        .module('SelectionBoxes')
        .directive('supportTypeSelection', SupportTypeSelectionDirective);

    SupportTypeSelectionDirective.$inject = ['SupportType'];

    function SupportTypeSelectionDirective(SupportType) {
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
            controller: ['SupportType', function(SupportType) {
                var vm = this;
                vm.supportTypes = [];
                SupportType.query().then(function(response) {
                    vm.supportTypes = response.data;
                }, function(err) {
                    alert("Error Retrieving SupportTypes");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/supportType/support-type.selection.html',
        };
    }

})();
