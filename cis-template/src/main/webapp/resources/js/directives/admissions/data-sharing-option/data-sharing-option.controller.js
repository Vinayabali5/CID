/**
 * The DataSharingOptionEditorController is used to define the main controller for the DataSharingOptionEditorDirective.
 *
 * Applied Styles: [Y001, Y002, Y010, Y020, Y022, Y023, Y024, Y031, Y032, Y033, Y034, Y035, Y036, Y090, Y091]
 *
 * @type Controller
 */
(function() {
    'use strict';

    angular
        .module('DataSharingOptionDirective')
        .controller('DataSharingOptionEditorController', DataSharingOptionEditorController);

    DataSharingOptionEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'Student'];

    function DataSharingOptionEditorController($log, $scope, $state, $rootScope, $uibModal, Student) {
        // Variables and Constants
        /* jshint validthis:true */
        var vm = this;

        // Public Interface
        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.dataSharingOption = vm.dataSharingOption ? vm.dataSharingOption : [];


        vm.editDataSharingOption = editDataSharingOption;


        /**
         * This methods is used to open the edit data sharing Options
         *
         * @param  {Integer} id The ID of the student to be edited
         */
        function editDataSharingOption(studentId) {
            $log.log('DataSharingOptionEditorController::editDataSharingOption called');

            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/admissions/data-sharing-option/views/data-sharing-option-editorDialog.html',
                controller: 'DataSharingOptionEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    dataSharingOptionEntity: ['Student', function(Student) {
                        return Student.getDataSharingOption(studentId).then(function(response) {
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
