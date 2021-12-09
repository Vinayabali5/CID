/**
 * This is the ConcessionTypes Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('ConcessionTypesEditorDirective')
        .controller('ConcessionTypesEditorController', ConcessionTypesEditorController);

    ConcessionTypesEditorController.$inject = ['$log', '$uibModal', '$scope', 'ConcessionType'];

    function ConcessionTypesEditorController($log, $uibModal, $scope, ConcessionType) {
        /* jshint validthis:true */
        var vm = this;

        vm.editConcessionTypes = editConcessionTypes;
        vm.addConcessionTypes = addConcessionTypes;

        function loadConcessionTypes() {
            ConcessionType.query().then(function(response) {
                $scope.concessionTypes = response.data;
                $log.info("Loading Faculty ");
            }, function(response) {
                $log.error("Failed to load Faculties");
            });
        }

        function editConcessionTypes(concessionTypeId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/concession-types-editor/views/concession-types-editorDialog.html',
                controller: 'ConcessionTypesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    concessionTypesEntity: function(ConcessionType) {
                        return ConcessionType.get(concessionTypeId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadConcessionTypes();
            });
        }

        function addConcessionTypes() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/concession-types-editor/views/concession-types-editor-addDialog.html',
                controller: 'ConcessionTypesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    concessionTypesEntity: function() {
                        var concessionTypes = {};
                        return concessionTypes;
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadConcessionTypes();
            });
        }

    }

})();
