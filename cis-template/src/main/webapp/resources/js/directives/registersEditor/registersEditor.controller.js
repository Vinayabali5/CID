/**
 * This is the Registers Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */



(function() {
    'use strict';

    angular
        .module('RegistersEditorDirective')
        .controller('RegistersEditorController', RegistersEditorController);

    RegistersEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'MasterRegister'];


    function RegistersEditorController($log, $scope, $state, $rootScope, $uibModal, MasterRegister) {
        /* jshint validthis:true */
        var vm = this;
        vm.registers = [];

        // Operations
        vm.loadRegisters = loadRegisters;
        vm.editRegister = editRegister;
        vm.addRegister = addRegister;
        vm.toggleVisibility = toggleVisibility;

        // Apply filters
        $scope.registerFilter = $scope.filter || {};

        $scope.$watch('registerFilter.attendanceId', function() {
            if ($scope.registerFilter.attendanceId === "") {
                $scope.registerFilter = {};
            }
        });


        /**
         * This method is used to open the register editor dialog box to allow users to edit a single register entry.
         *
         * @param  {object} registerEntity The register entry object to edit
         * @return {$uibModalInstance}     An instance of the $uibModalInstance
         */
        function openDialog(registerEntity) {
            return $uibModal.open({
                templateUrl: 'js/directives/registersEditor/views/registersEditorDialog.html',
                controller: 'RegistersEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    registerEntity: registerEntity
                }
            });
        }

        /**
         * This method is used to load the register entries for a given studentId.
         * Data retrieved is set in the vm.registers variable.
         *
         * @param  {int} studentId The studentId to use for the data retrieval
         */
        function loadRegisters(studentId) {
            $log.info('II Loading Registers Data');
            MasterRegister.get(studentId).then(function(response) {
                $log.info('II Registers Loaded');
                vm.registers = response.data;
            }, function(response) {
                $log.error('EE Registers could not be loaded');
            });
        }

        function editRegister(id) {
            $log.log('RegistersEditorController::editRegister called');

            var modalInstance = openDialog(['MasterRegister', function(MasterRegister) {
                return MasterRegister.getById(id).then(function(response) {
                    return response.data;
                }, function(response) {
                    alert("failed to retrieve");
                });
            }]);
        }

        function addRegister(studentId) {
            $log.log('RegistersEditorController::editRegister called');
            var modalInstance = openDialog({
                studentId: studentId
            });
        }

        function toggleVisibility() {
            vm.visible = !vm.visible;
        }

    }

})();
