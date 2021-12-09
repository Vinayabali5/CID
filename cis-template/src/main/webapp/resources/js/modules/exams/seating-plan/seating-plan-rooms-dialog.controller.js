/**
 * The seatingPlan
 */
(function() {
    //
    angular
        .module('cid.exams.seating-plan')
        .controller('SeatingPlanRoomsDialogController', ["$scope", "$uibModalInstance", "entity", "ExamRoom", "Room",
            function($scope, $uibModalInstance, entity, ExamRoom, Room) {
                var vm = this;

                $scope.cancel = cancel;
                $scope.examRoom = {};
                $scope.rowsAndColsSet = rowsAndColsSet;
                $scope.save = save;
                $scope.setDefaults = setDefaults;
                $scope.setRowColValues = setRowColValues;

                ////////////////////////////

                console.log('SeatingPlanRoomsDialogController Loaded');
                init();

                /**
                 * This procedure discards the dialog window if the cancel button is pressed
                 */
                function cancel() {
                    $uibModalInstance.dismiss('cancel');
                }

                /**
                 * This procedure initialises the Add/Edit seating plan room dialog
                 */
                function init() {
                    if (entity.examRoom === undefined) {
                        $scope.newNotEdit = true;
                    } else {
                        $scope.examRoom = entity.examRoom;
                        $scope.newNotEdit = false;
                    }
                    if (entity.examSession === null) {
                        console.error('Cannot edit exam room without selecting exam session');
                    } else {
                        $scope.examRoom.examSession = entity.examSession;
                    }
                }

                /**
                 * This procedure closes the dialog box once the room has been saved
                 */
                function onSaveFinished(result) {
                    $uibModalInstance.close(result);
                }

                /**
                 * This procedure determines whether the row and column values have been set
                 *
                 * @return {boolean} true if row and column values are specified
                 */
                function rowsAndColsSet() {
                    return !($scope.examRoom.rows !== undefined && $scope.examRoom.rows > 0 && $scope.examRoom.cols !== undefined && $scope.examRoom.cols > 0);
                }

                /**
                 * This function saves the row and column values as defaults to the room table
                 */
                function setDefaults() {
                    $scope.examRoom.room.defaultRows = $scope.examRoom.rows;
                    $scope.examRoom.room.defaultCols = $scope.examRoom.cols;
                    Room.save($scope.examRoom.room);
                }

                /**
                 * This procedure loads room details and sets the data if appropriate
                 */
                function setRowColValues() {
                    ExamRoom.queryByExamSessionIdAndRoomId($scope.examRoom.examSession.id, $scope.examRoom.room.id).then(function(data, header) {
                        if ($scope.newNotEdit) {
                            $scope.examRoom = data.data;
                        }
                    }, function(data, header) {
                        if (!$scope.newNotEdit) {
                            console.error('Error: Could not access details for examRoom being edited, id ' + $scope.examRoom.id);
                        }
                    });

                    Room.get($scope.examRoom.room.id).then(function(data, header) {
                        $scope.examRoom.rows = data.data.defaultRows;
                        $scope.examRoom.cols = data.data.defaultCols;
                        $scope.rowsMsg = "Default: " + data.data.defaultRows;
                        $scope.colsMsg = "Default: " + data.data.defaultCols;
                    }, function() {
                        console.error('Error: Could not access details for room id ' + $scope.examRoom.room.id);
                    });
                }

                /**
                 * This function updates or creates the exam room to the database
                 */
                function save() {
                    if ($scope.newNotEdit) {
                        ExamRoom.create($scope.examRoom, onSaveFinished).then(function(data, header) {}, function(data, header) {});
                    } else {
                        ExamRoom.save($scope.examRoom, onSaveFinished).then(function(data, header) {}, function(data, header) {});
                    }
                }
            }
        ]);
})();
