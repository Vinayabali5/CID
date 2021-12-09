angular.module('Lookups').directive('contactTypeLookup', function(ContactType) {
    return {
        restrict: 'E',
        scope: {
            contactTypeId: '=',
        },
        link: function(scope, element) {
            if (scope.contactTypeId !== undefined) {
                ContactType.get(scope.contactTypeId).then(function(response) {
                    scope.contactType = response.data.description;
                }, function(response) {
                    scope.contactType = "**ERROR**";
                    element.addClass('error');
                });
            }
        },
        templateUrl: 'js/directives/lookups/contactType/contact-type.lookup.html',
    };
});
