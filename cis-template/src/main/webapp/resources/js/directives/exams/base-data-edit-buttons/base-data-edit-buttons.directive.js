/**
 * 
 */
(function() {
    angular
        .module('BaseDataEditButtonsDirective', ['ngResource', 'ui.bootstrap'])
        .directive('baseDataEditButtons', baseDataEditButtonsDirective);

    //baseDataEditButtonsDirective.$inject = [];

    function baseDataEditButtonsDirective() {
        var directive = {
            scope: {
                addCallback: '&',
                editCallback: '&',
                viewStudentsCallback: '&'
            },
            controller: 'BaseDataEditButtonsDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/exams/base-data-edit-buttons/views/base-data-edit-buttons.html'
        };

        return directive;
    }
})();
