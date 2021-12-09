(function() {

    angular
        .module('SelectionBoxes')
        .directive('entryQualificationSelection', EntryQualificationSelectionDirective);

    EntryQualificationSelectionDirective.$inject = ['EntryQualification'];

    function EntryQualificationSelectionDirective(EntryQualification) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                name: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel',
                ngRequired: '=',
                altNullText: '=altNullText'
            },
            link: function(scope, element, attrs, controller) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;

            },
            controller: ['EntryQualification', function(EntryQualification) {
                var vm = this;
                vm.entryQualifications = [];
                EntryQualification.query().then(function(response) {
                    vm.entryQualifications = response.data;
                }, function(err) {
                    alert("Error Retrieving EntryQualifications");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/entryQualification/entry-qualification.selection.html',
        };
    }

})();
