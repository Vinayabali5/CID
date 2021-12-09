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
        .module('CourseRequestEditorDirective')
        .controller('CourseRequestEditorController', CourseRequestEditorController);

    CourseRequestEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'Request'];

    function CourseRequestEditorController($log, $scope, $state, $rootScope, $uibModal, Request) {
        // Variables and Constants
        /* jshint validthis:true */
        var vm = this;
        vm.dialog = {};

        // Public Interface
        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.request = vm.request ? vm.request : [];

        vm.loadRequest = loadRequest;
        vm.addRequest = addRequest;
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

        $('#request').keypress(function(event) {
            if (event.which == 13) {
                vm.addRequest(vm.studentId);
                event.preventDefault();
            }
        });

        /**
         * This methods is used to open the add the new request to the table.
         */
        function addRequest(studentId) {
            $log.log('RequestEditorController::addContact called');
            var request = {};
            request.studentId = studentId;
            request.request = vm.request.request;
            Request.create(request).then(function(response) {
                vm.request = response.data;
            }, function(response) {
                alert("failed to retrieve");
            }).finally(function() {
                vm.loadRequest(vm.studentId);
            });
        }

        /** 
         * This method is used to delete the course request from the table
         */
        function deleteRequest(id) {
            $log.log('RequestEditorController::deleteRequest called');
            Request.delete(id).then(function(response) {
                $log.info("II Request ($studentId) has been deleted");
            }, function(response) {
                alert("failed to retrieve");
            }).finally(function() {
                vm.loadRequest(vm.studentId);
            });
        }

    }
})();
