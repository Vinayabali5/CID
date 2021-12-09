(function() {
    'use strict';

    describe('NoteTypeService', function() {

        var httpBackend;
        var noteType;

        beforeEach(module('NoteTypeService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/noteTypes/').respond(200, [{
                id: 1,
                code: '1',
                description: 'Programme note'
            }]);
            httpBackend.whenGET('/api/noteTypes/1').respond(200, {});
            httpBackend.whenPOST('/api/noteTypes/').respond(201, {
                id: 1,
                code: '1',
                description: 'Programme note'
            });
            httpBackend.whenPUT('/api/noteTypes/1').respond(200, {
                id: 1,
                code: '1',
                description: 'Programme note'
            });
            noteType = $injector.get('NoteType');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the noteTypes', function() {
            httpBackend.expectGET('/api/noteTypes/');
            noteType.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific noteType', function() {
            httpBackend.expectGET('/api/noteTypes/1');
            noteType.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new noteType', inject(function($http) {
            httpBackend.expectPOST('/api/noteTypes/', {
                code: '1'
            });
            noteType.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing notetype', function() {
            httpBackend.expectPUT('/api/noteTypes/1', {
                id: 1,
                code: '1',
                description: 'Programme note'
            });
            noteType.save({
                id: 1,
                code: '1',
                description: 'Programme note'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();
