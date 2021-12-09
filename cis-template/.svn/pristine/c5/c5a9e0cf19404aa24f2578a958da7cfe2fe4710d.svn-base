/**
 * This file defines the staff data module for the CID system
 */
(function() {
    'use strict';

    angular
        .module('cid.staff-data.personal-data')
        .controller('StaffPersonalDataController', StaffPersonalDataController);

    StaffPersonalDataController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'Auth', 'staffEntity', 'Staff'];

    function StaffPersonalDataController($log, $scope, $state, $rootScope, $uibModal, Auth, staffEntity, Staff) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface - Variables
        $scope.staffDetails = staffEntity != null ? staffEntity.data : {};

        // Public Interface - Methods
        $scope.editStaffData = editStaffData;

        // Event Listener
        $scope.$on('$destroy', $rootScope.$on('staff-saved', function(data) {
            Staff.get($scope.staffDetails.id).then(function(response) {
                $scope.staffDetails = response.data;
            });
        }));

        /**
         * This function is used to edit the staff personal details
         */
        function editStaffData(staffId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/modules/staff-data/personal-data/views/personal-data-editor.html',
                controller: 'PersonalDataEditorController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    staffEntity: ['Staff', function(Staff) {
                        return Staff.get(staffId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });
        }
    }
})();
