(function() {
    'use strict';

    describe('EnglishConditionOfFundingService', function() {

        var httpBackend;
        var englishConditionOfFunding;

        beforeEach(module('EnglishConditionOfFundingService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/englishConditionOfFundings/').respond(200, [{
                id: 1,
                code: '1',
                description: 'Programme aim',
                shortDescription: 'Programme Aim'
            }]);
            httpBackend.whenGET('/api/englishConditionOfFundings/1').respond(200, {});
            httpBackend.whenPOST('/api/englishConditionOfFundings/').respond(201, {});
            httpBackend.whenPUT('/api/englishConditionOfFundings/1').respond(200, {});
            englishConditionOfFunding = $injector.get('EnglishConditionOfFunding');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the englishConditionOfFundings', function() {
            httpBackend.expectGET('/api/englishConditionOfFundings/');
            englishConditionOfFunding.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific englishConditionOfFunding', function() {
            httpBackend.expectGET('/api/englishConditionOfFundings/1');
            englishConditionOfFunding.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new englishConditionOfFunding', inject(function($http) {
            httpBackend.expectPOST('/api/englishConditionOfFundings/', {
                code: '1'
            });
            englishConditionOfFunding.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing aimtype', function() {
            httpBackend.expectPUT('/api/englishConditionOfFundings/1', {
                id: 1,
                code: '1',
                description: 'Programme aim',
                shortDescription: 'Programme Aim'
            });
            englishConditionOfFunding.save({
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
