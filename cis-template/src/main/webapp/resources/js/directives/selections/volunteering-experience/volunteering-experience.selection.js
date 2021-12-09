(function() {

    angular
        .module('SelectionBoxes')
        .directive('volunteeringExperienceSelection', VolunteeringExperienceSelectionDirective);

    VolunteeringExperienceSelectionDirective.$inject = ['VolunteeringExperience'];

    function VolunteeringExperienceSelectionDirective(VolunteeringExperience) {
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
            controller: ['VolunteeringExperience', function(VolunteeringExperience) {
                var vm = this;
                vm.volunteeringExperiences = [];
                VolunteeringExperience.query().then(function(response) {
                    vm.volunteeringExperiences = response.data;
                }, function(err) {
                    alert("Error Retrieving VolunteeringExperiences");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/volunteering-experience/volunteering-experience.selection.html',
        };
    }

})();
