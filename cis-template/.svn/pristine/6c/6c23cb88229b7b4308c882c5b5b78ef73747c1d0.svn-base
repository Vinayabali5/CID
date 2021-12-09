/**
 * This is the Letter Template Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('ILPLetterEditorDirective')
        .controller('ILPLetterEditorController', ILPLetterEditorController);

    ILPLetterEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'Letter', 'Auth', 'USER', 'APP'];

    function ILPLetterEditorController($log, $scope, $state, $rootScope, $uibModal, Letter, Auth, USER, APP) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface

        vm.letter = vm.letter ? letter : {};
        vm.pendingId = vm.letter.pendingId ? vm.letter.pendingId : undefined;
        vm.currentUser = Auth.getUser();
        vm.letter.pendingId = vm.currentUser.staffId;


        vm.editILPLetter = editILPLetter;
        vm.togglePending = togglePending;
        vm.deleteILPLetter = deleteILPLetter;
        vm.deleteILPEntry = deleteILPEntry;

        // Private Interface

        /**
         * This will update the ILP Letter with the currently logged in users staff Id as the Pending field.
         */
        function togglePending(ilpLetter) {
            if (ilpLetter.interview.letterSent === null) {
                ilpLetter.interview.letterSent = false;
            } else {
                ilpLetter.interview.letterSent = true;
            }
            if (ilpLetter.pendingId === undefined || ilpLetter.pendingId === null) {
                ilpLetter.pendingId = vm.currentUser.staffId;
            } else {
                ilpLetter.pendingId = null;
            }
            Letter.save(ilpLetter);
        }

        /**
         * This will delete the ilp letter only be enabled if the letter does not have a letter_date set
         */
        function deleteILPLetter(id) {
            $log.log('LettersEditorController::deleteLetter called');
            if (id) {
                var msg = "Are you sure you want to delete this Letter?";
                if (window.confirm(msg)) {
                    Letter.delete(id).then(function(response) {
                        $log.info("II Letter ($id) has been deleted");
                    }, function(response) {
                        $log.info("EE A problem occurred trying to delete letter ($id)");
                    });
                }
            }
        }

        /**
         * This will delete the ilp entry only be enabled if the letter does not have a letter_date set
         */
        function deleteILPEntry(id) {
            $log.log('LettersEditorController::deleteILPEntry called');
            if (id) {
                var msg = "Are you sure you want to delete this ILP Entry?";
                if (window.confirm(msg)) {
                    Letter.deleteILPEntry(id).then(function(response) {
                        $log.info("II ILP Entry ($id) has been deleted");
                    }, function(response) {
                        $log.info("EE A problem occurred trying to delete ILP Entry ($id)");
                    });
                }
            }
        }

        /**
         * This will open a dialog box which displays the details of the letter
         */
        function editILPLetter(id) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/ilp-letter-editor/views/ilp-letter-editor-dialog.html',
                size: 'xl',
                controller: 'ILPLetterEditorDialogController',
                controllerAs: 'ctrl',
                resolve: {
                    letterEntity: ['Letter', function(Letter) {
                        return Letter.get(id).then(function(response) {
                            if (response.data.interview.letterSent === null) {
                                response.data.interview.letterSent = false;
                            } else {
                                response.data.interview.letterSent = true;
                            }
                            return response.data;
                        }, function(response) {
                            alert("Failed to retrieve");
                        });
                    }]
                }
            });
        }


    }

})();
