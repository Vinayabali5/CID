/**
 * This is the PersonNote Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('PersonNotesEditorDirective')
        .controller('PersonNotesEditorDialogController', PersonNotesEditorDialogController);

    PersonNotesEditorDialogController.$inject = ['$log', '$rootScope', '$state', '$uibModalInstance', 'Note', 'personNoteEntity'];

    function PersonNotesEditorDialogController($log, $rootScope, $state, $uibModalInstance, Note, personNoteEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.note = personNoteEntity !== undefined ? personNoteEntity : {};

        vm.cancel = cancel;
        vm.save = save;

        var onSaveFinished = function(result) {
            $rootScope.$emit('student.notes.loaded', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.note.id !== undefined && vm.note.id !== null) {
                Note.save(vm.note, onSaveFinished);
            } else {
                Note.create(vm.note, onSaveFinished);
            }
        }

    }


})();
