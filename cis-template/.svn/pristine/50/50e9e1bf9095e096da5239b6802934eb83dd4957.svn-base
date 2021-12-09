(function() {
    'use strict';

    describe('LLDDHealthProblemService', function() {

        var httpBackend;
        var lLDDHealthProblem;

        beforeEach(module('LLDDHealthProblemService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/lLDDHealthProblems/').respond(200, [{
                id: 1,
                code: '1',
                description: 'Programme aim',
                shortDescription: 'Programme Aim'
            }]);
            httpBackend.whenGET('/api/lLDDHealthProblems/1').respond(200, {});
            httpBackend.whenPOST('/api/lLDDHealthProblems/').respond(201, {});
            httpBackend.whenPUT('/api/lLDDHealthProblems/1').respond(200, {});
            lLDDHealthProblem = $injector.get('LLDDHealthProblem');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the lLDDHealthProblemCategories', function() {
            httpBackend.expectGET('/api/lLDDHealthProblems/');
            lLDDHealthProblem.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific lLDDHealthProblem', function() {
            httpBackend.expectGET('/api/lLDDHealthProblems/1');
            lLDDHealthProblem.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new lLDDHealthProblem', inject(function($http) {
            httpBackend.expectPOST('/api/lLDDHealthProblems/', {
                code: '1'
            });
            lLDDHealthProblem.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing aimtype', function() {
            httpBackend.expectPUT('/api/lLDDHealthProblems/1', {
                id: 1,
                code: '1',
                description: 'Programme aim',
                shortDescription: 'Programme Aim'
            });
            lLDDHealthProblem.save({
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
