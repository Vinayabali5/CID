(function() {

    angular
        .module('SelectionBoxes')
        .directive('levelSelection', LevelSelectionDirective);

    LevelSelectionDirective.$inject = ['Level'];

    function LevelSelectionDirective(Level) {
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
            controller: ['Level', function(Level) {
                var vm = this;
                vm.levels = [];
                Level.query().then(function(response) {
                    vm.levels = response.data;
                }, function(err) {
                    alert("Error Retrieving Levels");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/level/level.selection.html',
        };
    }

})();
