(function() {
    'use strict';

    describe('AimTypeService', function() {

        var httpBackend;
        var aimType;

        beforeEach(module('AimTypeService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/aimTypes/').respond(200, [{
                id: 1,
                code: '1',
                description: 'Programme aim',
                shortDescription: 'Programme Aim'
            }]);
            httpBackend.whenGET('/api/aimTypes/1').respond(200, {});
            httpBackend.whenPOST('/api/aimTypes/').respond(201, {});
            httpBackend.whenPUT('/api/aimTypes/1').respond(200, {});
            aimType = $injector.get('AimType');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the aimTypes', function() {
            httpBackend.expectGET('/api/aimTypes/');
            aimType.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific aimType', function() {
            httpBackend.expectGET('/api/aimTypes/1');
            aimType.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new aimType', inject(function($http) {
            httpBackend.expectPOST('/api/aimTypes/', {
                code: '1'
            });
            aimType.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing aimtype', function() {
            httpBackend.expectPUT('/api/aimTypes/1', {
                id: 1,
                code: '1',
                description: 'Programme aim',
                shortDescription: 'Programme Aim'
            });
            aimType.save({
                id: 1,
                code: '1',
                description: 'Programme aim',
                shortDescription: 'Programme Aim'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();
