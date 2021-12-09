(function() {

    angular
        .module('SelectionBoxes')
        .directive('fileCategorySelection', FileCategorySelectionDirective);

    FileCategorySelectionDirective.$inject = ['FileCategory'];

    function FileCategorySelectionDirective(FileCategory) {
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
            controller: ['FileCategory', function(FileCategory) {
                var vm = this;
                vm.fileCategories = [];
                FileCategory.query().then(function(response) {
                    vm.fileCategories = response.data;
                }, function(err) {
                    alert("Error Retrieving FileCategories");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/file-category/file-category.selection.html',
        };
    }

})();
