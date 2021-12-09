describe('ApplicationFormService', function() {

    var httpBackend;
    var applicationForm;

    beforeEach(module('cid.service.data.admission.application-form'));

    beforeEach(inject(function($injector) {
        httpBackend = $injector.get('$httpBackend');
        httpBackend.whenGET('/api/applications/180001').respond(200, {});
        httpBackend.whenPUT('/api/applications/180001').respond(200, {
            id: 18,
            code: '18/19',
            description: '2018/19'
        });
        applicationForm = $injector.get('ApplicationForm');
    }));

    afterEach(function() {
        httpBackend.verifyNoOutstandingRequest();
        httpBackend.verifyNoOutstandingExpectation();

    });

    it('should GET from api to retrieve a specific application form', function() {
        httpBackend.expectGET('/api/applications/180001');
        applicationForm.get(180001);
        httpBackend.flush();
    });

});
