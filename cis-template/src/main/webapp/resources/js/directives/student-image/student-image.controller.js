/**
 * This is the StudentImage Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StudentImageDirective')
        .controller('StudentImageDirectiveController', StudentImageDirectiveController);

    StudentImageDirectiveController.$inject = ['$log', '$scope', '$rootScope', 'GLOBAL'];

    function StudentImageDirectiveController($log, $scope, $rootScope, GLOBAL) {
        // Public Interface

        $scope.imageUrl = "";
        $scope.loadImageUrl = loadImageUrl;

        // Private Interface

        function loadImageUrl() {
            if ($scope.studentId !== undefined) {
                $scope.imageUrl = GLOBAL.STUDENT_IMAGES_URL + $scope.studentId + '.jpg';
            }
            return $scope.imageUrl;
        }
    }
})();
