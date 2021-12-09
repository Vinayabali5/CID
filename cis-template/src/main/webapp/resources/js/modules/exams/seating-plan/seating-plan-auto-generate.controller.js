/**
 * The seatingPlanGenerator
 */
(function() {
    //
    angular.module('cid.exams.seating-plan').controller(
        'SeatingPlanAutoGenerateController', ["$uibModal", "$uibModalInstance", "$state", "$scope", "entity",
            function($uibModal, $uibModalInstance, $state, $scope, entity) {
                var vm = this;
                console.log('SeatingPlanAutoGenerateController Loaded');

                $scope.autoGenerateSeatingPlans = function() {
                    //		            $uibModalInstance.close({
                    //            			fillDirection: $scope.fillDirection,
                    //                    	snake: $scope.snake,
                    //                    	fillRowsNotColumns: $scope.fillRowsNotColumns,
                    //		            });
                    $uibModalInstance.close($scope.assign);
                };

                $scope.cancel = function() {
                    $uibModalInstance.dismiss();
                };

                $scope.init = function() {
                    $scope.numCols = entity.numCols;
                    $scope.numRows = entity.numRows;
                    $scope.columns = [];
                    for (var i = 0; i < entity.numCols; i++) {
                        $scope.columns.push({
                            index: i,
                            column: String.fromCharCode(65 + i)
                        });
                    }
                };

                $scope.init();
            }
        ]);
})();
