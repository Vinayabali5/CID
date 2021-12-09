(function() {
    'use strict';

    angular
        .module('dialogs-mass-praise-email', [
            'ui-notification',
            'ui.bootstrap.tabs',
            'frapontillo.bootstrap-duallistbox',
            'cid.service.logger',
            'CourseGroupService',
            'StatementBankService',
            'MassLetterService',
        ])
        .directive('massPraiseEmail', massPraiseEmailDirective);

    massPraiseEmailDirective.$inject = ['Logger', '$uibModal', 'Auth', 'APP', 'MassLetter', 'CourseGroup'];

    function massPraiseEmailDirective(Logger, $uibModal, Auth, APP, MassLetter, CourseGroup) {

        // Public Interface

        var directive = {
            restrict: 'A',
            scope: {
                courseGroupId: '=massPraiseEmail',
                callbackFn: '=callback',
                callbackFailFn: '=callbackFail'
            },
            link: linkFunction,
        };

        return directive;

        // Private Interface

        function linkFunction($scope, elem, attr) {
            elem.bind('click', function() {
                var modalInstance = $uibModal.open({
                    animation: true,
                    templateUrl: 'js/directives/dialogs/mass-praise-email/mass-praise-email.html',
                    controller: 'MassPraiseEmailDirectiveController',
                    controllerAs: 'ctrl',
                    size: 'lg',
                    backdrop: 'static',
                    resolve: {
                        MassLetters: ['MassLetter', function(MassLetter) {
                            return {
                                data: {
                                    courseGroupId: $scope.courseGroupId,
                                    staffId: Auth.getUser().staffId,
                                    interviewDate: new Date(),
                                    interviewTypeId: 1,
                                    letterTypeId: 3
                                }
                            };
                        }],
                        Enrolments: ['CourseGroup', function(CourseGroup) {
                            if ($scope.courseGroupId != undefined && $scope.courseGroupId != null) {
                                return CourseGroup.enrolments($scope.courseGroupId);
                            }
                        }],
                        StatementBankData: ['StatementBank', function(StatementBank) {
                            return StatementBank.getMassPraiseEmail(); // Get mass praise emails only
                        }],
                    }
                });
                modalInstance.result.then(function() {
                    if ($scope.callbackFn) {
                        $scope.callbackFn();
                    }
                }, function() {
                    if ($scope.callbackFailFn) {
                        $scope.callbackFailFn();
                    }
                });
            });
        }

    }

}());
