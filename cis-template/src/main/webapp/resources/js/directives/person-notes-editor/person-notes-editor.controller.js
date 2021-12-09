/**
 * This is the PersonNotes Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('PersonNotesEditorDirective')
        .controller('PersonNotesEditorController', PersonNotesEditorController);

    PersonNotesEditorController.$inject = ['$log', '$rootScope', '$uibModal', '$scope', 'Note', 'Person'];

    function PersonNotesEditorController($log, $rootScope, $uibModal, $scope, Note, Person) {
        /* jshint validthis:true */
        var vm = this;

        vm.editPersonNotes = editPersonNotes;
        vm.addPersonNotes = addPersonNotes;
        vm.deletePersonNotes = deletePersonNotes;

        function loadPersonNotes() {
            Person.notes($scope.personId).then(function(response) {
                $scope.notes = response.data;
                $log.info("Loading PersonNotes ");
            }, function(response) {
                $log.error("Failed to load PersonNotes");
            });
        }

        function openDialog(personNote) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/person-notes-editor/views/person-notes-editorDialog.html',
                controller: 'PersonNotesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    personNoteEntity: personNote
                }
            });

            modalInstance.result.then().finally(function() {
                loadPersonNotes();
            });
        }

        function editPersonNotes(personNoteId) {
            openDialog(function(Note) {
                return Note.get(personNoteId).then(function(response) {
                    return response.data;
                }, function(response) {
                    alert("failed to retrieve");
                });
            });
        }

        function addPersonNotes() {
            openDialog({
                personId: $scope.personId
            });
        }

        function deletePersonNotes(id) {
            $log.log('NotesEditorController::deletePersonNote called');
            if (id) {
                var msg = "Are you sure you want to delete this Person Note?";
                if (window.confirm(msg)) {
                    Note.delete(id).then(function(response) {
                        $log.info("II Note ($noteId) has been deleted");
                    }, function(response) {
                        $log.info("EE A problem occurred trying to delete Note ($noteId)");
                    }).finally(function() {
                        loadPersonNotes();
                    });
                }
            }
        }

    }

})();
