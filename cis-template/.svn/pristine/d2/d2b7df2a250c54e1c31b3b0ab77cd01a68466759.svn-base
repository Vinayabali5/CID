(function() {
    'use strict';

    angular
        .module('DataSharingOptionDirective', ['ui.bootstrap.modal', 'EntityServices'])
        .directive('dataSharingOption', dataSharingOption);

    function dataSharingOption() {
        var directive = {
            restrict: 'E',
            scope: {
                dataSharingOption: '=?'
            },
            templateUrl: 'js/directives/admissions/data-sharing-option/views/data-sharing-option-details.html',
            controller: 'DataSharingOptionEditorController',
            controllerAs: 'ctrl'
        };

        return directive;

    }


})();
