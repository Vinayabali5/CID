(function() {
    'use strict';

    describe('OutcomeService', function() {

        var httpBackend;
        var outcome;

        beforeEach(module('OutcomeService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/outcomes/').respond(200, [{
                id: 1,
                code: '1',
                description: 'Programme aim',
                shortDescription: 'Programme Aim'
            }]);
            httpBackend.whenGET('/api/outcomes/1').respond(200, {});
            httpBackend.whenPOST('/api/outcomes/').respond(201, {});
            httpBackend.whenPUT('/api/outcomes/1').respond(200, {});
            outcome = $injector.get('Outcome');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the outcomes', function() {
            httpBackend.expectGET('/api/outcomes/');
            outcome.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific outcome', function() {
            httpBackend.expectGET('/api/outcomes/1');
            outcome.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new outcome', inject(function($http) {
            httpBackend.expectPOST('/api/outcomes/', {
                code: '1'
            });
            outcome.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing aimtype', function() {
            httpBackend.expectPUT('/api/outcomes/1', {
                id: 1,
                code: '1',
                description: 'Programme aim',
                shortDescription: 'Programme Aim'
            });
            outcome.save({
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
