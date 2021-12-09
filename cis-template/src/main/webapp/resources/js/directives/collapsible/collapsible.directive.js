/**
 * This a generic directive that can be used to make any element in the CID system collapsible.
 *
 * @usage <div collapsible="'IDValueToUse'" collapsible-title="'User Friendly Button Title'"> content to collapse here <div>
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 */

(function() {
    'use strict';

    angular
        .module('cid.system.collapsible', [])
        .directive('collapsible', collapsible);

    function collapsible() {

        var directive = {
            restrict: 'A',
            transclude: true,
            scope: {
                collapsible: '=',
                collapsibleTitle: '=',
            },
            templateUrl: 'js/directives/collapsible/collapsible.html',
        };

        return directive;
    }
})();
