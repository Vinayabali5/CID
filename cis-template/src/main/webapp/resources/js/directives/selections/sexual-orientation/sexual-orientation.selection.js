(function() {

    angular
        .module('SelectionBoxes')
        .directive('sexualOrientationSelection', SexualOrientationSelectionDirective);

    SexualOrientationSelectionDirective.$inject = ['SexualOrientation'];

    function SexualOrientationSelectionDirective(SexualOrientation) {
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
            controller: ['SexualOrientation', function(SexualOrientation) {
                var vm = this;
                vm.sexualOrientations = [];
                SexualOrientation.query().then(function(response) {
                    vm.sexualOrientations = response.data;
                }, function(err) {
                    alert("Error Retrieving SexualOrientations");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/sexual-orientation/sexual-orientation.selection.html',
        };
    }

})();
