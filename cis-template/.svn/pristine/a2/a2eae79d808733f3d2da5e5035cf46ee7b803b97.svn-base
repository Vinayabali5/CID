/**
 * The seatingPlanGenerator
 */
(function() {
    //
    angular.module('cid.exams.seating-plan').controller(
        'SeatingPlanController', ["$uibModal", "$state", "$scope", "ExamRoom", "ExamSession", "initExamDate", "initExamSession",
            function($uibModal, $state, $scope, ExamRoom, ExamSession, initExamDate, initExamSession) {
                var vm = this;

                $scope.session = initExamSession !== null ? initExamSession : 'A';
                $scope.examDate = initExamDate !== null ? new Date(initExamDate) : null;
                $scope.showExamRooms = false;
                $scope.examRoomList = [];

                $scope.addEditRoomEntry = addEditRoomEntry;
                $scope.deleteRoomEntry = deleteRoomEntry;
                $scope.loadComponents = loadComponents;
                $scope.loadRooms = loadRooms;
                $scope.onChange = onChange;


                ////////////////////////////////////////////////////////////////////////

                console.log('SeatingPlanController Loaded');
                init();

                function init() {
                    if ($scope.examDate !== null) {
                        $scope.loadComponents();
                    }
                }

                function addEditRoomEntry(_examSession, _examRoom) {
                    console.log('SeatingPlanController::editRoomEntry called');
                    var modalInstance = $uibModal.open({
                        templateUrl: 'js/modules/exams/seating-plan/views/seating-plan-rooms-form.html',
                        controller: 'SeatingPlanRoomsDialogController',
                        controllerAs: 'ctrl',
                        size: 'lg',
                        resolve: {
                            entity: [function() {
                                return {
                                    examSession: _examSession,
                                    examRoom: _examRoom
                                };
                            }]
                        }
                    }).result.then(function(result) {
                        $scope.loadRooms();
                    }, function() {});
                }

                function deleteRoomEntry(_examSession, _examRoom) {
                    var message = "This will delete the exam room from this session, and de-assign any students that were seated in the room. This operation cannot be undone. Are you sure that you want to continue?";
                    bootbox.confirm(message, function(result) {
                        if (result == true) {
                            ExamRoom.delete(_examRoom).then(function() {
                                $scope.loadRooms();
                            }, function() {
                                console.log('examRoom deletion failed');
                            });
                        }
                    });
                }

                function loadComponents() {
                    if ($scope.examDate !== undefined &&
                        $scope.examDate !== null &&
                        $scope.session !== undefined &&
                        $scope.session !== null) {
                        $scope.showExamRooms = true;
                        ExamSession.queryByDateAndSession($scope.examDate, $scope.session).then(function(data, header) {
                            $scope.examSession = data.data;
                        }, function(data, header) { // Error - examSession doesn't exist, so create it
                            $scope.examSession = {};
                            $scope.examSession.date = $scope.examDate;
                            $scope.examSession.session = $scope.session;
                            ExamSession.create($scope.examSession).then(function(data, header) {
                                $scope.examSession.id = data.id;
                            });
                        });
                        $scope.loadRooms();
                    } else {
                        $scope.showExamRooms = false;
                    }
                }

                function loadRooms() {
                    ExamRoom.queryByDateAndSession($scope.examDate, $scope.session).then(function(data, header) {
                        $scope.examRoomList = data.data;
                    });
                }

                function onChange() {
                    var params = {
                        year: "" + $scope.examDate.getFullYear(),
                        month: ("" + ($scope.examDate.getMonth() + 1)).length == 1 ? "0" + ($scope.examDate.getMonth() + 1) : "" + ($scope.examDate.getMonth() + 1),
                        day: ("" + $scope.examDate.getDate()).length == 1 ? "0" + $scope.examDate.getDate() : "" + $scope.examDate.getDate(),
                        session: $scope.session
                    };
                    $state.go('exams.seating-plan.load', params);
                }
            }
        ]);
})();
