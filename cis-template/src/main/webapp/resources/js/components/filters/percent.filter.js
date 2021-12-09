/**
 *
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y024, Y060]
 *
 * @type filter
 */
(function() {
    angular.module('PercentFilter', []).filter('percent', PercentFilter);

    PercentFilter.$inject = ['$filter'];

    function PercentFilter($filter) {
        return function(input, decimals) {
            if (input !== null && input !== undefined) {
                if (!isNaN(parseFloat(input))) {
                    return $filter('number')(input * 100, decimals) + '%';
                } else {
                    return input;
                }
            } else {
                return 'No Data';
            }
        };
    }
})();
