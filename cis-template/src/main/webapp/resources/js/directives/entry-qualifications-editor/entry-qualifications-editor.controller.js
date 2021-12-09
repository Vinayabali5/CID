/**
 * This is the EntryQualifications Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('EntryQualificationsEditorDirective')
        .controller('EntryQualificationsEditorController', EntryQualificationsEditorController);

    EntryQualificationsEditorController.$inject = ['$log', '$uibModal', '$scope', 'EntryQualification'];

    function EntryQualificationsEditorController($log, $uibModal, $scope, EntryQualification) {
        /* jshint validthis:true */
        var vm = this;

        vm.editEntryQualifications = editEntryQualifications;
        vm.addEntryQualifications = addEntryQualifications;

        function loadEntryQualifications() {
            EntryQualification.query().then(function(response) {
                $scope.entryQualifications = response.data;
                $log.info("Loading Faculty ");
            }, function(response) {
                $log.error("Failed to load Faculties");
            });
        }

        function editEntryQualifications(entryQualificationId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/entry-qualifications-editor/views/entry-qualifications-editorDialog.html',
                controller: 'EntryQualificationsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    entryQualificationsEntity: function(EntryQualification) {
                        return EntryQualification.get(entryQualificationId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadEntryQualifications();
            });
        }


        function addEntryQualifications() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/entry-qualifications-editor/views/entry-qualifications-editorDialog.html',
                controller: 'EntryQualificationsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    entryQualificationsEntity: function() {
                        var entryQualifications = {};
                        return entryQualifications;
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadEntryQualifications();
            });
        }

    }

})();
