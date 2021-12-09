(function() {

    angular
        .module('SelectionBoxes')
        .directive('correspondenceTypeSelection', CorrespondenceTypeSelectionDirective);

    CorrespondenceTypeSelectionDirective.$inject = ['CorrespondenceType'];

    function CorrespondenceTypeSelectionDirective(CorrespondenceType) {
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
            controller: ['CorrespondenceType', function(CorrespondenceType) {
                var vm = this;
                vm.correspondenceTypes = [];
                CorrespondenceType.query().then(function(response) {
                    vm.correspondenceTypes = response.data;
                }, function(err) {
                    alert("Error Retrieving CorrespondenceTypes");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/correspondenceType/correspondence-type.selection.html',
        };
    }

})();
