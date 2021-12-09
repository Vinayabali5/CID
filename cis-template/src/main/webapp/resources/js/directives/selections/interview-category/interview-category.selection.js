(function() {

    angular
        .module('SelectionBoxes')
        .directive('interviewCategorySelection', InterviewCategorySelectionDirective);

    InterviewCategorySelectionDirective.$inject = ['InterviewCategory'];

    function InterviewCategorySelectionDirective(InterviewCategory) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                name: '@',
                readonly: '=?',
                ngmodelvar: '=ngModel',
                altNullText: '=altNullText'
            },
            link: function(scope, element, attrs, controller) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: ['InterviewCategory', function(InterviewCategory) {
                var vm = this;
                vm.interviewCategories = [];
                InterviewCategory.query().then(function(response) {
                    vm.interviewCategories = response.data;
                }, function(err) {
                    alert("Error Retrieving InterviewCategories");
                });
            }],
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/selections/interview-category/interview-category.selection.html',
        };
    }

})();
