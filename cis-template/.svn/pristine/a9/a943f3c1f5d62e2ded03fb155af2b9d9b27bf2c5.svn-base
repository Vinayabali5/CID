(function() {
    'use strict';

    angular
        .module('cid.site')
        .config(mainSiteRouteConfiguration);

    mainSiteRouteConfiguration.$inject = ['$stateProvider', '$urlRouterProvider'];

    function mainSiteRouteConfiguration($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('site', {
                data: {
                    //                    roles: ['ROLE_Staff']
                },
                views: {
                    "navigation@": {
                        templateUrl: 'js/modules/site/views/navigation.html',
                        controller: 'MainSiteNavigationController',
                        controllerAs: 'ctrl',
                    },
                    "side-bar-global@": {
                        templateUrl: 'js/modules/site/views/side-bar-global.html',
                        controller: 'MainSiteNavigationController',
                        controllerAs: 'ctrl'
                    },
                    "debug@": {
                        templateUrl: 'js/modules/site/views/debug-info.html',
                        controller: 'MainSiteDebugController',
                        controllerAs: 'ctrl',
                    },
                },
                // onEnter: ["AcademicYear", "APP", function(AcademicYear, APP) {
                //     AcademicYear.getCurrent().then(function(response) {
                //         APP.setYear(response.data);
                //     });
                // }],
                resolve: {
                    initalAcademicYear: ["AcademicYear", "APP", function(AcademicYear, APP) {
                        AcademicYear.getCurrent().then(function(response) {
                            APP.setYear(response.data);
                        });
                    }]
                }
            })
            .state('site.home', {
                url: '/',
                data: {
                    //                    roles: ['ROLE_Staff']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/site/views/home.html',
                        controller: 'MainSiteHomeController',
                        controllerAs: 'ctrl'
                    },
                },
            })
            .state('site.reports', {
                url: '/reports',
                data: {
                    roles: ['ROLE_Staff']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/site/views/reports.html',
                        controller: 'MainSiteNavigationController',
                        controllerAs: 'ctrl'
                    },
                },
            })
            .state('login', {
                url: '/login',
                views: {
                    "content@": {
                        templateUrl: 'js/modules/site/views/login.html',
                        controller: 'MainSiteLoginController',
                        controllerAs: 'ctrl',
                    }
                }
            })
            .state('logout', {
                url: '/logout',
                views: {
                    "content@": {
                        templateUrl: 'js/modules/site/views/login.html',
                        controller: ['$state', 'Auth', function($state, Auth) {
                            Auth.clearCredentials();
                            $state.go('login');
                        }],
                    },
                }
            });
    }
})();
