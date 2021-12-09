/**
 * This file defines the route configuration for the student records section of the CID system.
 *
 */
(function() {
    'use strict';

    angular.module('cid.student-record').config(studentRecordRouteConfiguration);

    studentRecordRouteConfiguration.$inject = ['$stateProvider'];

    function studentRecordRouteConfiguration($stateProvider) {
        $stateProvider
            .state('student-editor', {
                parent: 'site',
                url: '/student-record',
                data: {
                    roles: ['ROLE_Staff', 'ROLE_Office Administration', 'ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/studentEditor/views/layout.html',
                    },
                    "content.search@": {
                        templateUrl: 'js/modules/studentEditor/views/search.html',
                        controller: 'StudentRecordSearchController',
                        controllerAs: 'ctrl'
                    },
                },
            })
            .state('student-editor.edit', {
                url: '/{studentId}?tab',
                views: {
                    "student-editor": {
                        templateUrl: 'js/modules/studentEditor/views/studentRecord.html',
                        controller: 'StudentEditorController',
                        controllerAs: 'ctrl',
                    },
                },
                resolve: {
                    studentEntity: ['$stateParams', 'Student', function($stateParams, Student) {
                        return Student.get($stateParams.studentId);
                    }]
                }
            })
            .state('student-editor.edit.bursary', {
                url: '/{studentId}/edit-bursary',
                onEnter: function($log, $stateParams, $state, $uibModal, Student) {
                    $log.log("II - Trying to EDIT BURSARY");
                    $uibModal.open({
                        templateUrl: 'js/modules/studentEditor/views/dialogs/studentBursaryEditorDialog.html',
                        controller: ['$log', '$scope', '$state', '$uibModalInstance', '$uibModal', '$rootScope', 'studentBursaryEntity', 'StudentBursary',
                            function($log, $scope, $state, $uibModalInstance, $uibModal, $rootScope, studentBursaryEntity, StudentBursary) {
                                var vm = this;

                                this.studentBursary = studentBursaryEntity !== undefined ? studentBursaryEntity : {};

                                var onSaveFinished = function(result) {
                                    $log.info('II Student Bursary Saved');
                                    $scope.$emit('student-bursary-saved', result);
                                    $uibModalInstance.close(result);
                                };

                                /**
                                 * This saves the studentBursary and closes that dialog box
                                 */
                                this.save = function() {
                                    $log.log('StudentBursaryDialogController::save called');
                                    $log.info(vm.studentBursary);
                                    if (vm.studentBursary) {
                                        StudentBursary.save(vm.studentBursary, onSaveFinished);
                                    } else {
                                        return null;
                                    }

                                };

                                /**
                                 * This closes the studentBursary editor dialog box without saving
                                 */
                                this.cancel = function() {
                                    $log.log('StudentBursaryDialogController::clear called');
                                    $uibModalInstance.dismiss('cancel');
                                };

                            }
                        ],
                        controllerAs: 'ctrl',
                        size: 'lg',
                        resolve: {
                            studentBursaryEntity: function(Student) {
                                return Student.bursary($stateParams.studentId).then(function(response) {
                                    return response.data;
                                }, function(response) {
                                    alert("failed to retrieve");
                                });
                            }
                        },
                    });
                },
            });
    }

})();
