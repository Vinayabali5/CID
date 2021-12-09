/**
 * This is the CorrespondenceTypes Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('CorrespondenceTypesEditorDirective')
        .controller('CorrespondenceTypesEditorController', CorrespondenceTypesEditorController);

    CorrespondenceTypesEditorController.$inject = ['$log', '$uibModal', '$scope', 'CorrespondenceType'];

    function CorrespondenceTypesEditorController($log, $uibModal, $scope, CorrespondenceType) {
        /* jshint validthis:true */
        var vm = this;

        vm.editCorrespondenceTypes = editCorrespondenceTypes;
        vm.addCorrespondenceTypes = addCorrespondenceTypes;

        function loadCorrespondenceTypes() {
            CorrespondenceType.query().then(function(response) {
                $scope.correspondenceTypes = response.data;
            }, function(response) {
                $log.error("Failed to load Faculties");
            });
        }

        function editCorrespondenceTypes(correspondenceTypeId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/correspondence-types-editor/views/correspondence-types-editorDialog.html',
                controller: 'CorrespondenceTypesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    correspondenceTypesEntity: function(CorrespondenceType) {
                        return CorrespondenceType.get(correspondenceTypeId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadCorrespondenceTypes();
            });
        }

        function addCorrespondenceTypes() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/correspondence-types-editor/views/correspondence-types-editor-addDialog.html',
                controller: 'CorrespondenceTypesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    correspondenceTypesEntity: [function() {
                        var correspondenceTypes = {};
                        return correspondenceTypes;
                    }]
                }
            });

            modalInstance.result.then().finally(function() {
                loadCorrespondenceTypes();
            });
        }

    }

})();
