/**
 * The genericViewer module for displaying the details within a JSON file
 */
(function() {
    angular.module('GenericViewer', [
        'ngResource',
        'ui.bootstrap',
    ]).controller('GenericViewerController', function($scope, $uibModalInstance, headerVal, dataSet) {
        console.log('genericViewerController loaded');
        $scope.headerVal = headerVal;
        $scope.dataSet = dataSet;

        $scope.checkObject = function(value) {
            if (typeof value == "object" && value !== null) {
                return true; // Object
            } else {
                return false;
            }
        };

        $scope.checkNotHidden = function(key, value) {
            if (typeof value == "object" || value === null || key.substring(0, 1) == "_") {
                return false; // Hidden - Do not display
            } else {
                return true;
            }
        };

        $scope.cancel = function() {
            $uibModalInstance.dismiss('cancel');
        };
    });
})();
