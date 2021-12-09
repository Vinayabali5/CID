(function() {

    angular
        .module('SelectionBoxes')
        .directive('specialCategorySelection', SpecialCategorySelectionDirective);

    SpecialCategorySelectionDirective.$inject = ['SpecialCategory'];

    function SpecialCategorySelectionDirective(SpecialCategory) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                name: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel'
            },
            link: function(scope, element, attrs, controller) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['SpecialCategory', function(SpecialCategory) {
                var vm = this;
                vm.specialCategories = [];
                SpecialCategory.query().then(function(response) {
                    vm.specialCategories = response.data;
                }, function(err) {
                    alert("Error Retrieving SpecialCategories");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/specialCategory/special-category.selection.html',
        };
    }

})();
