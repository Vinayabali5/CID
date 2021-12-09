(function() {
    'use strict';

    describe('ILPInterviewTypeService', function() {

        var httpBackend;
        var iLPInterviewType;

        beforeEach(module('ILPInterviewTypeService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/iLPInterviewTypes/').respond(200, [{
                id: 1,
                type: '2'
            }]);
            httpBackend.whenGET('/api/iLPInterviewTypes/1').respond(200, {});
            httpBackend.whenPUT('/api/iLPInterviewTypes/2').respond(200, {});
            iLPInterviewType = $injector.get('ILPInterviewType');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the iLPInterviewTypes', function() {
            httpBackend.expectGET('/api/iLPInterviewTypes/');
            iLPInterviewType.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific iLPInterviewType', function() {
            httpBackend.expectGET('/api/iLPInterviewTypes/1');
            iLPInterviewType.get(1);
            httpBackend.flush();
        });

        it('should PUT to api to update an existing iLPInterviewType', function() {
            httpBackend.expectPUT('/api/iLPInterviewTypes/2', {
                id: 2,
                type: '2'
            });
            iLPInterviewType.save({
                id: 2,
                type: '2'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();
