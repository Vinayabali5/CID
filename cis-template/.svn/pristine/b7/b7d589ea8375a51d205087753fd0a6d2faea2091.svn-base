/**
 * This is the Course Exam Details Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('cid.exams.course-exam-details')
        .controller('CourseExamDetailsEditorController', CourseExamDetailsEditorController);

    CourseExamDetailsEditorController.$inject = ['$log', '$rootScope', '$scope', 'APP', '$state', '$uibModalInstance', 'Course', 'courseExamDetailsEntity', 'Syllabus', 'CourseOption'];

    function CourseExamDetailsEditorController($log, $rootScope, $scope, APP, $state, $uibModalInstance, Course, courseExamDetailsEntity, Syllabus, CourseOption) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface
        $scope.courseExamDetails = courseExamDetailsEntity;
        $scope.courseId = $scope.courseExamDetails.id;
        vm.loadSyllabusList = loadSyllabusList;
        $scope.save = save;
        $scope.cancel = cancel;
        $scope.refresh = refresh;
        $scope.init = init;

        init();

        // Event Listners
        $scope.$on('$destroy', $rootScope.$on('exam-syllabus-saved', loadSyllabusList(APP.getYear())));
        $rootScope.$on("current-year-changed", loadSyllabusList(APP.getYear()));

        // Private Interface
        function onSaveFinished(result) {
            $scope.$emit('course-saved', result);
            $uibModalInstance.close(result);
        }

        function init() {
            loadSyllabusList(APP.getYear());
        }
        /**
         * This refresh the Syllabus data.
         */
        function refresh() {
            $log.debug('CourseExamRecordEditorController::refresh called');
            loadSyllabusList(APP.getYear());
        }

        /**
         * This method is used to retrieve the syllabusList that match the syllabusCode.
         */
        function loadSyllabusList(year) {
            Syllabus.searchByYear(year, {
                syllabusCode: $scope.courseExamDetails.syllabusCode
            }).then(function(response) {
                $scope.syllabusList = response.data;
                if ($scope.syllabusList !== null) {
                    angular.forEach(response.data, function(syllabus) {
                        $scope.syllabusList.examOptions = syllabus.examOptions;
                        if ($scope.syllabusList.examOptions !== null) {
                            angular.forEach($scope.syllabusList.examOptions, function(examOption) {
                                $scope.syllabusList.examOptions.courseOption = examOption.courseOption;
                                if (examOption.courseOption !== null) {
                                    angular.forEach($scope.syllabusList.examOptions.courseOption, function(courseOption) {
                                        if (courseOption !== null && courseOption.courseId === $scope.courseId) {
                                            var option = {};
                                            $scope.syllabusList.examOptions.courseOption.option = courseOption;
                                        } else {
                                            return null;
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
                return $scope.syllabusList;
            });
        }


        /**
         * This saves the Course exam and closes that dialog box
         */
        function save() {
            if ($scope.courseExamDetails) {
                Course.save($scope.courseExamDetails, onSaveFinished);
            }
            if ($scope.syllabusList) {
                angular.forEach($scope.syllabusList, function(syllabus) {
                    var option = {};
                    option = syllabus.examOptions;
                    if (option) {
                        var courseOption = {};
                        angular.forEach(option, function(option) {
                            courseOption = option.courseOption;
                            if (courseOption.option) {
                                courseOption.option.courseId = $scope.courseId;
                                courseOption.option.examOptionId = option.id;
                                courseOption.option.lowerEntry = courseOption.option.lowerEntry !== undefined ? courseOption.option.lowerEntry : false;
                                courseOption.option.upperEntry = courseOption.option.upperEntry !== undefined ? courseOption.option.upperEntry : false;
                                courseOption.option.intermediateEntry = courseOption.option.intermediateEntry !== undefined ? courseOption.option.intermediateEntry : false;
                                if (courseOption.option.lowerEntry === false && courseOption.option.upperEntry === false && courseOption.option.intermediateEntry === false) {
                                    CourseOption.deleteById(courseOption.option.courseId, courseOption.option.examOptionId, onSaveFinished);
                                } else {
                                    CourseOption.create(courseOption.option, onSaveFinished);
                                }
                            }
                        });
                    }
                });
            }

        }


        /**
         * This closes the course exam editor dialog box without saving
         */
        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

    }
}());
