(function() {

    angular
        .module('SelectionBoxes')
        .directive('legalSexSelection', LegalSexSelectionDirective);

    LegalSexSelectionDirective.$inject = ['LegalSex'];

    function LegalSexSelectionDirective(LegalSex) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                name: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel',
                ngRequired: '=',
                altNullText: '=altNullText'
            },
            link: function(scope, element, attrs, controller) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['LegalSex', function(LegalSex) {
                var vm = this;
                vm.legalSexs = [];
                LegalSex.query().then(function(response) {
                    vm.legalSexs = response.data;
                }, function(err) {
                    alert("Error Retrieving LegalSexs");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/legal-sex/legal-sex.selection.html',
        };
    }

})();
