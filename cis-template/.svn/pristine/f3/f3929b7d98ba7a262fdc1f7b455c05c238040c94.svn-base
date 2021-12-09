(function() {
    'use strict';

    describe('SettingsService', function() {

        var httpBackend;
        var settings;

        beforeEach(module('SettingsService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/settings/').respond(200, [{
                id: 1,
                settings: '1',
                description: 'Programme note'
            }]);
            httpBackend.whenGET('/api/settings/1').respond(200, {});
            httpBackend.whenPOST('/api/settings/').respond(201, {});
            httpBackend.whenPUT('/api/settings/1').respond(200, {});
            settings = $injector.get('Settings');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the settingss', function() {
            httpBackend.expectGET('/api/settings/');
            settings.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific settings', function() {
            httpBackend.expectGET('/api/settings/1');
            settings.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new settings', inject(function($http) {
            httpBackend.expectPOST('/api/settings/', {
                settings: '1'
            });
            settings.create({
                settings: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing notetype', function() {
            httpBackend.expectPUT('/api/settings/1', {
                id: 1,
                settings: '1',
                description: 'Programme note'
            });
            settings.save({
                id: 1,
                settings: '1',
                description: 'Programme note'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();
