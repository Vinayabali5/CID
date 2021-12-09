(function() {
    'use strict';

    describe('SourceOfFundingService', function() {

        var httpBackend;
        var sourceOfFunding;

        beforeEach(module('SourceOfFundingService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/sourceOfFundings/').respond(200, [{
                id: 1,
                code: '1',
                description: 'Programme aim',
                shortDescription: 'Programme Aim'
            }]);
            httpBackend.whenGET('/api/sourceOfFundings/1').respond(200, {});
            httpBackend.whenPOST('/api/sourceOfFundings/').respond(201, {});
            httpBackend.whenPUT('/api/sourceOfFundings/1').respond(200, {});
            sourceOfFunding = $injector.get('SourceOfFunding');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the sourceOfFundings', function() {
            httpBackend.expectGET('/api/sourceOfFundings/');
            sourceOfFunding.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific sourceOfFunding', function() {
            httpBackend.expectGET('/api/sourceOfFundings/1');
            sourceOfFunding.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new sourceOfFunding', inject(function($http) {
            httpBackend.expectPOST('/api/sourceOfFundings/', {
                code: '1'
            });
            sourceOfFunding.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing aimtype', function() {
            httpBackend.expectPUT('/api/sourceOfFundings/1', {
                id: 1,
                code: '1',
                description: 'Programme aim',
                shortDescription: 'Programme Aim'
            });
            sourceOfFunding.save({
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
