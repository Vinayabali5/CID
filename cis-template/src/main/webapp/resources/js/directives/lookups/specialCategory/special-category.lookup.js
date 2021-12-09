angular.module('Lookups').directive('specialCategoryLookup', function(SpecialCategory) {
    return {
        restrict: 'E',
        scope: {
            specialCategoryId: '=',
        },
        link: function(scope, element) {
            if (scope.specialCategoryId !== undefined) {
                SpecialCategory.get(scope.specialCategoryId).then(function(response) {
                    scope.specialCategory = response.data.description;
                }, function(response) {
                    scope.specialCategory = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/specialCategory/special-category.lookup.html',
    };
});
