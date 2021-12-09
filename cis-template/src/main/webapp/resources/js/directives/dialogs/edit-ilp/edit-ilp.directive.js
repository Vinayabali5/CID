(function() {
    'use strict';

    angular
        .module('dialogs-edit-ilp', [
            'ui-notification',
            'ui.bootstrap.tabs',
            'frapontillo.bootstrap-duallistbox',
            'ui.tinymce',
            'cid.service.logger',
            'ILPInterviewService',
            'StatementBankService',
            'StudentService',
            'StudentRelatedStaffService',
        ])
        .directive('editIlp', editIlpDirective);

    editIlpDirective.$inject = ['Logger', '$uibModal', 'Auth', 'APP', 'ILPInterviewType'];

    function editIlpDirective(Logger, $uibModal, Auth, APP, ILPInterviewType) {

        // Public Interface

        var directive = {
            restrict: 'A',
            scope: {
                ilpInterviewId: '=',
                studentId: '=',
                interviewTypeId: '=',
                courseGroupId: '=',
                callbackFn: '=callback',
                callbackFailFn: '=callbackFail'
            },
            link: linkFunction,
        };

        return directive;

        // Private Interface

        function linkFunction($scope, elem, attr) {
            elem.bind('click', function() {
                var modalInstance = $uibModal.open({
                    animation: true,
                    templateUrl: 'js/directives/dialogs/edit-ilp/dialog.html',
                    controller: 'EditILPDirectiveController',
                    controllerAs: 'ctrl',
                    size: 'lg',
                    backdrop: 'static',
                    resolve: {
                        ILPInterviewEntry: ['ILPInterview', function(ILPInterview) {
                            if ($scope.ilpInterviewId != undefined && $scope.ilpInterviewId != null) {
                                // Load data from the API
                                return ILPInterview.getById($scope.ilpInterviewId);
                            } else {
                                if ($scope.studentId != undefined && $scope.studentId != null) {
                                    if ($scope.courseGroupId !== null && $scope.courseGroupId !== undefined) {

                                    }
                                    // Create new entry data
                                    return {
                                        data: {
                                            academicYearId: APP.getYear().id,
                                            staffId: Auth.getUser().staffId,
                                            studentId: $scope.studentId,
                                            interviewTypeId: $scope.interviewTypeId,
                                            courseGroupId: $scope.courseGroupId !== null && $scope.courseGroupId !== undefined ? $scope.courseGroupId : null,
                                            typeId: $scope.courseGroupId !== null && $scope.courseGroupId !== undefined ? 1 : null,
                                            interviewType: $scope.courseGroupId !== null && $scope.courseGroupId !== undefined ? {
                                                id: 1,
                                                type: "Subject Interview",
                                                requireCourseGroupId: true,
                                                allowLipReferral: true,
                                                requireTarget: true,
                                            } : $scope.interviewTypeId !== null && $scope.interviewTypeId !== undefined ? {
                                                id: $scope.interviewTypeId
                                            } : null,
                                            interviewDate: new Date(),
                                            discussion: '',
                                            target: '',
                                            referLip: false
                                        }
                                    };
                                } else {
                                    return null;
                                }
                            }
                        }],
                        StudentData: ['Student', function(Student) {
                            if ($scope.studentId != undefined && $scope.studentId != null) {
                                return Student.get($scope.studentId);
                            } else {
                                return null;
                            }
                        }],
                        StudentCourseGroups: ['Student', function(Student) {
                            if ($scope.studentId != undefined && $scope.studentId != null) {
                                return Student.courseGroups($scope.studentId);
                            } else {
                                return null;
                            }
                        }],
                        StatementBankData: ['StatementBank', function(StatementBank) {
                            return StatementBank.query();
                        }],
                    }
                });
                modalInstance.result.then(function() {
                    if ($scope.callbackFn) {
                        $scope.callbackFn();
                    }
                }, function() {
                    if ($scope.callbackFailFn) {
                        $scope.callbackFailFn();
                    }
                });
            });
        }

    }

}());
