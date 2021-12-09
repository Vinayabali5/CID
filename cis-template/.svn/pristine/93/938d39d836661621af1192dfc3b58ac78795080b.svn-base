/**
 * This is the StudentRiskLevelDetails Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StudentRiskLevelDetailsDirective')
        .controller('StudentRiskLevelDetailsDirectiveController', StudentRiskLevelDetailsDirectiveController);

    StudentRiskLevelDetailsDirectiveController.$inject = ['$log', '$scope', '$rootScope'];

    function StudentRiskLevelDetailsDirectiveController($log, $scope, $rootScope) {
        /* jshint validthis:true */
        var vm = this;
        this.message = '';

        $scope.active = -1;

        $scope.hasData = function() {
            if ($scope.studentRiskLevels && $scope.studentRiskLevels !== undefined) {
                return true;
            } else {
                return false;
            }
        };

        $scope.hasSpecialCategories = function() {
            if ($scope.hasData() && $scope.studentRiskLevels.length !== 0) {
                return true;
            } else {
                return false;
            }
        };
    }
})();
