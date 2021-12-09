angular
    .module('ComponentTableDirective', [
        'ngResource',
        'ui.bootstrap',
        'ComponentService',
    ])
    .directive('componentTable', function() {
        return {
            scope: {
                componentList: '=',
            },
            transclude: true,
            templateUrl: 'js/directives/exams/componentTable/componentTable.html'
        };
    });
