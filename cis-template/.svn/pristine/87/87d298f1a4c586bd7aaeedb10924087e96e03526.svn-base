(function() {
    'use strict';

    angular
        .module('cid.data')
        .config(timetablingDataRouteConfiguration);

    timetablingDataRouteConfiguration.$inject = ['$stateProvider'];

    function timetablingDataRouteConfiguration($stateProvider) {
        $stateProvider
            .state('data.timetabling', {
                abstract: true,
                url: '/timetabling',
            })
            .state('data.timetabling.periods', {
                url: '/periods',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/periods.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['Period', function(Period) {
                        return Period.query();
                    }]
                }

            })
            .state('data.timetabling.blocks', {
                url: '/blocks',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/blocks.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['Block', function(Block) {
                        return Block.query();
                    }]
                }

            })
            .state('data.timetabling.blocks.edit', {
                url: '/edit/{blockId}',
                data: {
                    roles: ['ROLE_Core Data']
                },
                onEnter: ['$state', '$stateParams', '$log', '$uibModal', 'Block', function($state, $stateParams, $log, $uibModal, Block) {
                    $log.log("BlocksEditorController :: editBlocks called");
                    var modalInstance = $uibModal.open({
                        templateUrl: 'js/directives/blocks-editor/views/blocks-editorDialog.html',
                        controller: 'BlocksEditorDialogController',
                        controllerAs: 'ctrl',
                        size: 'lg',
                        resolve: {
                            blocksEntity: function(Block) {
                                return Block.get($stateParams.blockId).then(function(response) {
                                    return response.data;
                                }, function(response) {
                                    alert("failed to retrieve");
                                });
                            }
                        }
                    }).result.finally(function() {
                        $state.go('^');
                    });

                }]
            })
            .state('data.timetabling.rooms', {
                url: '/rooms',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/rooms.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['Room', function(Room) {
                        return Room.query();
                    }]
                }

            });
    }
})();
