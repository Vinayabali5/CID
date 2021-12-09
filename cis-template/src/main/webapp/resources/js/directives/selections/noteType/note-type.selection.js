(function() {

    angular
        .module('SelectionBoxes')
        .directive('noteTypeSelection', NoteTypeSelectionDirective);

    NoteTypeSelectionDirective.$inject = ['NoteType'];

    function NoteTypeSelectionDirective(NoteType) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                name: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel',
                ngRequired: '='
            },
            link: function(scope, element, attrs, controller) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['NoteType', function(NoteType) {
                var vm = this;
                vm.noteTypes = [];
                NoteType.query().then(function(response) {
                    vm.noteTypes = response.data;
                }, function(err) {
                    alert("Error Retrieving NoteTypes");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/noteType/note-type.selection.html',
        };
    }

})();
