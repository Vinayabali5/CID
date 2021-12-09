(function() {
    'use strict';

    angular
        .module('StudentCollegeFundPaidDirective')
        .controller('StudentCollegeFundPaidController', StudentCollegeFundPaidController);


    StudentCollegeFundPaidController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'StudentCollegeFundPaid'];


    function StudentCollegeFundPaidController($log, $scope, $state, $rootScope, $uibModal, StudentCollegeFundPaid) {
        /* jshint validthis:true */
        var vm = this;
        var studentId = vm.studentId;
        vm.studentCollegeFundPaid = vm.studentCollegeFundPaid ? vm.studentCollegeFundPaid : [];

        vm.editCollegeFundPaid = editCollegeFundPaid;


        // Opens an $uibModal instance on click of Edit Button
        function editCollegeFundPaid(studentId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/admissions/student-college-fund-paid/views/student-college-fund-paid-editorDialog.html',
                controller: 'StudentCollegeFundPaidEditorController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    collegeFundEntity: function(StudentCollegeFundPaid) {
                        return StudentCollegeFundPaid.get(studentId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("Failed to retrive");
                        });
                    }
                }

            });
        }


    }


})();
