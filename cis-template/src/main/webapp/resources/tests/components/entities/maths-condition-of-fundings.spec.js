(function() {
    'use strict';

    describe('MathsConditionOfFundingService', function() {

        var httpBackend;
        var mathsConditionOfFunding;

        beforeEach(module('MathsConditionOfFundingService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/mathsConditionOfFundings/').respond(200, [{
                id: 1,
                code: '1',
                description: 'Programme aim',
                shortDescription: 'Programme Aim'
            }]);
            httpBackend.whenGET('/api/mathsConditionOfFundings/1').respond(200, {});
            httpBackend.whenPOST('/api/mathsConditionOfFundings/').respond(201, {
                id: 1,
                code: '1',
                description: 'Programme aim',
                shortDescription: 'Programme Aim'
            });
            httpBackend.whenPUT('/api/mathsConditionOfFundings/1').respond(200, {
                id: 1,
                code: '1',
                description: 'Programme aim',
                shortDescription: 'Programme Aim'
            });
            mathsConditionOfFunding = $injector.get('MathsConditionOfFunding');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the mathsConditionOfFundings', function() {
            httpBackend.expectGET('/api/mathsConditionOfFundings/');
            mathsConditionOfFunding.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific mathsConditionOfFunding', function() {
            httpBackend.expectGET('/api/mathsConditionOfFundings/1');
            mathsConditionOfFunding.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new mathsConditionOfFunding', inject(function($http) {
            httpBackend.expectPOST('/api/mathsConditionOfFundings/', {
                code: '1'
            });
            mathsConditionOfFunding.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing aimtype', function() {
            httpBackend.expectPUT('/api/mathsConditionOfFundings/1', {
                id: 1,
                code: '1',
                description: 'Programme aim',
                shortDescription: 'Programme Aim'
            });
            mathsConditionOfFunding.save({
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
