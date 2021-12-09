/**
 * This is the Student Bursary Details Directive definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]
 *
 */
(function() {
    'use strict';

    angular
        .module('StudentBursaryDetailsDirective', [
            'cid.service.logger',
            'StudentService'
        ])
        .directive('studentBursaryDetails', studentBursaryDetails);

    function studentBursaryDetails() {

        var directive = {

            restrict: 'E',
            scope: {
                showAll: '=?',
                studentBursary: '=',
            },
            templateUrl: 'js/directives/student-bursary-details/student-bursary-details.html',

        };

        return directive;
    }
})();
