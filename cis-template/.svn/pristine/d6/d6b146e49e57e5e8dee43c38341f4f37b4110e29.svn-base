/**
 * This is the Student Alternative Uci Editor Controller
 * 
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 * 
 * @type Controller
 */

(function() {
    'use strict';
    angular
        .module('StudentAlternativeUciTableDirective')
        .controller('StudentAlternativeUciTableController', StudentAlternativeUciTableController);

    StudentAlternativeUciTableController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'StudentAlternativeUci'];

    function StudentAlternativeUciTableController($log, $scope, $state, $rootScope, $uibModal, StudentAlternativeUci) {
        /* jshint validthis:true */
        var vm = this;
        vm.dialog = {};
        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.studentAlternativeUcis = vm.studentAlternativeUcis ? vm.studentAlternativeUcis : [];

        vm.loadStudentAlternativeUci = loadStudentAlternativeUci;
        vm.addStudentAlternativeUci = addStudentAlternativeUci;
        vm.editStudentAlternativeUci = editStudentAlternativeUci;
        vm.deleteAlternativeUci = deleteAlternativeUci;

        /*
         * this.init = function(){ $log.info('II EntryQualifications Editor
         * Initialised'); this.loadStudentAlternativeUci(this.studentId); };
         */
        // Private Interface

        function loadStudentAlternativeUci(studentId) {
            $log.debug('Loading StudentAlternativeUci Table');
            StudentAlternativeUci.getByStudent(studentId).then(function(response) {
                $log.debug('Student Alternative UCI Loaded');
                vm.studentAlternativeUcis = response.data;
            }, function(response) {
                $log.error('Error Student Alternative Ucis could not be loaded');
            });
        }

        function addStudentAlternativeUci(studentId) {
            $log.debug('StudentAlternativeUciTableController: addStudentAlternativeUci called: student Id--' + studentId);
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-alternative-uci-table-editor/views/student-alternative-ucis-editor-dialog-add.html',
                controller: 'StudentAlternativeUciEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentAlternativeUciEntity: function() {
                        var StudentAlternativeUci = {};
                        StudentAlternativeUci.studentId = studentId;
                        return StudentAlternativeUci;
                    }
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadStudentAlternativeUci(vm.studentId);
            });


        }


        /**
         * This methods is used to open the edit student alternative uci dialog
         * box
         * 
         * @param studentId
         * @param examBoardId
         */
        function editStudentAlternativeUci(alternativeUci) {

            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-alternative-uci-table-editor/views/student-alternative-ucis-editor-dialog-edit.html',
                controller: 'StudentAlternativeUciEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentAlternativeUciEntity: function() {
                        /* return StudentAlternativeUci.getByStudentAndExamBoardId(studentId,examBoardId).then(function(response) {
                         return response.data;
                         }, function(response) {
                             alert("failed to retrieve");
                         });*/

                        var StudentAlternativeUci = {};
                        StudentAlternativeUci = alternativeUci;
                        return StudentAlternativeUci;
                    }
                }
            });
            // Reload StudentALternativeUci after dialog closed
            modalInstance.result.then().finally(function() {
                vm.loadStudentAlternativeUci(vm.studentId);
            });
        }

        /**
         * This methods is used to delete the  student alternative uci dialog
         * box
         * 
         * @param studentId
         * @param examBoardId
         */
        function deleteAlternativeUci(studentId, examBoardId) {
            if (studentId, examBoardId) {
                var msg = "Are you sure you want to delete the Alternative UCI?";
                if (window.confirm(msg)) {
                    StudentAlternativeUci.delete(studentId, examBoardId).then(function(response) {
                        $log.info("II StudentAlternativeUci ($studentId)(examBoardId) has been deleted");
                    }, function(response) {
                        $log.info("EE A problem occurred trying to delete StudentAlternativeUci ($studentId)(examBoardId)");
                    }).finally(function() {
                        vm.loadStudentAlternativeUci(vm.studentId);
                    });

                }
            }
        }

    }

})();
