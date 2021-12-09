/**
 * The seatingPlanGenerator
 */
(function() {
    //
    angular.module('cid.exams.seating-plan').controller(
        'SeatingPlanStudentSettingsController', ["$uibModal", "$uibModalInstance", "$state", "$scope", "entity",
            function($uibModal, $uibModalInstance, $state, $scope, entity) {
                var vm = this;

                $scope.cancel = cancel;
                $scope.filterOptions = {};
                $scope.displayOptions = {};
                $scope.save = save;

                ////////////////////////////

                console.log('SeatingPlanStudentSettingsController Loaded');
                init();

                function cancel() {
                    $uibModalInstance.dismiss();
                }

                function init() {
                    $scope.filterOptions = entity.filterOptions;
                    $scope.displayOptions = entity.displayOptions;
                }

                function save() {
                    $uibModalInstance.close($scope.filterOptions);
                }
            }
        ]);
})();
