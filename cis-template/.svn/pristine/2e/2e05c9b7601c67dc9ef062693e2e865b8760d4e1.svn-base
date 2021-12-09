/**
 * This is the Roles Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('RolesEditorDirective')
        .controller('RolesEditorController', RolesEditorController);

    RolesEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'Role'];

    function RolesEditorController($log, $scope, $state, $rootScope, $uibModal, Role) {
        /* jshint validthis:true */
        var vm = this;

        vm.editRoles = editRoles;
        vm.addRoles = addRoles;

        function loadRoles() {
            Role.query().then(function(response) {
                $scope.roles = response.data;
                $log.info("Loading Exam Results");
            }, function(response) {
                $log.error("Failed to load Results");
            });
        }

        function editRoles(roleId) {
            $log.log("RoleEditorController :: editRoles called");
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/roles-editor/views/roles-editorDialog.html',
                controller: 'RolesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    roleEntity: function(Role) {
                        return Role.get(roleId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadRoles();
            });
        }


        function addRoles() {
            $log.log("RoleEditorController :: addRoles called");
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/roles-editor/views/roles-editorDialog.html',
                controller: 'RolesEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    roleEntity: function() {
                        var roles = {};
                        return roles;
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadRoles();
            });
        }

    }

})();
