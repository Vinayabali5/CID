/**
 * This is the WarningCodeChangeDetails Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('WarningCodeChangeDetailsDirective', [])
        .directive('warningCodeChangeDetails', warningCodeChangeDetails);

    function warningCodeChangeDetails() {
        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                warningCodeChanges: '=?',
            },
            templateUrl: 'js/directives/warning-code-change-details/warning-code-change-details.html',
        };
        return directive;
    }
})();
