angular.module('CheckBoxDirective', ['ngResource', 'ui.bootstrap'])
    .directive('checkBox', function() {
        return {
            scope: {
                changeSelected: '&'
            },
            //replace: true,
            controller: 'CheckBoxDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/exams/checkBox/checkBox.html',
        };
    });
