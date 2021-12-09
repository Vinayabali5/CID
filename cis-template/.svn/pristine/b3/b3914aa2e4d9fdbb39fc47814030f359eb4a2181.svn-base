/**
 * This is the Person Editor Table Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('PersonEditorDirective')
        .controller('PersonEditorController', PersonEditorController);

    PersonEditorController.$inject = ['$log', '$scope', '$rootScope', '$uibModal', 'Person'];

    function PersonEditorController($log, $scope, $rootScope, $uibModal, Person) {
        /* jshint validthis:true */
        var vm = this;
        vm.message = '';
        vm.personId = vm.personId ? vm.personId : undefined;
        vm.person = vm.person ? vm.person : {};

        vm.init = init;
        vm.loadPerson = loadPerson;
        vm.editPerson = editPerson;

        function init() {
            $log.log('PersonDetailsDirectiveController::init called');
            loadPerson(vm.personId);
        }

        function loadPerson(personId) {
            Person.get(personId).then(function(response) {
                $log.info('II Person Loaded');
                vm.person = response.data;
            });
        }

        //update the Person information
        function editPerson(id) {
            $log.log('PersonDetailsDirectiveController::editContact called');
            var personId = id;
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/personEditor/views/personEditorDialog.html',
                controller: 'PersonEditorDialogController',
                controllerAs: 'ctrl',
                backdrop: 'static',
                keyboard: false,
                size: 'lg',
                resolve: {
                    personEntity: function(Person) {
                        return vm.person;
                    }
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadPerson(vm.person.id);
            });
        }

        $scope.hasData = function() {
            if ($scope.person && $scope.person !== undefined) {
                return true;
            } else {
                return false;
            }
        };
    }

})();
