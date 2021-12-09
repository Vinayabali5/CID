(function() {
    'use strict';

    angular
        .module('cid.data')
        .config(systemDataRouteConfiguration);

    systemDataRouteConfiguration.$inject = ['$stateProvider'];

    /**
     * This function is used to define the states in the data.system parent state
     */
    function systemDataRouteConfiguration($stateProvider) {
        $stateProvider
            .state('data.system', {
                abstract: true,
                url: '/system',
            })
            .state('data.system.text-lookups', textLookupState)
            .state('data.system.settings', settingsState)
            .state('data.system.possible-grades', possibleGradesState)
            .state('data.system.possible-grade-sets', possibleGradeSetsState)
            .state('data.system.letter-templates', letterTemplatesState)
            .state('data.system.reporting-periods', reportingPeriods);
    }

    /**
     * This function is used to create a state object that can then be used by the stateProvider to register a state.
     *
     * @param  {String} url                The relative URL to use for the created state.
     * @param  {String} templateUrl        The templateUrl to use for the created state.
     * @param  {function} dataCollectionFn The dataCollection function to use for the created state.
     * @return {Object}                    A state definition object.
     */
    function createState(url, templateUrl, dataCollectionFn) {
        return {
            url: url,
            data: {
                roles: ['ROLE_Core Data']
            },
            views: {
                "content@": {
                    templateUrl: templateUrl,
                    controller: 'DataController',
                    controllerAs: 'ctrl'
                },
            },
            resolve: {
                dataCollection: dataCollectionFn
            }
        };
    }

    var textLookupState = createState('/text-lookups', 'js/modules/data/views/text-lookup.html', ['TextLookup', function(TextLookup) {
        return TextLookup.query();
    }]);

    var settingsState = createState('/settings', 'js/modules/data/views/settings.html', ['Settings', function(Settings) {
        return Settings.query();
    }]);

    var possibleGradesState = createState('/possible-grades', 'js/modules/data/views/possible-grades.html', ['PossibleGrade', function(PossibleGrade) {
        return PossibleGrade.query();
    }]);

    var possibleGradeSetsState = createState('/possible-grade-sets', 'js/modules/data/views/possible-grade-sets.html', ['PossibleGradeSet', function(PossibleGradeSet) {
        return PossibleGradeSet.query();
    }]);

    var letterTemplatesState = createState('/letter-templates', 'js/modules/data/views/letter-template.html', ['LetterTemplate', function(LetterTemplate) {
        return LetterTemplate.query();
    }]);

    var reportingPeriods = createState('/reporting-periods', 'js/modules/data/views/reporting-periods.html', ['ReportingPeriod', function(ReportingPeriod) {
        return ReportingPeriod.query();
    }]);

})();
