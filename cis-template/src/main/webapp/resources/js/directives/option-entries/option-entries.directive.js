/**
 * This is the Option Entries Directive definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *  
 *  @type Directive
 *  
<option-entries option-entries="ctrl.optionEntries" show-all-entries="false" show-board="false" show-option="true"></option-entries>

<option-entries option-entries="ctrl.optionEntries" show-all-entries="true" show-board="true"></option-entries>

<option-entries option-entries="ctrl.optionEntries" show-all-entries="true" show-option="true" show-board="true"></option-entries>
  */

(function() {
    'use strict';

    angular
        .module('OptionEntriesDirective', ['EntityServices'])
        .directive('optionEntries', optionEntries);

    function optionEntries() {

        var directive = {
            restrict: 'E',
            scope: {
                showAllEntries: '=?',
                showBoard: '=?',
                showOption: '=?',
                optionEntries: '=?',
            },
            templateUrl: 'js/directives/option-entries/option-entries.html',
        };

        return directive;

    }
})();
