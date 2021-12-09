(function() {
    'use strict';

    describe('BlockService', function() {

        var httpBackend;
        var block;

        beforeEach(module('BlockService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/blocks/').respond(200, [{
                id: 1,
                code: '2',
                description: 'Block B',
                htmlColour: '/'
            }]);
            httpBackend.whenGET('/api/blocks/1').respond(200, {});
            httpBackend.whenPOST('/api/blocks/').respond(201, {});
            httpBackend.whenPUT('/api/blocks/2').respond(200, {});
            block = $injector.get('Block');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the blocks', function() {
            httpBackend.expectGET('/api/blocks/');
            block.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific block', function() {
            httpBackend.expectGET('/api/blocks/1');
            block.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new block', inject(function($http) {
            httpBackend.expectPOST('/api/blocks/', {
                code: '1'
            });
            block.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing block', function() {
            httpBackend.expectPUT('/api/blocks/2', {
                id: 2,
                code: '1',
                description: 'Block A',
                htmlColour: '/'
            });
            block.save({
                id: 2,
                code: '1',
                description: 'Block A',
                htmlColour: '/'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();
