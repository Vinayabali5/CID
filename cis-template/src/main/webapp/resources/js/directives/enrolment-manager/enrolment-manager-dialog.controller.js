/**
 * This is the Enrolment Manager Dialog Directive Controller.
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('EnrolmentManagerDirective')
        .controller('EnrolmentManagerDialogDirectiveController', EnrolmentManagerDialogDirectiveController);

    EnrolmentManagerDialogDirectiveController.$inject = ['$log', '$scope', '$rootScope', '$http', '$uibModal', '$uibModalInstance', '$cidConfig', 'studentEntity', 'enrolmentsList', 'GLOBAL', 'APP'];

    function EnrolmentManagerDialogDirectiveController($log, $scope, $rootScope, $http, $uibModal, $uibModalInstance, $cidConfig, studentEntity, enrolmentsList, GLOBAL, APP) {
        /* jshint validthis:true */
        var vm = this;

        vm.loading = false;

        vm.message = '';

        vm.student = studentEntity ? studentEntity : {};
        vm.enrolments = enrolmentsList ? enrolmentsList : [];

        vm.page = 1;
        vm.size = 8;
        vm.totalItems = 0;

        vm.changeDate = new Date();

        vm.ttCheck = {
            specs: [],
            status: 'PENDING',
            options: []
        };

        vm.init = init;
        vm.cancel = cancel;
        vm.getTotalItems = getTotalItems;
        vm.check = check;
        vm.requestCount = requestCount;
        vm.addRequest = addRequest;
        vm.removeRequest = removeRequest;
        vm.selectOption = selectOption;
        vm.next = next;
        vm.previous = previous;
        vm.onSaveFinished = onSaveFinished;

        vm.init();

        function onSaveFinished(result) {
            $rootScope.$emit('enrolments-saved', result);
            $uibModalInstance.close(result);
        }


        function init() {
            $log.log('II EnrolmentEditorDialogDirectiveController::init called');
            $log.info(vm.student);
            if (vm.enrolments && vm.enrolments.length !== 0) {
                vm.ttCheck.specs = [];
                vm.enrolments.forEach(function(element, index, array) {
                    vm.ttCheck.specs.push(element._courseGroupReference);
                });
            }
        }

        function cancel() {
            $log.log('II EnrolmentEditorDialogDirectiveController::cancel called');
            $uibModalInstance.dismiss('cancel');
        }

        function getTotalItems() {
            if (this.ttCheck.options) {
                return this.ttCheck.options.size;
            } else {
                return 0;
            }
        }

        function check() {
            $log.log('II EnrolmentEditorDialogDirectiveController::check called');
            if (vm.requestCount() === 0) {
                bootbox.alert("There are no requests to check. Please ensure you have entered some course code before trying to check.");
            } else {
                vm.ttCheck.options = [];
                vm.totalItems = 0;
                vm.loading = true;

                $http.post(GLOBAL.API + '/enrolmentChecker', {
                    specs: vm.ttCheck.specs,
                    date: vm.changeDate
                }).then(function(response) {
                    vm.ttCheck.options = response.data;
                    vm.totalItems = response.data.length;
                    vm.loading = false;
                    $log.log(vm.ttCheck);
                }, function(response) {
                    vm.ttCheck.options = [];
                    vm.loading = false;
                    $log.log(vm.ttCheck);
                    switch (response.status) {
                        case 400:
                            vm.message = response.data;
                            bootbox.alert(vm.message.message);
                            break;
                        default:
                            bootbox.alert("Some unknown error occurred. <br />The following message was returned: <br /> " + response.data.message);
                    }
                });
            }
        }


        function requestCount() {
            return vm.ttCheck.specs.length;
        }


        function addRequest(request) {
            $log.log('II EnrolmentEditorDialogDirectiveController::addRequest called');
            if (request !== undefined && request.length !== 0) {
                $http.post(GLOBAL.API + '/enrolmentChecker/validRequest', {
                    request: request.toUpperCase()
                }).then(function(response) {
                    switch (response.status) {
                        case 200: // Request Valid
                            vm.ttCheck.specs.push(request.toUpperCase());
                            vm.newRequest = '';
                            break;
                        case 204: // Request Invalid
                            bootbox.alert("The course request code you entered is not found on the timetable. Please check the code and try again.");
                            break;
                        default:
                            break;
                    }
                }, function(response) {

                });
            }
        }

        function removeRequest(request) {
            vm.ttCheck.specs.splice(vm.ttCheck.specs.indexOf(request), 1);
        }

        function selectOption(option) {
            bootbox.confirm("Are you sure that you want to make this selection? This will replace all the students current enrolments. ", function(result) {
                if (result) {
                    $http.post(GLOBAL.API + '/enrolments/change/programme', {
                        studentId: vm.student.id,
                        academicYearId: APP.getYear().id,
                        courseGroups: option.courseGroups,
                        changeDate: vm.changeDate
                    }).then(function(response) {
                        $log.info(response);
                        if (response.status == 200) {
                            $rootScope.$emit('enrolments-saved', response.data);
                            $uibModalInstance.close(response);
                        }
                    }, function(response) {
                        $log.info(response);
                        vm.message = response.data.message;
                    });
                }
            });
        }


        function next() {
            vm.page++;
        }

        function previous() {
            vm.page--;
        }

    }

})();
