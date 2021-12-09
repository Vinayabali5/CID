(function() {
    'use strict';

    describe('PriorAttainmentService', function() {

        var httpBackend;
        var priorAttainment;

        beforeEach(module('PriorAttainmentService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/priorAttainments/').respond(200, [{
                id: 1,
                code: '1',
                description: 'Programme aim',
                shortDescription: 'Programme Aim'
            }]);
            httpBackend.whenGET('/api/priorAttainments/1').respond(200, {});
            httpBackend.whenPOST('/api/priorAttainments/').respond(201, {});
            httpBackend.whenPUT('/api/priorAttainments/1').respond(200, {});
            priorAttainment = $injector.get('PriorAttainment');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the priorAttainments', function() {
            httpBackend.expectGET('/api/priorAttainments/');
            priorAttainment.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific priorAttainment', function() {
            httpBackend.expectGET('/api/priorAttainments/1');
            priorAttainment.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new priorAttainment', inject(function($http) {
            httpBackend.expectPOST('/api/priorAttainments/', {
                code: '1'
            });
            priorAttainment.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing aimtype', function() {
            httpBackend.expectPUT('/api/priorAttainments/1', {
                id: 1,
                code: '1',
                description: 'Programme aim',
                shortDescription: 'Programme Aim'
            });
            priorAttainment.save({
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
