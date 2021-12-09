/**
 * The seatingPlanGenerator
 */
(function() {
    //
    angular.module('cid.exams.seating-plan').controller(
        'SeatingPlanBulkClearSeatsController', ["$uibModal", "$uibModalInstance", "$state", "$scope", "entity",
            function($uibModal, $uibModalInstance, $state, $scope, entity) {
                var vm = this;

                $scope.bulkClearSeats = bulkClearSeats;
                $scope.cancel = cancel;

                ////////////////////////////

                console.log('SeatingPlanAutoGenerateController Loaded');
                init();

                function bulkClearSeats() {
                    $uibModalInstance.close($scope.assign);
                }

                function cancel() {
                    $uibModalInstance.dismiss();
                }

                function init() {
                    $scope.numCols = entity.numCols;
                    $scope.numRows = entity.numRows;
                    $scope.columns = [];
                    for (var i = 0; i < entity.numCols; i++) {
                        $scope.columns.push({
                            index: i,
                            column: String.fromCharCode(65 + i)
                        });
                    }
                }

            }
        ]);
})();
