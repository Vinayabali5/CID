/**
 * This is an AngularJS filter that when used on a field will check to see if the fields is set or not. This means
 * if the fields has any data that is not null or undefined. If the data in the fields is any of these values the
 * text 'Not Set' will be displayed.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y024]
 *
 * @type filter
 */
(function() {
    angular
        .module('NotSetFilter', [])
        .filter('notSet', NotSetFilter);

    function NotSetFilter() {
        return function(data, length, end) {
            if (data === null || data === undefined || data === '') {
                return 'Not Set';
            }
            return data;
        };
    }
})();
