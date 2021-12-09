(function() {
    'use strict';

    describe('CompletionStatusService', function() {

        var httpBackend;
        var completionStatus;

        beforeEach(module('CompletionStatusService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/completionStatuses/').respond(200, [{
                id: 1,
                code: '1',
                description: 'Programme aim',
                shortDescription: 'Programme Aim'
            }]);
            httpBackend.whenGET('/api/completionStatuses/1').respond(200, {});
            httpBackend.whenPOST('/api/completionStatuses/').respond(201, {});
            httpBackend.whenPUT('/api/completionStatuses/1').respond(200, {});
            completionStatus = $injector.get('CompletionStatus');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the completionStatuss', function() {
            httpBackend.expectGET('/api/completionStatuses/');
            completionStatus.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific completionStatus', function() {
            httpBackend.expectGET('/api/completionStatuses/1');
            completionStatus.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new completionStatus', inject(function($http) {
            httpBackend.expectPOST('/api/completionStatuses/', {
                code: '1'
            });
            completionStatus.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing completionStatus', function() {
            httpBackend.expectPUT('/api/completionStatuses/1', {
                id: 1,
                code: '1',
                description: 'Programme aim',
                shortDescription: 'Programme Aim'
            });
            completionStatus.save({
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
