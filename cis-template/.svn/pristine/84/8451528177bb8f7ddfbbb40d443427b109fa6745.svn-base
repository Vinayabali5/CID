(function() {
    angular.module('ExamSeriesCheckBoxDirective').controller('ExamSeriesCheckBoxDirectiveController', ExamSeriesCheckBoxDirectiveController);

    ExamSeriesCheckBoxDirectiveController.$inject = ['$rootScope', '$scope', '$http', '$uibModal'];

    function ExamSeriesCheckBoxDirectiveController($rootScope, $scope, $http, $uibModal) {
        var vm = this;
        $scope.examSeriesCheckBox = false;

        console.log('ExamSeriesCheckBoxDirectiveController loaded');

        $scope.callChangeSelected = function() {
            $scope.changeSelected({
                examSeriesListIndex: $scope.examSeriesId,
                selected: $scope.examSeriesCheckBox
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
            //		$scope.examBoard = $scope.locateData(function(data) { return data.examBoard });
            $scope.examSeriesId = $scope.locateData(function(data) {
                return data.$index;
            });
        };

        $scope.init();
    }
})();
