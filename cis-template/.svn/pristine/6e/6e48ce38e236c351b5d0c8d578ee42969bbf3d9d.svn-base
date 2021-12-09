(function() {
    'use strict';

    angular
        .module('SelectionBoxes')
        .directive('titleSelection', TitleSelectionDirective);

    TitleSelectionDirective.$inject = ['Title'];

    function TitleSelectionDirective(Title) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel',
                altNullText: '=altNullText'
            },
            link: function(scope, element, attrs) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['Title', function(Title) {
                var vm = this;
                vm.titles = [];
                Title.query().then(function(response) {
                    vm.titles = response.data;
                }, function(response) {
                    bootbox.alert("Error Retrieving Titles");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/title/title.selection.html',

        };
    }

})();
