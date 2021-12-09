/**
 *
 */
(function() {
    'use strict';

    angular
        .module('ExpandDirective')
        .controller('ExpandDirectiveController', ExpandDirectiveController);

    ExpandDirectiveController.$inject = ['$scope'];

    function ExpandDirectiveController($scope) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface

        $scope.visible = true;
        $scope.expanded = false;

    }


})();
