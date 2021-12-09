/**
 * This directive is used to display a table of ILP Interviews
 *
 * Applied Styles:
 *
 * @type Directive
 * @example <ilp-interviews-table ilp-interviews="{ilpInterviewArray}"></ilp-interviews-table>
 */
(function() {
    'use strict';

    angular
        .module('ILPInterviewsTableDirective', ['dialogs-edit-ilp'])
        .directive('ilpInterviewsTable', ilpInterviewsTable);

    function ilpInterviewsTable() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                showStaff: '=?',
                showCourse: '=?',
                showCourseGroup: '=?',
                showLip: '=?',
                showLetterHome: '=?',
                showTargets: '=?',
                showPrivate: '=?',
                showFilter: '=?',
                ilpInterviews: '=',
                filter: '=?'
            },
            templateUrl: 'js/directives/ilp-interviews-table/ilp-interviews-table.html',
            controller: ['$scope', 'Auth', function($scope, Auth) {
                $scope.systemFilter = $scope.filter || {};

                $scope.currentUser = Auth.getUser();

                // Setting default attribute values
                if (angular.isUndefined($scope.showCourse)) {
                    $scope.showCourse = true;
                }
                if (angular.isUndefined($scope.showStaff)) {
                    $scope.showStaff = true;
                }
                if (angular.isUndefined($scope.showLetterHome)) {
                    $scope.showLetterHome = true;
                }
                if (angular.isUndefined($scope.showPrivate)) {
                    $scope.showPrivate = false;
                }
                if (angular.isUndefined($scope.showFilter)) {
                    $scope.showFilter = true;
                }
                $scope.$watch('systemFilter._courseGroup._course.spec', function() {
                    if ($scope.systemFilter === undefined && $scope.systemFilter._courseGroup === undefined && $scope.systemFilter._courseGroup._course && $scope.systemFilter._courseGroup._course.spec === undefined && $scope.systemFilter._courseGroup._course.spec === "") {
                        $scope.systemFilter = {};
                    }
                });
                $scope.$watch('systemFilter._courseGroup._course._description', function() {
                    if ($scope.systemFilter === undefined && $scope.systemFilter._courseGroup === undefined && $scope.systemFilter._courseGroup._course === undefined && $scope.systemFilter._courseGroup._course._description === undefined && $scope.systemFilter._courseGroup._course._description === "") {
                        $scope.systemFilter = {};
                    }
                });
                $scope.$watch('systemFilter.interviewType', function() {
                    if ($scope.systemFilter.interviewType === null) {
                        $scope.systemFilter = {};
                    }
                });
                $scope.$watch('systemFilter._staffName', function() {
                    if ($scope.systemFilter._staffName === "") {
                        $scope.systemFilter = {};
                    }
                });
                $scope.$watch('showPrivate', function() {
                    if ($scope.showPrivate === true) {
                        $scope.systemFilter.privateEntry = undefined;
                    } else {
                        $scope.systemFilter.privateEntry = false;
                    }
                });

            }]
        };
    }
})();
