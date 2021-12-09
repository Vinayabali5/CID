(function() {
    'use strict';

    describe('TitleService', function() {

        var httpBackend;
        var title;

        beforeEach(module('TitleService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/titles/').respond(200, [{
                id: 1,
                code: '1',
                description: 'mrs'
            }]);
            httpBackend.whenGET('/api/titles/1').respond(200, {});
            httpBackend.whenPOST('/api/titles/').respond(201, {});
            httpBackend.whenPUT('/api/titles/1').respond(200, {});
            title = $injector.get('Title');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the titles', function() {
            httpBackend.expectGET('/api/titles/');
            title.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific title', function() {
            httpBackend.expectGET('/api/titles/1');
            title.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new title', inject(function($http) {
            httpBackend.expectPOST('/api/titles/', {
                code: '1'
            });
            title.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing notetype', function() {
            httpBackend.expectPUT('/api/titles/1', {
                id: 1,
                code: '1',
                description: 'mrs'
            });
            title.save({
                id: 1,
                code: '1',
                description: 'mrs'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();
