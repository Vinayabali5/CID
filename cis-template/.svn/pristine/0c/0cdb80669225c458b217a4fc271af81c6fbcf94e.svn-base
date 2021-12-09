/**
 * This directive is used to display a the Medical Notes 
 *
 * Applied Styles:
 *
 * @type Directive
 * 
 */

(function() {
    'use strict';

    angular
        .module('MedicalNotesDetailsDirective', [])
        .directive('medicalNotesDetails', medicalNotesDetails);

    function medicalNotesDetails() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                student: '=',
            },
            templateUrl: 'js/directives/medical-notes-details/medical-notes-details.html',
            transclude: true,
        };

        return directive;
    }
})();
