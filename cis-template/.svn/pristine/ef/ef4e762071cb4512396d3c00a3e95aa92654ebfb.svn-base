(function() {
    'use strict';

    angular
        .module('dialogs-edit-ilp')
        .controller('EditILPDirectiveController', EditILPDirectiveController);

    EditILPDirectiveController.$inject = ['Logger', '$scope', '$uibModal', '$uibModalInstance', 'USER', 'Auth', 'APP', '$cidConfig', 'ILPInterview', 'ILPInterviewEntry', 'StudentData', 'StudentCourseGroups', 'StatementBankData', 'StudentRelatedStaff'];

    function EditILPDirectiveController(Logger, $scope, $uibModal, $uibModalInstance, USER, Auth, APP, $cidConfig, ILPInterview, ILPInterviewEntry, StudentData, StudentCourseGroups, StatementBankData, StudentRelatedStaff) {
        var vm = this;

        $scope.submitted = false;

        $scope.tinymceOptions = $cidConfig.tinymceOptions;

        vm.ilpInterview = ILPInterviewEntry.data !== undefined ? ILPInterviewEntry.data : null;
        vm.statementBank = StatementBankData !== undefined ? StatementBankData.data : [];
        vm.courseGroups = StudentCourseGroups !== null ? StudentCourseGroups.data : null;
        vm.student = StudentData !== null ? StudentData.data : null;

        $scope.letterTypeId = (vm.ilpInterview !== undefined && vm.ilpInterview.letter !== undefined && vm.ilpInterview.letter !== null && vm.ilpInterview.letter.letterTypeId !== undefined) ? vm.ilpInterview.letter.letterTypeId : undefined;


        vm.currentUser = Auth.getUser();
        vm.addStatement = addStatement;

        vm.changeInterviewType = changeInterviewType;
        vm.changeLetterType = changeLetterType;

        vm.save = save;
        vm.saveAndReferToLIP = saveAndReferToLIP;
        vm.saveAndEmailRelatedStaff = saveAndEmailRelatedStaff;
        vm.staffILPEmailNotification = staffILPEmailNotification;
        vm.cancel = cancel;

        vm.canSendLetter = canSendLetter;

        /**
         * This is a watcher that executes a function whenever the letterTypeId is changed on the dialog form.
         */
        $scope.$watch('letterTypeId', function() {
            changeLetterType();
        });

        function changeInterviewType() {
            if (vm.ilpInterview.privateEntry === undefined && vm.ilpInterview.interviewType !== null) {
                vm.ilpInterview.privateEntry = vm.ilpInterview.interviewType.defaultToPrivate;
            }
        }

        /**
         * This method is used to add a statement from the statement bank to the ILP Interview.
         *
         * @param {Object} statement the statement bank object
         */
        function addStatement(statement) {
            Logger.log('EditILPDirectiveController::addStatement called');
            if (vm.ilpInterview !== undefined) {
                var discussion = processReplacements(statement.discussion);
                var target = processReplacements(statement.target);

                vm.ilpInterview.discussion = vm.ilpInterview.discussion === undefined ? discussion : vm.ilpInterview.discussion + discussion;
                vm.ilpInterview.target = vm.ilpInterview.target === undefined ? target : vm.ilpInterview.target + target;
            } else {
                Logger.error("No ILP Interview is defined.");
            }
        }

        /**
         * This method is used to process various text replacements in the supplied text based on the currently 
         * loaded student. 
         * 
         * This will currently replace the following:
         * * \<Student>: the student's preferred name or first if there is no preferred. 
         * * \<Hisher>, \<hisher>, \<Heshe>, \<heshe>: these placeholders get replace with the gender specific pronoun.
         * 
         * @param {*} text the text to search for replacements.
         * @returns the text with replaced placeholders.
         */
        function processReplacements(text) {
            if (text === null) {
                return;
            }
            var output = text;
            // Student specific text replacements
            var studentName = vm.student.person.preferredName != null ? vm.student.person.preferredName : vm.student.person.firstName;
            output = output.replace('<Student>', studentName);
            // Gender specific text replacements
            var gender = vm.student.person.gender != undefined ? vm.student.person.gender : undefined;
            output = output.replace('<Hisher>', gender != undefined ? gender.hisHer : 'Their');
            output = output.replace('<hisher>', gender != undefined ? gender.hisHer : 'their');
            output = output.replace('<Heshe>', gender != undefined ? gender.heShe : 'They');
            output = output.replace('<heshe>', gender != undefined ? gender.heShe : 'they');
            return output;
        }

        /**
         * This method is used to create and delete the embedded letter object in the ilpinterview where required.
         */
        function changeLetterType() {
            // Check the selected letter type
            if ($scope.letterTypeId !== undefined && $scope.letterTypeId !== null) {
                if (vm.ilpInterview.letter == undefined) {
                    vm.ilpInterview.letter = {};
                    vm.ilpInterview.letter.requestedDate = new Date();
                }
                vm.ilpInterview.letter.letterTypeId = $scope.letterTypeId;
                vm.ilpInterview.letter.studentId = vm.ilpInterview.studentId;
                vm.ilpInterview.letter.academicYearId = vm.ilpInterview.academicYearId;
                // vm.ilpInterview.letter.requestedDate = new Date();
                vm.ilpInterview.letter.requestedById = vm.ilpInterview.staffId;
                //  vm.ilpInterview.letter.nonEntryWarning = 1;
                vm.ilpInterview.letterSent = true;
                switch ($scope.letterTypeId) {
                    case 1: // Yellow Letter Selected
                        break;
                    case 2: // Purple Letter Selected
                        break;
                    case 3: // Green Letter Selected
                        break;
                    case 4: // Interim Report Letter Selected
                        break;
                }
            } else {
                // No Letter -  Delete the letter object if exists
                //if (vm.ilpInterview.letter !== undefined && vm.ilpInterview.letter !== null && vm.ilpInterview.letter.id === undefined) {
                if (vm.ilpInterview.letter !== undefined) {
                    vm.ilpInterview.letterSent = false;
                    delete vm.ilpInterview.letter;
                }
            }
        }

        /**
         * This saves the ilpInterviews and closes that dialog box
         */
        function save() {
            $scope.submitted = true;
            Logger.log('EditILPDirectiveController::save called');
            if (vm.ilpInterview.interviewType.requireCourseGroupId === false) {
                vm.ilpInterview.courseGroupId = null;
            }
            if (vm.ilpInterview.id != undefined) {
                return ILPInterview.save(vm.ilpInterview, closeDialog).finally(function() {
                    $scope.submitted = false;
                });
            } else {
                return ILPInterview.create(vm.ilpInterview, closeDialog).finally(function() {
                    $scope.submitted = false;
                });
            }
        }

        /**
         * This method is used to email the Student staff related.
         * and the ILP Entry is saved as normal.
         */
        function saveAndEmailRelatedStaff(studentId) {
            save().then(function(response) {
                Logger.log("Ready to send email");
                vm.ilpInterview = response.data;
                if (vm.ilpInterview !== null) {
                    Logger.log('EditILPDirectiveController::saveAndEmailRelatedStaff called');
                    var modalInstance = $uibModal.open({
                        templateUrl: 'js/directives/dialogs/edit-ilp/views/student-related-staff-dialog.html',
                        controller: 'StudentRelatedStaffEditorDialogController',
                        controllerAs: 'ctrl',
                        size: 'lg',
                        resolve: {
                            EmailEntry: ['$filter', 'ILPInterview', function($filter, ILPInterview) {
                                if (vm.ilpInterview != undefined) {
                                    ILPInterview.getById(vm.ilpInterview.id);
                                    var dateString = $filter('date')(new Date(vm.ilpInterview.interviewDate), 'dd/MM/yyyy');
                                    var subjectLine = "ILP Entry made for " + vm.student.person.surname + '-' + vm.student.person.firstName;
                                    var emailMessage = "<p>The following was added onto the ILP on " + dateString + "</p>";
                                    emailMessage += "<p><strong>Discussion: </strong></p> " + vm.ilpInterview.discussion;
                                    if (vm.ilpInterview.target != undefined && vm.ilpInterview.target != null) {
                                        emailMessage += "<p><strong>Targets: </strong></p> " + vm.ilpInterview.target;
                                    }
                                    if (vm.ilpInterview._staffName != undefined && vm.ilpInterview._staffName != null) {
                                        emailMessage += "<p>Regards</p>";
                                        emailMessage += "<p>" + vm.ilpInterview._staffName + "</p>";
                                        emailMessage += "<p>" + vm.ilpInterview._staffSignature + "</p>";
                                    }
                                    return {
                                        data: {
                                            ilpInterviewId: vm.ilpInterview.id,
                                            staffId: vm.ilpInterview.staffId,
                                            subject: subjectLine,
                                            message: emailMessage
                                        }
                                    };
                                } else {
                                    if (vm.studentId != undefined && vm.studentId != null) {

                                        return {
                                            data: {
                                                ilpInterviewId: vm.ilpInterview.id,
                                                staffId: vm.ilpInterview.staffId,
                                                subject: "ILP Entry (Learning Support) made for "
                                            }
                                        };
                                    }
                                }
                            }],
                            StaffList: ['StudentRelatedStaff', function(StudentRelatedStaff) {
                                return StudentRelatedStaff.get(studentId);
                            }],

                        }
                    });
                }
            });
        }

        /**
         * This method is used to send ilp interviews notification email to staff.
         * and the ILP Entry is saved as normal.
         */
        function staffILPEmailNotification(studentId) {
            save().then(function(response) {
                Logger.log("Ready to send email");
                vm.ilpInterview = response.data;
                if (vm.ilpInterview !== null) {
                    Logger.log('EditILPDirectiveController::saveAndEmailRelatedStaff called');
                    var modalInstance = $uibModal.open({
                        templateUrl: 'js/directives/dialogs/edit-ilp/views/staff-ilp-email-notification-dialog.html',
                        controller: 'StudentRelatedStaffEditorDialogController',
                        controllerAs: 'ctrl',
                        size: 'lg',
                        resolve: {
                            EmailEntry: ['$filter', 'ILPInterview', function($filter, ILPInterview) {
                                if (vm.ilpInterview != undefined) {
                                    ILPInterview.getById(vm.ilpInterview.id);
                                }
                                return {
                                    data: {
                                        ilpInterviewId: vm.ilpInterview.id
                                    }
                                };
                            }],
                            StaffList: ['StudentRelatedStaff', function(StudentRelatedStaff) {
                                return StudentRelatedStaff.get(studentId);
                            }],

                        }
                    });
                }
            });
        }

        /**
         * This method is used to flag the ILP Entry for LIP Referral. After the user has confirmed they want to proceed the flags are set
         * and the ILP Entry is saved as normal.
         */
        function saveAndReferToLIP() {
            Logger.log('EditILPDirectiveController::saveAndReferToLIP called');
            bootbox.confirm({
                message: "This will send an email to the LIP co-ordinator to book the student onto a LIP session. Are you sure you want to proceed?",
                buttons: {
                    confirm: {
                        label: 'Yes',
                        className: 'btn-success'
                    },
                    cancel: {
                        label: 'No',
                        className: 'btn-danger'
                    }
                },
                callback: function(result) {
                    if (result === true) {
                        vm.ilpInterview.referLip = true;
                        vm.ilpInterview.lipReferDate = new Date();
                        save();
                    }
                }
            });
        }



        /**
         * This closes the ilpInterviews editor dialog box without saving
         */
        function cancel() {
            Logger.log('EditILPDirectiveController::cancel called');
            $uibModalInstance.dismiss('cancel');
        }

        /**
         * This is used to close the dialog box once the save is clicked.
         */
        function closeDialog() {
            $uibModalInstance.close();
        }

        /**
         * This method is used to determine if a letter can be sent based on the various ILP Interview data supplied.
         *
         * @return {boolean} true if a letter can be sent, false if a letter cannot be sent
         */
        function canSendLetter() {
            return vm.ilpInterview.interviewType !== undefined && vm.ilpInterview.interviewType !== null && (vm.ilpInterview.interviewType.id == 1 || vm.ilpInterview.interviewType.id == 2);
        }

    }


}());
