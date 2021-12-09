/**
 * The ExamSyllabusViewer module for viewing Syllabus basedata for an individual examBoard
 */
(function() {
    //
    angular
        .module('cid.exams.base-data-viewer')
        .controller('BaseDataViewerController', examBaseDataViewerController);

    examBaseDataViewerController.$inject = ['$scope', '$http', '$uibModal', 'entity', 'Syllabus'];

    function examBaseDataViewerController($scope, $http, $uibModal, entity, Syllabus) {
        console.log('base-data-viewer Controller Loaded');
        var vm = this;
        if (entity.data !== undefined) {
            vm.curExamBoard = entity.data.id;
        }
        vm.filterParams = {
            examSeries: {
                examSeries: '',
                examYear: '',
            },
            code: '',
            title: '',
        };

        vm.add = add;
        vm.edit = edit;
        vm.viewStudents = viewStudents;

        //////////////////////////////////////////////////////////////////////////////////////

        function add(syllabusData, optionData, componentData) {
            if (optionData) {
                // It may seem strange that we're calling addComponent if we have optionData, but this is
                // because we're adding a NEW component to the specified option
                addComponent(optionData);
            } else {
                if (syllabusData) {
                    // It may seem strange that we're calling addOption if we have syllabusData, but this is
                    // because we're adding a NEW option to the specified syllabus
                    addOption(syllabusData);
                } else {
                    // No data passed, so we're adding a NEW syllabus.
                    addSyllabus();
                }
            }
        }

        function addComponent(optionData) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/modules/exams/exam-base-data-viewer/views/exam-base-data-component-editDialog.html',
                controller: 'ExamBaseDataComponentEditDialogController',
                controllerAs: 'ctrl',
                resolve: {
                    entity: {
                        option: optionData
                    }
                }
            });
        }

        function addOption(syllabusData) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/modules/exams/exam-base-data-viewer/views/exam-base-data-option-editDialog.html',
                controller: 'ExamBaseDataOptionEditDialogController',
                controllerAs: 'ctrl',
                resolve: {
                    entity: {
                        syllabus: syllabusData
                    }
                }
            });
        }

        function addSyllabus(syllabusData) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/modules/exams/exam-base-data-viewer/views/exam-base-data-syllabus-editDialog.html',
                controller: 'ExamBaseDataSyllabusEditDialogController',
                controllerAs: 'ctrl',
                resolve: {
                    entity: {}
                }
            });
        }

        function edit(syllabusData, optionData, componentData) {
            if (componentData) {
                editComponent(optionData, componentData);
            } else {
                if (optionData) {
                    editOption(syllabusData, optionData);
                } else {
                    if (syllabusData) {
                        editSyllabus(syllabusData);
                    } else {
                        // No data passed, must be an error as we should have data.
                    }
                }
            }
        }

        function editComponent(optionData, componentData) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/modules/exams/exam-base-data-viewer/views/exam-base-data-component-editDialog.html',
                controller: 'ExamBaseDataComponentEditDialogController',
                controllerAs: 'ctrl',
                resolve: {
                    entity: {
                        option: optionData,
                        component: componentData
                    }
                }
            });
        }

        function editOption(syllabusData, optionData) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/modules/exams/exam-base-data-viewer/views/exam-base-data-option-editDialog.html',
                controller: 'ExamBaseDataOptionEditDialogController',
                controllerAs: 'ctrl',
                resolve: {
                    entity: {
                        option: optionData,
                        syllabus: syllabusData
                    }
                }
            });
        }

        function editSyllabus(syllabusData) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/modules/exams/exam-base-data-viewer/views/exam-base-data-syllabus-editDialog.html',
                controller: 'ExamBaseDataSyllabusEditDialogController',
                controllerAs: 'ctrl',
                resolve: {
                    entity: {
                        syllabus: syllabusData
                    }
                }
            });
        }

        function viewStudents(syllabusData, optionData, componentData) {
            console.log($scope);
            console.log(vm);
            var modalInstance = $uibModal.open({
                templateUrl: 'js/modules/exams/exam-base-data-viewer/views/exam-base-data-student-viewer.html',
                controller: 'BaseDataStudentViewerController',
                controllerAs: 'ctrl',
                resolve: {
                    entity: {
                        //
                    }
                }
            });
        }
    }
})();
