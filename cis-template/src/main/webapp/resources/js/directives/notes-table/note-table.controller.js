/**
 * This is the Note Table Controller definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 *  @type Controller
 *
 *
 *   */
(function() {
    'use strict';

    angular
        .module('NoteTableDirective')
        .controller('NoteTableDirectiveController', NoteTableDirectiveController);

    NoteTableDirectiveController.$inject = ['$scope', '$http', 'Note'];

    function NoteTableDirectiveController($scope, $http, Note) {
        console.log('NoteTable Controller loaded');
    }
})();
