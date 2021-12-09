(function() {
    'use strict';

    describe('ExternalResultsArchiveService', function() {

        var httpBackend;
        var externalResultsArchive;

        beforeEach(module('ExternalResultsArchiveService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/students/').respond(200, [{
                id: 1,
                levelDescription: '2',
                mark: 'GCSE',
                studentId: 17001
            }]);
            externalResultsArchive = $injector.get('ExternalResultsArchive');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the externalResultsArchives', function() {
            httpBackend.expectGET('/api/students/');
            externalResultsArchive.query();
            httpBackend.flush();
        });
    });

})();
