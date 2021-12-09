(function() {
    'use strict';

    angular
        .module('AdmissionDetailsDirective', [])
        .directive('admissionDetails', admissionDetails);

    function admissionDetails() {
        var directive = {
            restrict: 'E',
            scope: {
                studentAdmissions: '='
            },
            templateUrl: 'js/directives/admissions/admission-details/admission-details.html'
        };

        return directive;
    }

})();
