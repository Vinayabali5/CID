(function() {
    'use strict';

    angular
        .module('bulk-careers-record', [
            'ui-notification',
            'ui.bootstrap.tabs',
            'frapontillo.bootstrap-duallistbox',
            'cid.service.logger',
            'BulkCareersRecordService',
        ])
        .directive('bulkCareersRecord', massILPInterviewDirective);

    massILPInterviewDirective.$inject = ['Logger', '$uibModal', 'Auth', 'APP', 'BulkCareersRecord'];

    function massILPInterviewDirective(Logger, $uibModal, Auth, APP, BulkCareersRecord) {

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
                    templateUrl: 'js/directives/dialogs/bulk-careers-record/bulk-careers-record.html',
                    controller: 'BulkCareersRecordDirectiveController',
                    controllerAs: 'ctrl',
                    size: 'lg',
                    backdrop: 'static',
                    resolve: {
                        BulkCareersRecords: ['BulkCareersRecord', function(BulkCareersRecord) {
                            return {
                                data: {
                                    courseId: $scope.courseId,
                                    courseGroupId: ($scope.courseId == undefined || $scope.courseId == null) ? $scope.courseGroupId : undefined
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
