(function() {
    angular
        .module('OptionTableDirective', ['ngResource', 'ui.bootstrap', 'OptionService', 'ExpandDirective'])
        .directive('optionTable', optionTableDirective);

    function optionTableDirective() {
        return {
            scope: {
                syllabusId: '=',
                expandable: '=',
            },
            transclude: true,
            controller: 'OptionTableDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/exams/optionTable/optionTable.html'
        };
    }
})();
