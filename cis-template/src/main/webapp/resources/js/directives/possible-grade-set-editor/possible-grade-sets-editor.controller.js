/**
 * This is the PossibleGradeSets Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('PossibleGradeSetsEditorDirective')
        .controller('PossibleGradeSetsEditorController', PossibleGradeSetsEditorController);

    PossibleGradeSetsEditorController.$inject = ['$log', '$rootScope', '$scope', '$uibModal', 'PossibleGradeSet'];

    function PossibleGradeSetsEditorController($log, $rootScope, $scope, $uibModal, PossibleGradeSet) {
        /* jshint validthis:true */
        var vm = this;

        vm.editPossibleGradeSets = editPossibleGradeSets;
        vm.addPossibleGradeSets = addPossibleGradeSets;

        // Event Listener
        $scope.$on('$destroy', $rootScope.$on('possible-grade-set-saved', function(data) {
            loadPossibleGradeSets();
        }));


        function loadPossibleGradeSets() {
            PossibleGradeSet.query().then(function(response) {
                $scope.possibleGradeSets = response.data;
                $log.info("Loading PossibleGradeSets ");
            }, function(response) {
                $log.error("Failed to load PossibleGradeSets");
            });
        }

        function openGradeSetDialog(gradeSet) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/possible-grade-set-editor/views/possible-grade-sets-editorDialog.html',
                controller: 'PossibleGradeSetsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                scope: $scope,
                resolve: {
                    possibleGradeSetsEntity: gradeSet
                }
            });
        }


        function editPossibleGradeSets(possibleGradeSetId) {
            openGradeSetDialog(function(PossibleGradeSet) {
                return PossibleGradeSet.get(possibleGradeSetId);
            });
        }

        function addPossibleGradeSets() {
            openGradeSetDialog({});
        }

    }

})();
