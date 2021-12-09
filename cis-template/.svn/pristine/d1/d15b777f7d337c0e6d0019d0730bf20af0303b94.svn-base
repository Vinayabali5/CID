/**
 * This is the Tutor Groups Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('TutorGroupsEditorDirective')
        .controller('TutorGroupsEditorController', TutorGroupsEditorController);

    TutorGroupsEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'TutorGroup'];

    function TutorGroupsEditorController($log, $scope, $state, $rootScope, $uibModal, TutorGroup) {
        /* jshint validthis:true */
        var vm = this;
        vm.tutorGroups = [];

        vm.editTutorGroups = editTutorGroups;
        vm.addTutorGroups = addTutorGroups;

        function editTutorGroups(tutorGroupId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/tutor-groups-editor/views/tutor-groups-editorDialog.html',
                controller: 'TutorGroupsEditorDialogController',
                controllerAs: 'ctrl',
                resolve: {
                    tutorGroupsEntity: function(TutorGroup) {
                        return TutorGroup.get(tutorGroupId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("Failed to retrieve");
                        });
                    }
                }
            });
        }

        function addTutorGroups() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/tutor-groups-editor/views/tutor-groups-editorDialog.html',
                controller: 'TutorGroupsEditorDialogController',
                controllerAs: 'ctrl',
                resolve: {
                    tutorGroupsEntity: function() {
                        var tutorGroups = {};
                        return tutorGroups;
                    }
                }
            });
        }

    }

})();
