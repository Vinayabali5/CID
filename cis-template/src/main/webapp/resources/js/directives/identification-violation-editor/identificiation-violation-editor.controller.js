/**
 * This is the identificationViolations Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('IdentificationViolationsEditorDirective')
        .controller('IdentificationViolationsEditorController', IdentificationViolationsEditorController);

    IdentificationViolationsEditorController.$inject = ['$log', '$scope', '$rootScope', '$uibModal', 'IdentificationViolation'];

    function IdentificationViolationsEditorController($log, $scope, $rootScope, $uibModal, IdentificationViolation) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface

        vm.editIdentificationViolation = editIdentificationViolation;
        vm.addIdentificationViolation = addIdentificationViolation;
        vm.deleteIdentificationViolation = deleteIdentificationViolation;

        // Private Interface`

        function editIdentificationViolation(idViolationId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/identification-violation-editor/views/identification-violation-editor-dialog.html',
                controller: 'IdentificationViolationsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'sm',
                resolve: {
                    identificationViolationEntity: ['IdentificationViolation', function(IdentificationViolation) {
                        return IdentificationViolation.get(idViolationId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });
        }

        // Delete the IdentificationViolation
        function deleteIdentificationViolation(idViolationId) {
            $log.log('IdentificationViolationsEditorController::deleteIdentificationViolation called');
            if (idViolationId) {
                var msg = "Are you sure you want to delete this IdentificationViolation?";
                if (window.confirm(msg)) {
                    IdentificationViolation.delete(idViolationId).then(function(response) {
                        $log.info("II IdentificationViolation ($idViolationId) has been deleted");
                        $rootScope.$emit('identification-violation-saved');
                    }, function(response) {
                        $log.info("EE A problem occurred trying to delete IdViolation ($idViolationId)");
                    });
                }
            }
        }


        function addIdentificationViolation() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/identification-violation-editor/views/identification-violation-editor-dialog.html',
                controller: 'IdentificationViolationsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'md',
                resolve: {
                    identificationViolationEntity: function() {
                        var identificationViolations = {
                            studentId: $scope.studentId,
                            date: new Date()
                        };
                        return identificationViolations;
                    }
                }
            });
        }



    }

})();
