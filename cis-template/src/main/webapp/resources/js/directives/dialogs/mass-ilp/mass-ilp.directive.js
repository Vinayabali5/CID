(function() {
    'use strict';

    angular
        .module('dialogs-mass-ilp', [
            'ui-notification',
            'ui.bootstrap.tabs',
            'frapontillo.bootstrap-duallistbox',
            'cid.service.logger',
            'CourseGroupService',
            'MassILPInterviewService',
        ])
        .directive('massIlp', massILPInterviewDirective);

    massILPInterviewDirective.$inject = ['Logger', '$uibModal', 'Auth', 'APP', 'MassILPInterview', 'CourseGroup'];

    function massILPInterviewDirective(Logger, $uibModal, Auth, APP, MassILPInterview, CourseGroup) {

        // Public Interface

        var directive = {
            restrict: 'A',
            scope: {
                courseId: '=?',
                courseGroupId: '=?',
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
                    templateUrl: 'js/directives/dialogs/mass-ilp/mass-ilp.html',
                    controller: 'MassILPInterviewDirectiveController',
                    controllerAs: 'ctrl',
                    size: 'lg',
                    backdrop: 'static',
                    resolve: {
                        MassILPInterviews: ['MassILPInterview', function(MassILPInterview) {
                            return {
                                data: {
                                    courseId: $scope.courseId,
                                    courseGroupId: ($scope.courseId == undefined || $scope.courseId == null) ? $scope.courseGroupId : undefined,
                                    staffId: Auth.getUser().staffId,
                                    interviewType: $scope.courseGroupId !== null && $scope.courseGroupId !== undefined ? {
                                        id: 1,
                                        type: "Subject Interview",
                                        requireCourseGroupId: true,
                                        allowLipReferral: true
                                    } : null,
                                    interviewDate: new Date()
                                }
                            };
                        }],
                        Enrolments: ['Course', 'CourseGroup', function(Course, CourseGroup) {
                            if ($scope.courseId != undefined && $scope.courseId != null) {
                                Logger.log("Mass ILP Interview Using - Course ID");
                                return Course.enrolments($scope.courseId);
                            }
                            if ($scope.courseGroupId != undefined && $scope.courseGroupId != null) {
                                Logger.log("Mass ILP Interview Using - Course Group ID");
                                return CourseGroup.enrolments($scope.courseGroupId);
                            }
                            Logger.error("No Course ID or Course Group ID supplied.", true);
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
