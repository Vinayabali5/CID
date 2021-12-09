/**
 * This is the EntryQualificationTypes Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('EntryQualificationTypesEditorDirective')
        .controller('EntryQualificationTypesEditorController', EntryQualificationTypesEditorController);

    EntryQualificationTypesEditorController.$inject = ['$log', '$uibModal', '$scope', 'EntryQualificationType'];

    function EntryQualificationTypesEditorController($log, $uibModal, $scope, EntryQualificationType) {
        /* jshint validthis:true */
        var vm = this;

        vm.editEntryQualificationTypes = editEntryQualificationTypes;
        vm.addEntryQualificationTypes = addEntryQualificationTypes;

        function loadEntryQualificationTypes() {
            EntryQualificationType.query().then(function(response) {
                $scope.entryQualificationTypes = response.data;
                $log.info("Loading Faculty ");
            }, function(response) {
                $log.error("Failed to load Faculties");
            });
        }

        function editEntryQualificationTypes(entryQualificationTypeId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/entry-qualification-types-editor/views/entry-qualification-types-editorDialog.html',
                controller: 'EntryQualificationTypesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    entryQualificationTypesEntity: function(EntryQualificationType) {
                        return EntryQualificationType.get(entryQualificationTypeId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadEntryQualificationTypes();
            });

        }

        function addEntryQualificationTypes() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/entry-qualification-types-editor/views/entry-qualification-types-editorDialog.html',
                controller: 'EntryQualificationTypesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    entryQualificationTypesEntity: function() {
                        var entryQualificationTypes = {};
                        return entryQualificationTypes;
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadEntryQualificationTypes();
            });
        }

    }

})();
