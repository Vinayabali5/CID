/**
 *
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y024]
 *
 * @type filter
 */
(function() {
    angular
        .module('PaginateFilter', [])
        .filter('paginate', PaginateFilter);

    function PaginateFilter() {
        return function(input, page, size) {
            page = +page - 1;
            size = +size;
            return input.slice(page * size, (page * size) + size);
        };
    }

})();
