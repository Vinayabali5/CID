(function() {
    'use strict';

    angular
        .module('dialogs-edit-interim-reports-due', ['ui-notification', 'cid.service.logger', 'CourseGroupService'])
        .directive('editInterimReportsDue', editInterimReportsDueDirective);

    editInterimReportsDueDirective.$inject = ['Logger', '$uibModal', 'Auth', 'APP', 'StudentInterimReport', 'InterimReportsDue'];

    function editInterimReportsDueDirective(Logger, $uibModal, Auth, APP, StudentInterimReport, InterimReportsDue) {

        // Public Interface

        var directive = {
            restrict: 'A',
            scope: {
                studentInterimReport: '=editInterimReportsDue',
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
                    templateUrl: 'js/directives/dialogs/edit-interim-reports-due/edit-interim-reports-due-dialog.html',
                    controller: 'EditInterimReportsDueDirectiveController',
                    controllerAs: 'ctrl',
                    size: 'xl',
                    backdrop: 'static',
                    resolve: {
                        studentInterimReportList: ['InterimReportsDue', function(InterimReportsDue) {
                            if ($scope.studentInterimReport != undefined && $scope.studentInterimReport != null) {
                                return InterimReportsDue.getByCourseGroupId($scope.studentInterimReport.courseGroupId);
                            }
                        }],
                        studentInterimReportEntity: $scope.studentInterimReport
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
