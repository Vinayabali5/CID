(function() {
    'use strict';

    angular
        .module('dialogs-mass-letter', [
            'ui-notification',
            'ui.bootstrap.tabs',
            'frapontillo.bootstrap-duallistbox',
            'cid.service.logger',
            'CourseGroupService',
            'StatementBankService',
            'MassLetterService',
        ])
        .directive('massLetter', massLetterDirective);

    massLetterDirective.$inject = ['Logger', '$uibModal', 'Auth', 'APP', 'MassLetter', 'CourseGroup'];

    function massLetterDirective(Logger, $uibModal, Auth, APP, MassLetter, CourseGroup) {

        // Public Interface

        var directive = {
            restrict: 'A',
            scope: {
                courseGroupId: '=massLetter',
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
                    templateUrl: 'js/directives/dialogs/mass-letter/mass-letter.html',
                    controller: 'MassLetterDirectiveController',
                    controllerAs: 'ctrl',
                    size: 'lg',
                    backdrop: 'static',
                    resolve: {
                        MassLetters: ['MassLetter', function(MassLetter) {
                            return {
                                data: {
                                    studentCopiedIn: true,
                                    courseGroupId: $scope.courseGroupId,
                                    warningParagraph: 1,
                                    staffId: Auth.getUser().staffId,
                                    interviewDate: new Date(),
                                    interviewTypeId: 1,
                                    letterTypeId: 1
                                }
                            };
                        }],
                        Enrolments: ['CourseGroup', function(CourseGroup) {
                            if ($scope.courseGroupId != undefined && $scope.courseGroupId != null) {
                                return CourseGroup.enrolments($scope.courseGroupId);
                            }
                        }],
                        StatementBankData: ['StatementBank', function(StatementBank) {
                            return StatementBank.getMassLetters(); // Get mass letters only
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
