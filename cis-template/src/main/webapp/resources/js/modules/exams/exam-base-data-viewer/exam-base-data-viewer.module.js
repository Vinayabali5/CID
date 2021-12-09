(function() {
    angular
        .module('cid.exams.base-data-viewer', ['ui.router',
            'ui.bootstrap',
            'ngResource',
            'SyllabusService',
            'OptionService',
            'ComponentService',
            'SyllabusTableDirective',
            'OptionTableDirective',
            'BaseDataEditButtonsDirective'
        ]);
})();
