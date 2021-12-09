(function() {

    angular
        .module('SelectionBoxes')
        .directive('religionSelection', ReligionSelectionDirective);

    ReligionSelectionDirective.$inject = ['Religion'];

    function ReligionSelectionDirective(Religion) {
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
            controller: ['Religion', function(Religion) {
                var vm = this;
                vm.religions = [];
                Religion.query().then(function(response) {
                    vm.religions = response.data;
                }, function(err) {
                    alert("Error Retrieving Religions");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/religion/religion.selection.html',
        };
    }

})();
