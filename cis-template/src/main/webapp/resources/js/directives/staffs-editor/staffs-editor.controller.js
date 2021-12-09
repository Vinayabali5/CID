/**
 * This is the Staffs Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StaffsEditorDirective')
        .controller('StaffsEditorController', StaffsEditorController);

    StaffsEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'Staff', 'Person'];

    function StaffsEditorController($log, $scope, $state, $rootScope, $uibModal, Staff, Person) {
        /* jshint validthis:true */
        var vm = this;

        vm.editStaffs = editStaffs;
        vm.addStaffs = addStaffs;

        function loadStaffs() {
            Staff.query().then(function(response) {
                $scope.staffList = response.data;
                $log.info("Loading Staffs");
            }, function(response) {
                $log.error("Failed to load Staffs");
            });
        }

        function editStaffs(staff) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/staffs-editor/views/staffs-editorDialog.html',
                controller: 'StaffsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    staffEntity: ['Staff', function(Staff) {
                        return Staff.get(staff.id).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }],
                    staffRoles: ['Person', function(Person) {
                        return Person.getRoles(staff.personId).then(function(response) {
                            return response.data;
                        });
                    }]
                }
            });

            modalInstance.result.then().finally(function() {
                loadStaffs();
            });
        }

        function addStaffs() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/staffs-editor/views/staffs-editorDialog.html',
                controller: 'StaffsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    staffEntity: function() {
                        var staffs = {};
                        return staffs;
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadStaffs();
            });
        }

    }

})();
