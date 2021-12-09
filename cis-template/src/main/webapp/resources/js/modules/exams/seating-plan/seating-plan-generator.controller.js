/**
 * The seatingPlanGenerator
 */
(function() {


    angular
        .module('cid.exams.seating-plan')
        .controller('SeatingPlanGeneratorController', SeatingPlanGeneratorController);

    SeatingPlanGeneratorController.$inject = ["$scope", "$uibModal", "$state", "$filter", "Component", "SeatingPlan", "entity"];

    function SeatingPlanGeneratorController($scope, $uibModal, $state, $filter, Component, SeatingPlan, entity) {
        var vm = this;

        $scope.advancedFilter = advancedFilter;
        $scope.addCustomExamComponent = addCustomExamComponent;
        $scope.autoPopulateSeatingPlan = autoPopulateSeatingPlan;
        $scope.blankStudent = {
            studentId: null,
            examComponentId: null,
            row: null,
            col: null,
            label: null,
        };
        $scope.bulkClearSeatsSettings = bulkClearSeatsSettings;
        $scope.cancel = cancel;
        $scope.changeStudentSettings = changeStudentSettings;
        $scope.clearSeat = clearSeat;
        $scope.displayOptions = {
            roomDescription: true,
            studentConcessions: true,
        };
        $scope.examComponents = [];
        $scope.examComponentsLoaded = 0;
        $scope.examRoom = null;
        $scope.filterOptions = {
            hideAssigned: false,
            showOnlyConcessions: false,
            showOnlyClashes: false,
        };
        $scope.listCanceled = listCanceled;
        $scope.listDragEnd = listDragEnd;
        $scope.listDragStart = listDragStart;
        $scope.listDrop = listDrop;
        $scope.listFilter = {
            examComponentId: "",
            _candidateNo: "",
            _surname: "",
            _firstName: "",
        };
        $scope.listMoveTo = listMoveTo;
        $scope.lists = null;
        $scope.numColumns = null;
        $scope.numRows = null;
        $scope.planCanceled = planCanceled;
        $scope.planDrop = planDrop;
        $scope.saveAndCloseExamRoom = saveAndCloseExamRoom;
        $scope.saveExamRoom = saveExamRoom;
        $scope.sortOptions = [{
                title: 'Exam Component - Candidate No',
                sortOrder: ['+_examComponentTitle', '+_candidateNo']
            },
            {
                title: 'Exam Component - Surname, First Name',
                sortOrder: ['+_examComponentTitle', '+_surname', '+_firstName']
            }
        ];
        $scope.sortOrder = ['+_examComponentTitle', '+_candidateNo'];
        $scope.sourceStudent = null;
        $scope.students = [];
        $scope.studentsLoaded = false;

        // //////////////////////////////////////////////////////////////

        console.log('SeatingPlanGeneratorController Loaded');
        init();

        /**
         * Advanced filter determines whether to display a student in the student list based on
         * filtering options such as whether or not the student is assigned a seat, whether or
         * not they have a concession, or whether or not they have a clash of exams.
         */
        function advancedFilter(item) {
            return assignedFilter(item) && concessionsFilter(item) && clashesFilter(item);
        }

        /**
         * This function opens a dialog window to allow custom or internal
         * exam Components to be created
         */
        function addCustomExamComponent() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/modules/exams/seating-plan/views/seating-plan-custom-exam-component.html',
                controller: 'SeatingPlanCustomExamComponentController',
                controllerAs: 'ctrl',
                size: 'lg',
                backdrop: 'static',
                keyboard: false,
                resolve: {
                    entity: function() {
                        return {
                            timetableDate: $scope.examRoom.examSession.date,
                            timetableSession: $scope.examRoom.examSession.session,
                        };
                    }
                },
            }).result.then(customExamSelectStudents, function(result) {
                console.log(result);
            });
        }

        /**
         * This function filters out students who have been assigned a seat if the hideAssigned flag is set.
         *
         * @param {object} item - The student item to test
         * @return {boolean} true if should be included or false if should be filtered out.
         */
        function assignedFilter(item) {
            return (($scope.filterOptions.hideAssigned && item.label === null) || !$scope.filterOptions.hideAssigned);
        }

        /**
         * This function sets the seat details within the students
         * array.
         *
         * @param {integer}
         *            The index within the students list.
         * @param {integer}
         *            The row that the student is assigned to.
         * @param {integer}
         *            The column that the student is assigned to.
         * @param {integer}
         *            The exam room id that the student is assigned to.
         */
        function assignSeatToStudent(index, row, col, examRoomId) {
            if (row === null || col === null) {
                $scope.students[index].label = null;
            } else {
                $scope.students[index].label = seatLabel(row, col);
            }
            $scope.students[index].row = row;
            $scope.students[index].col = col;
            $scope.students[index].changed = true;
            $scope.students[index].examRoomId = examRoomId;
            $scope.students[index].examSeatingPlanId = examRoomId;
        }

        /**
         * This function opens the dialog window with the auto populate
         * settings, before calling the auto populate function.
         */
        function autoPopulateSeatingPlan() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/modules/exams/seating-plan/views/seating-plan-auto-generate-settings.html',
                controller: 'SeatingPlanAutoGenerateController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    entity: [function() {
                        return {
                            numCols: $scope.numColumns,
                            numRows: $scope.numRows
                        };
                    }]
                }
            }).result.then(populateSeats, function() {});
        }

        /**
         * This function clears all seats within a specified range.
         *
         * @param {object}
         *            The options selected in the settings dialog
         *            window.
         */
        function bulkClearSeats(result) {
            for (r = result.startRow - 1; r <= result.endRow - 1; r++) {
                for (c = result.startCol.index; c <= result.endCol.index; c++) {
                    if ($scope.lists.rows[r].columns[c].student[0].studentId !== null) {
                        studentIndex = $scope.lists.rows[r].columns[c].student[0].listIndex;
                        $scope.lists.rows[r].columns[c].student[0] = $scope.blankStudent;
                        assignSeatToStudent(studentIndex, null, null, null);
                    }
                }
            }
        }

        /**
         * This function opens a dialog window to allow settings to be
         * specified for bulk clearing of seats
         */
        function bulkClearSeatsSettings() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/modules/exams/seating-plan/views/seating-plan-bulk-clear-seats-settings.html',
                controller: 'SeatingPlanBulkClearSeatsController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    entity: function() {
                        return {
                            numCols: $scope.numColumns,
                            numRows: $scope.numRows
                        };
                    }
                }
            }).result.then(bulkClearSeats, function() {});
        }

        /**
         * This function handles the Cancel button being pressed.
         *
         * @returns
         */
        function cancel() {
            $state.go('^');
        }

        /**
         * This function opens a dialog window to allow student list
         * options to be specified (currently empty)
         */
        function changeStudentSettings() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/modules/exams/seating-plan/views/seating-plan-student-settings.html',
                controller: 'SeatingPlanStudentSettingsController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    entity: [function() {
                        return {
                            filterOptions: $scope.filterOptions,
                            displayOptions: $scope.displayOptions,
                        };
                    }]
                },
            }).result.then(function(result) {}, function() {});
        }

        /**
         * This function filters out students without clashes if the showOnlyClashes flag is set.
         *
         * @param {object} item - The student item to test
         * @return {boolean} true if should be included or false if should be filtered out.
         */
        function clashesFilter(item) {
            return (($scope.filterOptions.showOnlyClashes && item._clash) || !$scope.filterOptions.showOnlyClashes);
        }

        /**
         * This function handles the seating grid 'x' button being
         * pressed.
         *
         * @param st
         * @returns
         */
        function clearSeat(st) {
            console.log('callback function clearSeat() triggered');
            if (st.student[0].studentId !== null) {
                // Remove student from seat
                studentIndex = st.student[0].listIndex;
                $scope.lists.rows[st.student[0].row].columns[st.student[0].col].student[0] = $scope.blankStudent;
                assignSeatToStudent(studentIndex, null, null, null);
            } else {
                // Disable / enable seat
                st.blocked = !st.blocked;
            }
        }

        /**
         * This function filters out students without concessions if the showOnlyConcessions flag is set.
         *
         * @param {object} item - The student item to test
         * @return {boolean} true if should be included or false if should be filtered out.
         */
        function concessionsFilter(item) {
            return (($scope.filterOptions.showOnlyConcessions && item._courseConcessions.length > 0) || !$scope.filterOptions.showOnlyConcessions);
        }

        /**
         * This function opens a window to allow for selection of students (or groups) to assign to a custom/internal exam
         */
        function customExamSelectStudents(results) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/modules/exams/seating-plan/views/seating-plan-custom-exam-students-component.html',
                controller: 'SeatingPlanCustomExamStudentsComponentController',
                controllerAs: 'ctrl',
                size: 'lg',
                backdrop: 'static',
                keyboard: false,
                resolve: {
                    entity: function() {
                        return {
                            customExam: results,
                        };
                    }
                },
            }).result.then(function() {
                // after successfully adding a custom module, and selecting students, then reload the students list.
                init();
            });
        }

        /**
         * This function is used to find the current index of a student
         * object with the define listIndex. The listIndex value in the
         * studentItem object within the array is the initial index that
         * the studentItem had when the array was first populate.
         *
         * @param {Integer}
         *            listIndex The listIndex for the studentItem to
         *            find
         * @return {Integer} The indexOf value for the current position
         *         in the array of students
         */
        function findStudentIndexWithListIndex(listIndex) {
            return $scope.students.indexOf($scope.students.find(function(a) {
                return a.listIndex == listIndex;
            }));
        }

        /**
         * This function initialises the students list and the seating
         * grid.
         *
         * @returns
         */
        function init() {
            entity.examRoom.then(function(data, header) {
                    $scope.examRoom = data.data;
                    $scope.examRoom.examSession.date = new Date($scope.examRoom.examSession.date);
                    $scope.numRows = $scope.examRoom.rows;
                    $scope.numColumns = $scope.examRoom.cols;
                    $scope.students = [];
                    $scope.lists = {
                        rows: []
                    };
                    for (var i = 0; i < $scope.numRows; i++) {
                        $scope.lists.rows.push({
                            label: String.fromCharCode(65 + i),
                            row: i,
                            columns: []
                        });
                        for (var j = 0; j < $scope.numColumns; j++) {
                            $scope.lists.rows[i].columns.push({
                                label: seatLabel(i, j),
                                row: i,
                                col: j,
                                blocked: false,
                                student: [$scope.blankStudent]
                            });
                        }
                    }

                    Component.queryByDateAndSession($scope.examRoom.examSession.date, $scope.examRoom.examSession.session).then(loadComponents,
                        function() {
                            // error
                        });

                },
                function() {
                    console.error("ERROR retrieving exam room details");
                });
        }

        /**
         * This function is part of the drag and drop functionality.
         */
        function listCanceled(st, ind, item) {
            console.log("listCanceled");
        }

        /**
         * This function is part of the drag and drop functionality (Not
         * utilised)
         */
        function listDragEnd(st, ind) {
            console.log("listDragEnd");
        }

        /**
         * This function is part of the drag and drop functionality. A
         * student object is dragged from the student list.
         */
        function listDragStart(st, student, ind) {
            console.log("listDragStart");
            $scope.sourceStudentIndex = findStudentIndexWithListIndex(student.listIndex);
            $scope.sourceStudent = st[$scope.sourceStudentIndex];
        }


        /**
         * This function is part of the drag and drop functionality.
         */
        function listDrop(st, ind, item) {
            console.log("listDrop");
            $scope.$apply();
            return false;
        }

        /**
         * This function is part of the drag and drop functionality (Not
         * utilised)
         */
        function listMoveTo(st, ind) {
            console.log("listMoveTo");
        }

        /**
         * This function receives the loaded list of components, and
         * loads the students for each component.
         *
         * @param data
         * @param header
         * @returns
         */
        function loadComponents(data, header) {
            // success
            $scope.examComponents = data.data.sort(sortByTitle);
            $scope.examComponents.forEach(function(examComponentItem, examComponentIndex) {
                SeatingPlan.queryByExamComponentId(examComponentItem.id).then(function(data, header) {
                        data.data.forEach(function(seatingPlanItem, seatingPlanIndex) {
                            seatingPlanItem.listIndex = $scope.students.length;
                            seatingPlanItem.changed = false;
                            if (seatingPlanItem.row !== null && seatingPlanItem.col !== null && seatingPlanItem.examSeatingPlanId === $scope.examRoom.id) {
                                seatingPlanItem.label = seatLabel(seatingPlanItem.row, seatingPlanItem.col);
                                $scope.lists.rows[seatingPlanItem.row].columns[seatingPlanItem.col].student[0] = seatingPlanItem;
                                console.log($scope.lists);
                            } else {
                                seatingPlanItem.label = null;
                            }
                            $scope.students.forEach(function(student, stIndex) {
                                //Check for student already appearing in the list
                                if (student._candidateNo === seatingPlanItem._candidateNo && student._surname === seatingPlanItem._surname) {
                                    $scope.students[student.listIndex]._clash = true;
                                    seatingPlanItem._clash = true;
                                }
                            });
                            $scope.students.push(seatingPlanItem);
                        });
                        console.log('OUTPUT NEXT');
                        console.log($scope.students);
                        $scope.examComponentsLoaded += 1;
                        if ($scope.examComponentsLoaded == $scope.examComponents.length) {
                            $scope.studentsLoaded = true;
                        }
                    },
                    function(data, header) {
                        // error
                    });
            });
        }

        /**
         * This function is part of the drag and drop functionality (Not
         * utilised)
         */
        function planCanceled(student, ind, item) {
            console.log("planCanceled");
        }

        /**
         * This function is part of the drag and drop functionality. A
         * student object is dropped onto the seating grid.
         */
        function planDrop(student, ind, item) {
            console.log("planDrop");
            student.student[0] = $scope.sourceStudent;
            assignSeatToStudent($scope.sourceStudentIndex, student.row, student.col, $scope.examRoom.id);
            $scope.$apply();
            return true;
        }

        /**
         * This function locates and populates the next available seat
         * as part of the auto populate functionality.
         *
         * @param {object}
         *            The student object
         * @param {integer}
         *            The index of the student (DO NOT USE due to index
         *            referring to incorrect list index
         */
        function populateStudentSeat(studentItem, studentIndex) {
            if (studentItem.row === null && studentItem.col === null) {
                // Find next (or first) available seat
                while ($scope.lists.rows[assign.row].columns[assign.col].student[0].studentId !== null || $scope.lists.rows[assign.row].columns[assign.col].blocked) {

                    // New exam and flag for new exam row/col set, so
                    // move to start of next row/col
                    if (previousExamComponentId !== studentItem.examComponentId && assign.newRowColExam) {
                        if (assign.rowsThenCols) {
                            assign.row = assign.rowStart;
                        } else {
                            assign.row += assign.rowDir;
                        }
                        if (assign.rowsThenCols) {
                            assign.col += assign.colDir;
                        } else {
                            assign.col = assign.colStart;
                        }
                        if (assign.col > assign.colUpperLimit || assign.col < assign.colLowerLimit || assign.row > assign.rowUpperLimit || assign.row < assign.rowLowerLimit) {
                            return true;
                        }
                    } else {
                        // Primary direction is rows
                        if (assign.rowsThenCols) {
                            // Reached the end of the column
                            if (assign.row + assign.rowDir > assign.rowUpperLimit || assign.row + assign.rowDir < assign.rowLowerLimit) {
                                assign.col += assign.colDir; // Move
                                // to
                                // next
                                // column
                                if (assign.col > assign.colUpperLimit || assign.col < assign.colLowerLimit) {
                                    return true; // Moved passed last
                                    // column
                                }

                                if (assign.snake) { // Change direction
                                    // if we're snaking
                                    assign.rowDir *= -1;
                                } else {
                                    assign.row = assign.rowStart; // Move
                                    // to
                                    // start
                                    // of
                                    // column
                                }

                            } else {
                                assign.row += assign.rowDir;
                            }
                        } else {
                            // Reached the end of the row
                            if (assign.col + assign.colDir > assign.colUpperLimit || assign.col + assign.colDir < assign.colLowerLimit) {
                                assign.row += assign.rowDir; // Move
                                // to
                                // next
                                // row
                                if (assign.row > assign.rowUpperLimit || assign.row < assign.rowLowerLimit) {
                                    return true; // Moved passed last
                                    // row
                                }

                                if (assign.snake) {
                                    assign.colDir *= -1; // Change
                                    // direction
                                    // if we're
                                    // snaking
                                } else {
                                    assign.col = assign.colStart; // Move
                                    // to
                                    // start
                                    // of
                                    // row
                                }
                            } else {
                                assign.col += assign.colDir;
                            }
                        }
                    }
                }

                if ($scope.lists.rows[assign.row].columns[assign.col].student[0].studentId === null) {
                    assignSeatToStudent(findStudentIndexWithListIndex(studentItem.listIndex), assign.row, assign.col, $scope.examRoom.id);
                    $scope.lists.rows[assign.row].columns[assign.col].student[0] = studentItem;
                }

                previousExamComponentId = studentItem.examComponentId;
            }
        }

        /**
         * This function calculates and sets row and column ranges and
         * limits, and then auto populates the seating plan for the
         * filtered list.
         *
         * @param {object}
         *            The data specified within the auto populate
         *            details box.
         */
        function populateSeats(result) {
            var filteredStudents = $filter('orderBy')($filter('filter')($scope.students, $scope.listFilter), $scope.sortOrder);
            assign = result;
            assign.numRows = $scope.numRows;
            assign.rowLowerLimit = result.startRow - 1;
            assign.rowUpperLimit = result.endRow - 1;
            assign.numCols = $scope.numColumns;
            assign.colLowerLimit = result.startCol.index;
            assign.colUpperLimit = result.endCol.index;

            switch (assign.fillDirection) {
                case "up":
                    if (!result.fillRowsNotColumns) {
                        if (result.newRowColExam) {
                            newRowUpperLimit = Math.ceil((filteredStudents.length + ($scope.examComponents.length * ($scope.numRows - 1))) / $scope.numColumns);
                        } else {
                            newRowUpperLimit = Math.ceil(filteredStudents.length / $scope.numColumns);
                        }
                        if (newRowUpperLimit < assign.rowUpperLimit) {
                            assign.rowUpperLimit = newRowUpperLimit;
                        }
                    }
                    assign.rowStart = assign.rowUpperLimit;
                    assign.rowDir = -1;
                    switch (assign.secondaryFillDirection) {
                        case "asc":
                            assign.colStart = assign.colLowerLimit;
                            assign.colDir = 1;
                            break;
                        case "desc":
                            assign.colStart = assign.colUpperLimit;
                            assign.colDir = -1;
                            break;
                    }
                    assign.rowsThenCols = true;
                    break;
                case "down":
                    if (!result.fillRowsNotColumns) {
                        if (result.newRowColExam) {
                            newRowUpperLimit = Math.ceil((filteredStudents.length + ($scope.examComponents.length * ($scope.numRows - 1))) / $scope.numColumns);
                        } else {
                            newRowUpperLimit = Math.ceil(filteredStudents.length / $scope.numColumns);
                        }
                        if (newRowUpperLimit < assign.rowUpperLimit) {
                            assign.rowUpperLimit = newRowUpperLimit;
                        }
                    }
                    assign.rowStart = assign.rowLowerLimit;
                    assign.rowDir = 1;
                    switch (assign.secondaryFillDirection) {
                        case "asc":
                            assign.colStart = assign.colLowerLimit;
                            assign.colDir = 1;
                            break;
                        case "desc":
                            assign.colStart = assign.colUpperLimit;
                            assign.colDir = -1;
                            break;
                    }
                    assign.rowsThenCols = true;
                    break;
                case "left":
                    if (result.fillRowsNotColumns) {
                        if (result.newRowColExam) {
                            newColUpperLimit = Math.ceil((filteredStudents.length + ($scope.examComponents.length * ($scope.numColumns - 1))) / $scope.numRows);
                        } else {
                            newColUpperLimit = Math.ceil(filteredStudents.length / $scope.numRows);
                        }
                        if (newColUpperLimit < assign.colUpperLimit) {
                            assign.colUpperLimit = newColUpperLimit;
                        }
                    }
                    assign.colStart = assign.colUpperLimit;
                    assign.colDir = -1;
                    switch (assign.secondaryFillDirection) {
                        case "asc":
                            assign.rowStart = assign.rowLowerLimit;
                            assign.rowDir = 1;
                            break;
                        case "desc":
                            assign.rowStart = assign.rowUpperLimit;
                            assign.rowDir = -1;
                            break;
                    }
                    assign.rowsThenCols = false;
                    break;
                case "right":
                    if (result.fillRowsNotColumns) {
                        if (result.newRowColExam) {
                            newColUpperLimit = Math.ceil((filteredStudents.length + ($scope.examComponents.length * ($scope.numColumns - 1))) / $scope.numRows);
                        } else {
                            newColUpperLimit = Math.ceil(filteredStudents.length / $scope.numRows);
                        }
                        if (newColUpperLimit < assign.colUpperLimit) {
                            assign.colUpperLimit = newColUpperLimit;
                        }
                    }
                    assign.colStart = assign.colLowerLimit;
                    assign.colDir = 1;
                    switch (assign.secondaryFillDirection) {
                        case "asc":
                            assign.rowStart = assign.rowLowerLimit;
                            assign.rowDir = 1;
                            break;
                        case "desc":
                            assign.rowStart = assign.rowUpperLimit;
                            assign.rowDir = -1;
                            break;
                    }
                    assign.rowsThenCols = false;
                    break;
            }

            assign.row = assign.rowStart;
            assign.col = assign.colStart;
            previousExamComponentId = filteredStudents[0].examComponentId;

            filteredStudents.some(populateStudentSeat);
        }

        /**
         * This function saves changes to student seats, and closes the seatingPlan window.
         */
        function saveAndCloseExamRoom() {
            saveExamRoom();
            $state.go('^');
        }

        /**
         * This function scans the students list, and updates the
         * database where a students seating details have been updated.
         */
        function saveExamRoom() {
            $scope.students.forEach(function(studentItem, studentIndex) {
                if (studentItem.changed) {
                    // save - we have no idea whether the object needs
                    // creating or updating.
                    if (studentItem.row !== null && studentItem.col !== null) {
                        SeatingPlan.create(studentItem);
                    } else {
                        SeatingPlan.delete(studentItem);
                    }
                }
            });
        }

        /**
         * This function takes zero indexed row and column and returns
         * the seat label (A1, B5, D3, etc)
         *
         * @param {integer}
         *            Zero indexed row number
         * @param {integer}
         *            Zero indexed column number
         * @return {String} The displayable seat labal
         */
        function seatLabel(row, col) {
            return String.fromCharCode(65 + col) + (row + 1);
        }

        /**
         * This function is used on the Array.sort() function to sort an
         * array of objects by their title field
         *
         * @param {Object}
         *            a This is the first object to compare
         *            (automatically passed in when used with
         *            Array.sort())
         * @param {Object}
         *            b This is the second object to compare
         *            (automatically passed in when used with
         *            Array.sort())
         * @return {Integer} The sort order value
         */
        function sortByTitle(a, b) {
            var titleA = a.title.toUpperCase(); // ignore upper and
            // lowercase
            var titleB = b.title.toUpperCase(); // ignore upper and
            // lowercase
            if (titleA < titleB) {
                return -1;
            }
            if (titleA > titleB) {
                return 1;
            }
            return 0;
        }

        /**
         *
         */
        function sortStudentList(a, b) {
            return a.candidateNo - b.candidateNo;
        }

    }
})();
