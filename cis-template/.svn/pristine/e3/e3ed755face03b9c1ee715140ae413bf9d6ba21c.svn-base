(function() {
    'use strict';

    angular
        .module('dialogs-edit-course', ['ui-notification', 'cid.service.logger', 'CourseService'])
        .directive('editCourse', editCourseDirective);

    editCourseDirective.$inject = ['Logger', '$uibModal', 'Auth', 'APP', 'Course'];

    function editCourseDirective(Logger, $uibModal, Auth, APP, Course) {

        // Public Interface

        var directive = {
            restrict: 'A',
            scope: {
                courseId: '=editCourse',
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
                    templateUrl: 'js/directives/dialogs/edit-course/edit-course-dialog.html',
                    controller: 'EditCourseDirectiveController',
                    controllerAs: 'ctrl',
                    size: 'lg',
                    backdrop: 'static',
                    resolve: {
                        CourseEntry: ['Course', function(Course) {
                            if ($scope.courseId != undefined && $scope.courseId != null) {
                                // Load data from the API
                                return Course.get($scope.courseId);
                            }
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
