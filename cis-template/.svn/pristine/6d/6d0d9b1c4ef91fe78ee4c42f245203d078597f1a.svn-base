angular.module('CheckBoxDirective').controller(
    'CheckBoxDirectiveController',
    function($rootScope, $scope, $http, $uibModal) {
        var vm = this;
        $scope.checkBox = false;
        console.log('CheckBoxDirectiveController loaded');

        $scope.callChangeSelected = function() {
            $scope.changeSelected({
                checkBoxListIndex: $scope.checkBoxId,
                selected: $scope.checkBox
            });
        };

        $scope.locateData = function(callback) {
            $scope.curParent = $scope.$parent;
            while ($scope.curParent.$parent !== null) {
                if (callback($scope.curParent) !== undefined) {
                    return callback($scope.curParent);
                } else {
                    $scope.curParent = $scope.curParent.$parent;
                }
            }
        };

        $scope.init = function() {
            // $scope.examBoard = $scope.locateData(function(data) { return
            // data.examBoard });
            $scope.checkBoxId = $scope.locateData(function(data) {
                return data.$index;
            });
        };

        $scope.init();
    });
