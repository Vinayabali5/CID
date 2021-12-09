(function() {
    'use strict';

    angular
        .module('CourseExamDirective')
        .controller('CourseExamDirectiveController', CourseExamDirectiveController);

    CourseExamDirectiveController.$inject = ["$rootScope", "$scope", "$http", "$uibModal", "CourseSyllabus", "CourseOption", "CourseComponent"];

    function CourseExamDirectiveController($rootScope, $scope, $http, $uibModal, CourseSyllabus, CourseOption, CourseComponent) {
        var vm = this;
        $scope.courseExamCheckBox = false;
        $scope.dataLevel = 0;
        console.log('CourseExamDirectiveController loaded');

        /**
         * Save courseOption data to the database
         */
        $rootScope.courseExamRecordToSave.courseOption.push(function(data) {
            if ($scope.dataLevel == 2 && $scope.courseExamCheckBox) {
                // save CourseOption record
                var courseOption = {};
                courseOption.courseId = $scope.course.id;
                courseOption.examOptionId = $scope.option.id;
                CourseOption.create(courseOption).finally(function() {
                    $rootScope.courseExamRecordSavedCounter++;
                });
            } else {
                $rootScope.courseExamRecordSavedCounter++;
            }
        });

        /**
         * Save courseSyllabus data to the database
         */
        $rootScope.courseExamRecordToSave.courseSyllabus.push(function(data) {
            if ($scope.dataLevel == 3 && $scope.courseExamCheckBox) {
                // save CourseSyllabus record
                var courseSyllabus = {};
                courseSyllabus.courseId = $scope.course.id;
                courseSyllabus.syllabusId = $scope.syllabus.id;
                CourseSyllabus.create(courseSyllabus);
            }
        });

        /**
         * Remove courseOption link record from the database
         */
        $rootScope.courseExamRecordToDelete.courseOption.push(function(data) {
            if ($scope.dataLevel == 2 && !$scope.courseExamCheckBox) {
                // delete CourseOption record
                CourseOption.delete($scope.course.id, $scope.option.id);
            }
        });

        /**
         * Remove courseSyllabus link record from the database
         */
        $rootScope.courseExamRecordToDelete.courseSyllabus.push(function(data) {
            if ($scope.dataLevel == 3 && !$scope.courseExamCheckBox) {
                // delete CourseSyllabus record
                CourseSyllabus.delete($scope.course.id, $scope.syllabus.id);
            }
        });

        /**
         * listener function to determine whether to check/uncheck checkbox
         */
        var courseExamCheckboxChangedTearDown = $rootScope.$on('course-exam-checkbox-changed', function(data, level, checkBoxVal, syllabusId, examOptionId) {
            // 3 - Syllabus    ->    Option    ->    Component - 1
            // Higher level unchecked, then uncheck lower level check boxes
            if (level > $scope.dataLevel && !checkBoxVal) {
                if ((examOptionId && $scope.option !== undefined && $scope.option.id == examOptionId) ||
                    ($scope.dataLevel == 3 && syllabusId == $scope.syllabus.id)) {
                    $scope.courseExamCheckBox = false;
                }
            }

            // Lower checked, then check higher level check boxes
            if (level < $scope.dataLevel && checkBoxVal) {
                if ((examOptionId && $scope.option !== undefined && $scope.option.id == examOptionId) ||
                    ($scope.dataLevel == 3 && syllabusId == $scope.syllabus.id)) {
                    $scope.courseExamCheckBox = true;
                }
            }
        });

        /**
         * listener function to remove all listener functions from the root scope listener
         */
        var courseExamTearDownTearDown = $rootScope.$on('course-exam-tear-down', function() {
            courseExamCheckboxChangedTearDown(); // Remove listener functions when saving or cancelling from window.
            courseExamTearDownTearDown();
        });

        /**
         * checkBoxChanged - The a function to broadcast a checkBoxChanged message to all directives
         */
        $scope.checkBoxChanged = function() {
            if ($scope.option === undefined) {
                $rootScope.$emit('course-exam-checkbox-changed', $scope.dataLevel, $scope.courseExamCheckBox, $scope.syllabus.id, 0);
            } else {
                $rootScope.$emit('course-exam-checkbox-changed', $scope.dataLevel, $scope.courseExamCheckBox, $scope.syllabus.id, $scope.option.id);
            }
        };

        /**
         * Scan through scope parents to locate the related data for this checkbox
         */
        $scope.locateData = function(callback) {
            $scope.curParent = $scope.$parent;
            while ($scope.curParent.$parent !== null) {
                if (callback($scope.curParent) !== undefined) {
                    return callback($scope.curParent);
                } else {
                    $scope.curParent = $scope.curParent.$parent;
                }
            }
        };

        /**
         * Initialise the data for this checkbox
         */
        $scope.init = function() {
            // Locate course data (if it exists)
            $scope.course = $scope.locateData(function(data) {
                return data.currentCourse;
            });

            // Locate syllabus data (if it exists)
            $scope.syllabus = $scope.locateData(function(data) {
                return data.syllabus;
            });

            // Locate option data (if it exists)
            $scope.option = $scope.locateData(function(data) {
                return data.option;
            });

            // Locate component data (if it exists)
            $scope.component = $scope.locateData(function(data) {
                return data.component;
            });

            if ($scope.course && $scope.course.id && $scope.option && $scope.option.id) {
                // This is Exam Option check box
                $scope.dataLevel = 2;
                CourseOption.get($scope.course.id, $scope.option.id).then(function(response) {
                    $scope.courseExamCheckBox = (response.status == 200 &&
                        response.data.courseId == $scope.course.id &&
                        response.data.examOptionId == $scope.option.id);
                });
            } else {
                if ($scope.course && $scope.course.id && $scope.syllabus && $scope.syllabus.id) {
                    // This is Exam Syllabus level (highest)
                    $scope.dataLevel = 3;
                    CourseSyllabus.get($scope.course.id, $scope.syllabus.id).then(function(response) {
                        $scope.courseExamCheckBox = (response.status == 200 &&
                            response.data.courseId == $scope.course.id &&
                            response.data.syllabusId == $scope.syllabus.id);
                    });
                }
            }

        };

        $scope.init();
    }
}());
