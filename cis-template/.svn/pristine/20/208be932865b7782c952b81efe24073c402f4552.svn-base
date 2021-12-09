/**
 * This is the Enrolment Manager Directive Controller.
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('EnrolmentManagerDirective')
        .controller('EnrolmentManagerDirectiveController', EnrolmentManagerDirectiveController);

    EnrolmentManagerDirectiveController.$inject = ['$log', '$scope', '$rootScope', '$http', '$uibModal'];

    function EnrolmentManagerDirectiveController($log, $scope, $rootScope, $http, $uibModal) {
        /* jshint validthis:true */
        var vm = this;

        vm.student = vm.student ? vm.student : {};
        vm.enrolments = vm.enrolments ? vm.enrolments : [];
        vm.init = init;
        vm.editEnrolments = editEnrolments;

        vm.init();

        function init() {
            $log.log('II EnrolmentEditorDirectiveController::init called');
        }

        function editEnrolments() {
            $log.log('II EnrolmentEditorDirectiveController::editEnrolments called');
            vm.modalInstance = $uibModal.open({
                templateUrl: 'js/directives/enrolment-manager/views/enrolment-manager-dialog.html',
                controller: 'EnrolmentManagerDialogDirectiveController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    enrolmentsList: [function() {
                        return vm.enrolments.filter(function(obj) {
                            return obj.endDate === null;
                        });
                    }],
                    studentEntity: [function() {
                        return vm.student;
                    }]
                }
            });
        }
    }
})();
