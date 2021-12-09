(function() {
    'use strict';

    describe('FundingModelService', function() {

        var httpBackend;
        var fundingModel;

        beforeEach(module('FundingModelService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/fundingModels/').respond(200, [{
                id: 1,
                code: '1',
                description: 'fundingModel aim',
                shortDescription: 'fundingModel Aim'
            }]);
            httpBackend.whenGET('/api/fundingModels/1').respond(200, {});
            httpBackend.whenPOST('/api/fundingModels/').respond(201, {});
            httpBackend.whenPUT('/api/fundingModels/1').respond(200, {});
            fundingModel = $injector.get('FundingModel');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the fundingModels', function() {
            httpBackend.expectGET('/api/fundingModels/');
            fundingModel.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific fundingModel', function() {
            httpBackend.expectGET('/api/fundingModels/1');
            fundingModel.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new fundingModel', inject(function($http) {
            httpBackend.expectPOST('/api/fundingModels/', {
                code: '1'
            });
            fundingModel.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing aimtype', function() {
            httpBackend.expectPUT('/api/fundingModels/1', {
                id: 1,
                code: '1',
                description: 'fundingModel aim',
                shortDescription: 'fundingModel Aim'
            });
            fundingModel.save({
                id: 1,
                code: '1',
                description: 'fundingModel aim',
                shortDescription: 'fundingModel Aim'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();
