(function() {

    angular
        .module('cid.app.config', [])
        .factory('$cidConfig', CIDConfigFactory);

    function CIDConfigFactory() {
        return {
            datepickerOptions: {
                datepickerMode: 'day',
                formatDay: 'dd',
                formatMonth: 'MM',
                formatYear: 'yyyy',
                startingDay: 1
            },
            tinymceOptions: {
                toolbar: 'undo redo | bold italic underline',
                menubar: false,
                statusbar: false,
                browser_spellcheck: true,
                plugins: 'paste',
                inline: false,
                height: '14em',
                skin: 'lightgray',
                theme: 'modern'
            }
        };
    }
})();
