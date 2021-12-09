/**
 * This is the StudentDetails Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StudentDetailsDirective')
        .controller('StudentDetailsDirectiveController', StudentDetailsDirectiveController);

    StudentDetailsDirectiveController.$inject = ['$log', '$scope', '$rootScope', 'Student'];

    function StudentDetailsDirectiveController($log, $scope, $rootScope, Student) {
        /* jshint validthis:true */
        var vm = this;
        this.message = '';

        this.init = function() {};

        $scope.hasData = function() {
            if ($scope.student) {
                return true;
            } else {
                return false;
            }
        };

        this.init();
    }
})();
