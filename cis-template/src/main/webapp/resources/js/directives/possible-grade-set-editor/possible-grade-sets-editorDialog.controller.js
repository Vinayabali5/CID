/**
 * This is the Possible GradeSets Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('PossibleGradeSetsEditorDirective')
        .controller('PossibleGradeSetsEditorDialogController', PossibleGradeSetsEditorDialogController);

    PossibleGradeSetsEditorDialogController.$inject = ['$uibModal', '$rootScope', '$scope', '$log', '$state', '$uibModalInstance', 'PossibleGradeSet', 'possibleGradeSetsEntity', 'PossibleGrade'];

    function PossibleGradeSetsEditorDialogController($uibModal, $rootScope, $scope, $log, $state, $uibModalInstance, PossibleGradeSet, possibleGradeSetsEntity, PossibleGrade) {
        /* jshint validthis:true */
        var vm = this;
        vm.possibleGradeSet = possibleGradeSetsEntity != undefined ? possibleGradeSetsEntity.data : undefined;
        //  vm.possibleGrade = possibleGradesEntity

        vm.cancel = cancel;
        vm.save = save;
        vm.editPossibleGrade = editPossibleGrade;
        vm.addPossibleGrade = addPossibleGrade;
        // Event Listener
        $scope.$on('$destroy', $rootScope.$on('possible-grade-sets-saved', function(data) {
            PossibleGradeSet.getPossibleGradesBySetId(vm.possibleGradeSet.id).then(function(response) {
                vm.possibleGrades = response.data;
            });
        }));

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }
        var onSaveFinished = function(result) {
            $scope.$emit('possible-grade-sets-saved', result);
            $uibModalInstance.close(result);
        };

        function save() {
            console.log(vm.possibleGradeSet);
            if (vm.possibleGradeSet.id) {
                PossibleGradeSet.save(vm.possibleGradeSet, onSaveFinished);
            } else {
                if (vm.possibleGradeSet.id !== null) {
                    PossibleGradeSet.create(vm.possibleGradeSet, onSaveFinished);
                }
            }
        }

        // Function to edit individual grade
        function editPossibleGrade(possibleGrade) {
            // Open dialog 
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/possible-grade-set-editor/views/possible-grade-sets-editor.grade-editor-dialog.html',
                controller: ['$scope', '$uibModalInstance', function($scope, $uibModalInstance) {
                    $scope.possibleGrade = possibleGrade;
                    $scope.save = function() {
                        $uibModalInstance.close();
                    };
                }]
            });
        }

        // Function to add new grade
        function addPossibleGrade() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/possible-grade-set-editor/views/possible-grade-sets-editor.grade-editor-dialog.html',
                controller: ['$scope', '$uibModalInstance', function($scope, $uibModalInstance) {
                    $scope.possibleGrade = {};
                    $scope.save = function() {
                        PossibleGrade.create($scope.possibleGrade);
                        $uibModalInstance.close();
                    };
                }],
            });
        }

    }

})();
