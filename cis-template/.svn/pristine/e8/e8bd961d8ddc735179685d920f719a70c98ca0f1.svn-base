(function() {
    'use strict';

    angular
        .module('dialogs-edit-course-group', ['ui-notification', 'cid.service.logger', 'CourseGroupService'])
        .directive('editCourseGroup', editCourseGroupDirective);

    editCourseGroupDirective.$inject = ['Logger', '$uibModal', 'Auth', 'APP', 'CourseGroup'];

    function editCourseGroupDirective(Logger, $uibModal, Auth, APP, CourseGroup) {

        // Public Interface

        var directive = {
            restrict: 'A',
            scope: {
                courseGroupId: '=editCourseGroup',
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
                    templateUrl: 'js/directives/dialogs/edit-course-group/edit-course-group-dialog.html',
                    controller: 'EditCourseGroupDirectiveController',
                    controllerAs: 'ctrl',
                    size: 'lg',
                    backdrop: 'static',
                    resolve: {
                        CourseGroupEntry: ['CourseGroup', function(CourseGroup) {
                            if ($scope.courseGroupId != undefined && $scope.courseGroupId != null) {
                                // Load data from the API
                                return CourseGroup.get($scope.courseGroupId);
                            }
                        }],
                        timetableList: ['CourseGroup', function(CourseGroup) {
                            return CourseGroup.timetables($scope.courseGroupId);
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
