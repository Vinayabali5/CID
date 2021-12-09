/**
 * This is the ILP Interviews Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */



(function() {
    'use strict';

    angular
        .module('ILPInterviewsEditorDirective')
        .controller('ILPInterviewsEditorController', ILPInterviewsEditorController);

    ILPInterviewsEditorController.$inject = ['$log', '$scope', '$rootScope', '$uibModal', 'ILPInterview'];

    function ILPInterviewsEditorController($log, $scope, $rootScope, $uibModal, ILPInterview) {
        //Public Interface
        /* jshint validthis:true */
        var vm = this;
        vm.message = '';

        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.ilpInterviews = vm.ilpInterviews ? vm.ilpInterviews : [];

        //Operations
        //vm.init = init;
        vm.loadILPInterviews = loadILPInterviews;
        vm.addILPInterviews = addILPInterviews;

        // Private Interface

        function loadILPInterviews(studentId) {
            ILPInterview.getByStudentId(studentId).then(function(response) {
                $log.info('II ILPInterviews Loaded');
                vm.ilpInterviews = response.data;
            }, function(response) {
                $log.error('EE students could not be loaded');
            });
        }

        //update the ILPInterview information
        function addILPInterviews(studentId) {
            $log.log('ILPInterviewsDetailsDirectiveController::addContact called');
            //var ilpInterviewsId = id;
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/ilp-interviews-editor/views/ilp-interviews-editor-dialog.html',
                controller: 'ILPInterviewsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    ilpInterviewsEntity: function() {
                        var ilpInterview = {};
                        ilpInterview.studentId = studentId;
                        return ilpInterview;
                    }
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadILPInterviews(vm.studentId);
            });
        }
    }

})();
