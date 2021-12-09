(function() {

    angular
        .module('SelectionBoxes')
        .directive('contactTypeSelection', ContactTypeSelectionDirective);

    ContactTypeSelectionDirective.$inject = ['ContactType'];

    function ContactTypeSelectionDirective(ContactType) {
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
            controller: ['ContactType', function(ContactType) {
                var vm = this;
                vm.contactTypes = [];
                ContactType.query().then(function(response) {
                    vm.contactTypes = response.data;
                }, function(err) {
                    alert("Error Retrieving ContactTypes");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/contactType/contact-type.selection.html',
        };
    }

})();
