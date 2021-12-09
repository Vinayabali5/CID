angular.module('TelephoneFilter', []).filter('telNo', function() {
    return function(text, length, end) {
        if (text && text.length == 11) {
            // Remove all spaces
            var value = text.toString().trim().replace(' ', '');

            // Check that telephone no does contain any alpha characters
            if (value.match(/[^0-9]/)) {
                return text;
            }

            // London / Cardiff
            if (jQuery.inArray(value.slice(0, 3), ['020', '029']) >= 0) {
                return value.slice(0, 3) + ' ' + value.slice(3, 7) + ' ' + value.slice(7, 99);
            }

            // Leeds / Birmingham / Leicester / Edinburgh / Manchester
            if (jQuery.inArray(value.slice(0, 4), ['0113', '0121', '0116', '0131', '0161']) >= 0) {
                return value.slice(0, 4) + ' ' + value.slice(4, 7) + ' ' + value.slice(7, 99);
            }

            // Sedbergh / Brampton
            if (jQuery.inArray(value.slice(0, 5), ['015396', '016977']) >= 0) {
                return value.slice(0, 4) + ' ' + value.slice(4, 6) + ' ' + value.slice(6, 99);
            }

            // Other Landline and Mobile
            if (jQuery.inArray(value.slice(0, 2), ['01', '02', '03', '07']) >= 0) {
                return value.slice(0, 5) + ' ' + value.slice(5, 99);
            }

            // Unformatted
            return text;
        }
        return text;
    };
});
