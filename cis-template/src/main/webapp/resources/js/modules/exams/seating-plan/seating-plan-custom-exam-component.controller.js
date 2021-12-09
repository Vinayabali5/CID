/**
 * The seatingPlanGenerator
 */
(function() {
    'use strict';
    //
    angular.module('cid.exams.seating-plan').controller(
        'SeatingPlanCustomExamComponentController', ["$uibModal", "$uibModalInstance", "$state", "$scope", "$q", "ExamBoard", "ExamSeries", "Syllabus", "Component",
            "Option", "OptionComponent", "CourseSyllabus", "CourseComponent", "CourseOption", "StudentOptionEntry", "Course", "entity", "APP",
            function($uibModal, $uibModalInstance, $state, $scope, $q, ExamBoard, ExamSeries, Syllabus, Component, Option, OptionComponent, CourseSyllabus, CourseComponent, CourseOption, StudentOptionEntry, Course, entity, APP) {
                /*jshint validthis: true */
                var vm = this;

                vm.cancel = cancel;

                vm.academicYear = APP.getYear();
                vm.customExam = {
                    examCode: "",
                    examTitle: "",
                    standardSyllabusCode: true,
                    syllabusCode: "INT" + vm.academicYear.id,
                    syllabusTitle: "Internal exams " + vm.academicYear.description,
                    courseId: null,
                    courseCode: "",
                    courseTitle: "Not selected",
                    timeAllowed: "",
                };
                vm.loadCourse = loadCourse;
                vm.save = save;
                vm.timetableDate = null;
                vm.timetableSession = null;

                ////////////////////////////

                console.log('SeatingPlanCustomExamComponentController Loaded');
                init();

                /**
                 * This function closes the window without saving anything.
                 * 
                 * @memberOf ctrl
                 */
                function cancel() {
                    $uibModalInstance.dismiss();
                }

                /**
                 * This function initialises the settings for the window
                 * 
                 * @memberOf ctrl
                 */
                function init() {
                    vm.timetableDate = entity.timetableDate;
                    vm.timetableSession = entity.timetableSession;
                }

                /**
                 * This function looks up a course
                 * 
                 * @memberOf ctrl
                 */
                function loadCourse(id) {
                    console.log('Loading course: ' + id);
                    Course.get(id).then(function(response) {
                        vm.customExam.courseId = response.data.id;
                        vm.customExam.courseCode = response.data.spec;
                        vm.customExam.courseTitle = response.data._levelDescription + ' ' + response.data._subjectDescription;
                    });
                }



                /**
                 * This function loads the selected exam series.
                 * 
                 * @memberOf ctrl
                 */
                function loadExamSeries() {
                    ExamSeries.get(vm.customExam.examSeriesId).then(function(response) {
                        var examSeries = response.data;
                        loadSaveExamSyllabus(examSeries);
                    }, function(response) {
                        // error when querying Exam Series
                        console.error("Error loading Exam Series.");
                        alert("Error loading selected Exam Series. Please contact MIS.");
                    });
                }

                /**
                 * This function check to see if the internal Syllabus for the current academic year exists.
                 * If it doesn't exist, it will attempt to create it.
                 * 
                 * @memberOf ctrl
                 */
                function loadSaveExamSyllabus(examSeries) {
                    var examSyllabus = {
                        examBoardId: examSeries.examBoard.id,
                        syllabusCode: (vm.collapseAdditional ? (vm.customExam.standardSyllabusCode ? vm.customExam.syllabusCode : vm.customExam.examCode) : vm.customExam.syllabusCode),
                        examYear: examSeries.examYear,
                        examSeries: examSeries.examSeries,
                    };
                    Syllabus.query(examSyllabus).then(function(response) {
                        var syllabus = {
                            id: null,
                        };
                        for (var i = 0; i < response.data.length; i++) {
                            if (response.data[i].examSeries.id === examSeries.id) {
                                syllabus = response.data[i];
                                break;
                            }
                        }
                        if (syllabus.id === null) {
                            // syllabus doesn't exist, so create it
                            syllabus = {
                                code: (vm.collapseAdditional ? (vm.customExam.standardSyllabusCode ? vm.customExam.syllabusCode : vm.customExam.examCode) : vm.customExam.syllabusCode),
                                title: (vm.collapseAdditional ? (vm.customExam.standardSyllabusTitle ? vm.customExam.syllabusTitle : vm.customExam.examCode) : vm.customExam.syllabusTitle),
                                examSeries: examSeries,
                            };
                            Syllabus.create(syllabus).then(function(response) {
                                syllabus = response;
                                saveCourseSyllabus(syllabus.id);
                                saveOption(syllabus);
                            }, function(response) {
                                console.log("Error creating Syllabus record");
                                alert("Error creating Syllabus record. Please contact MIS");
                            });
                        } else {
                            // syllabus exists - use it
                            saveCourseSyllabus(syllabus.id);
                            saveOption(syllabus);
                        }
                    }, function(response) {
                        // not found, so create it
                        console.error("Error querying Syllabus table.");
                        alert("Error querying Syllabus table. Please contact MIS.");
                    });
                }

                /**
                 * This function saves the entered details to the database
                 * 
                 * @memberOf ctrl
                 */
                function save() {
                    if (vm.customExam.courseId !== undefined && vm.customExam.courseId) {

                        vm.customExam.examOptionId = $q.defer();

                        // saving prerequesites:
                        // ExamBoard                          ( id: 100; identifier: 00 )
                        //  - ExamSeries                      ( Series: IN; Year: xxxx /academicYear.description/ )
                        //     - Syllabus                     ( code: INTxx /academicYear.id/ ; title: Internal exams xxxx /academicYear.description/)
                        //        - courseSyllabus
                        //        - examOption
                        //           - courseOption
                        //           - studentOptionEntry
                        //           - examComponent
                        //              - courseComponent
                        //              - optionComponent
                        loadExamSeries();

                        $uibModalInstance.close(vm.customExam);
                    } else {
                        alert("Please select a valid course.");
                    }
                }

                /**
                 * This function resolves the deferred examOptionId 
                 * 
                 * @memberOf ctrl
                 */
                function resolveExamOptionId(examOptionIdPromise, examOptionId) {
                    examOptionIdPromise.resolve(examOptionId);
                    return examOptionIdPromise.promise;
                }

                /**
                 * This function saves the course component to the database
                 * 
                 * @memberOf ctrl
                 */
                function saveComponent(examOption) {
                    var examComponent = {
                        code: (vm.collapseAdditional ? vm.customExam.examCode : vm.customExam.componentCode),
                        teacherMarks: "Y",
                        timeAllowed: vm.customExam.timeAllowed,
                        timetableDate: vm.timetableDate,
                        timetableSession: vm.timetableSession,
                        timetabled: "T",
                        title: (vm.collapseAdditional ? vm.customExam.examTitle : vm.customExam.optionTitle),
                        examSeries: examOption.syllabus.examSeries,
                    };
                    Component.create(examComponent).then(function(response) {
                        saveCourseComponent(examOption.examOptionId, response.id);
                        saveOptionComponent(examOption.examOptionId, response.id);
                    }, function(response) {
                        console.error("Error creating examComponent record");
                    });
                }

                /**
                 * This function saves the courseComponent record to the database
                 * 
                 * @memberOf ctrl
                 */
                function saveCourseComponent(examOptionId, examComponentId) {
                    var courseComponent = {
                        examComponentId: examComponentId,
                        courseOption: {
                            courseId: vm.customExam.courseId,
                            examOptionId: examOptionId,
                        },
                    };
                    CourseComponent.create(courseComponent).then(function(response) {
                        //
                    }, function(response) {
                        console.error("Error creating courseComponent record");
                    });
                }

                /**
                 * This function saves the course option to the database
                 * 
                 * @memberOf ctrl
                 */
                function saveCourseOption(examOptionId) {
                    //
                    var courseOption = {
                        courseId: vm.customExam.courseId,
                        examOptionId: examOptionId,
                    };
                    CourseOption.create(courseOption).then(function(response) {
                        //
                    }, function(response) {
                        console.error("Error creating courseOption record");
                    });
                }

                /**
                 * This function saves the course syllabus to the database
                 * 
                 * @memberOf ctrl
                 */
                function saveCourseSyllabus(syllabusId) {
                    //
                    var courseSyllabus = {
                        courseId: vm.customExam.courseId,
                        syllabusId: syllabusId,
                    };
                    CourseSyllabus.create(courseSyllabus).then(function(response) {
                        //
                    }, function(response) {
                        console.error("Error creating courseSyllabus record");
                    });
                }

                /**
                 * This function saves the exam option to the database.
                 * 
                 * @memberOf ctrl
                 */
                function saveOption(syllabus) {
                    var examOption = {

                        optionEntryCode: (vm.collapseAdditional ? vm.customExam.examCode : vm.customExam.optionCode),
                        optionTitle: (vm.collapseAdditional ? vm.customExam.examTitle : vm.customExam.optionTitle),
                        syllabus: syllabus,
                    };
                    Option.create(examOption).then(function(response) {
                        examOption = response;

                        resolveExamOptionId(vm.customExam.examOptionId, response.examOptionId).then(function(data) {
                            vm.customExam.examOptionId = data;
                        });

                        saveCourseOption(response.examOptionId);
                        saveComponent(response);
                    }, function(response) {
                        console.log("Error creating exam option record.");
                        alert("Error creaing exam option record. Please contact MIS");
                    });
                }

                /**
                 * This function saves the optionComponent record to the database
                 * 
                 * @param examOptionId
                 * @param examComponentId
                 * @returns
                 * 
                 * @memberOf ctrl
                 */
                function saveOptionComponent(examOptionId, examComponentId) {
                    var optionComponent = {
                        examOption: {
                            examOptionId: examOptionId,
                        },
                        examComponent: {
                            examComponentId: examComponentId,
                        },
                    };
                    OptionComponent.create(optionComponent).then(function(response) {
                        //
                    }, function(response) {
                        console.error("Error creating optionComponent");
                    });
                }
            }
        ]);
})();
