/**
 * The RequestEditorController is used to define the main controller for the RequestEditorDirective.
 *
 * Applied Styles: [Y001, Y002, Y010, Y020, Y022, Y023, Y024, Y031, Y032, Y033, Y034, Y035, Y036, Y090, Y091]
 *
 * @type Controller
 */
(function() {
    'use strict';

    angular
        .module('RequestEditorDirective')
        .controller('RequestEditorController', RequestEditorController);

    RequestEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'Request'];

    function RequestEditorController($log, $scope, $state, $rootScope, $uibModal, Request) {
        // Variables and Constants
        /* jshint validthis:true */
        var vm = this;
        vm.dialog = {};

        // Public Interface
        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.request = vm.request ? vm.request : [];

        vm.loadRequest = loadRequest;
        vm.addRequest = addRequest;
        vm.editRequest = editRequest;
        vm.deleteRequest = deleteRequest;

        // Private Interface

        /**
         * This method is used to load the Requests for a specified studentId
         *
         * @param  {Integer} studentId The ID of the student
         */
        function loadRequest(studentId) {
            $log.info('II Loading Request Data');
            Request.getByStudentId(studentId).then(function(response) {
                $log.info('II Request Loaded');
                vm.request = response.data;
            }, function(response) {
                $log.error('EE Request could not be loaded');
            });
        }

        /**
         * This methods is used to open the add new college fund payments dialog box
         *
         * @param {Integer} studentId The ID of the student
         */
        function addRequest(studentId) {
            $log.log('RequestEditorController::addContact called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/admissions/request-editor/views/request-editor-dialog.html',
                controller: 'RequestEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    requestEntity: function() {
                        var request = {};
                        request.studentId = studentId;
                        return request;
                    }
                }
            });
            // Reload Request after dialog closed
            modalInstance.result.then().finally(function() {
                vm.loadRequest(vm.studentId);
            });
        }

        function deleteRequest(id) {
            $log.log('RequestEditorController::deleteRequest called');
            if (id) {
                var msg = "Are you sure you want to delete this Request?";
                if (window.confirm(msg)) {
                    Request.delete(id).then(function(response) {
                        $log.info("II Request ($studentId) has been deleted");
                    }, function(response) {
                        $log.info("EE A problem occurred trying to delete Request ($studentId)");
                    }).finally(function() {
                        vm.loadRequest(vm.studentId);
                    });
                }
            }
        }

        /**
         * This methods is used to open the edit college fund payment dialog box
         *
         * @param  {Integer} id The ID of the college fund payment to be edited
         */
        function editRequest(id) {
            $log.log('RequestEditorController::editContact called');

            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/admissions/request-editor/views/request-editor-dialog.html',
                controller: 'RequestEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    requestEntity: function(Contact) {
                        return Request.get(id).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });
            // Reload Request after dialog closed
            modalInstance.result.then().finally(function() {
                vm.loadRequest(vm.studentId);
            });
        }
    }
})();
