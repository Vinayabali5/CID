(function() {
    'use strict';

    describe('CorrespondenceTypeService', function() {

        var httpBackend;
        var correspondenceType;

        beforeEach(module('CorrespondenceTypeService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/correspondenceTypes/').respond(200, [{
                id: 1,
                type: 'Programme correspondence'
            }]);
            httpBackend.whenGET('/api/correspondenceTypes/1').respond(200, {});
            httpBackend.whenPUT('/api/correspondenceTypes/1').respond(200, {});
            correspondenceType = $injector.get('CorrespondenceType');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the correspondenceTypes', function() {
            httpBackend.expectGET('/api/correspondenceTypes/');
            correspondenceType.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific correspondenceType', function() {
            httpBackend.expectGET('/api/correspondenceTypes/1');
            correspondenceType.get(1);
            httpBackend.flush();
        });

        it('should PUT to api to update an existing correspondencetype', function() {
            httpBackend.expectPUT('/api/correspondenceTypes/1', {
                id: 1,
                type: 'Programme correspondence'
            });
            correspondenceType.save({
                id: 1,
                type: 'Programme correspondence'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();
