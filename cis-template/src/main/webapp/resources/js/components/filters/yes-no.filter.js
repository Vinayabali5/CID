angular.module('YesNoFilter', []).filter('yesNo', function() {
    return function(text, length, end) {
        if (text === null || text === undefined) {
            return 'No data';
        }
        if (text) {
            return 'Yes';
        }
        return 'No';
    };
});
