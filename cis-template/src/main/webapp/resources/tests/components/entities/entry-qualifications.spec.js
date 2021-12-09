(function() {
    'use strict';

    describe('EntryQualificationService', function() {

        var httpBackend;
        var entryQualification;

        beforeEach(module('EntryQualificationService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/entryQualifications/').respond(200, [{
                id: 1,
                basicList: true,
                dataMatchCode: 'EntryQualification B',
                entryQualificationTypeId: 3
            }]);
            httpBackend.whenGET('/api/entryQualifications/1').respond(200, {});
            httpBackend.whenPOST('/api/entryQualifications/').respond(201, {});
            httpBackend.whenPUT('/api/entryQualifications/1').respond(200, {});
            entryQualification = $injector.get('EntryQualification');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the entryQualifications', function() {
            httpBackend.expectGET('/api/entryQualifications/');
            entryQualification.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific entryQualification', function() {
            httpBackend.expectGET('/api/entryQualifications/1');
            entryQualification.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new entryQualification', inject(function($http) {
            httpBackend.expectPOST('/api/entryQualifications/', {
                basicList: true,
                dataMatchCode: 'EntryQualification B',
                entryQualificationTypeId: 3
            });
            entryQualification.create({
                basicList: true,
                dataMatchCode: 'EntryQualification B',
                entryQualificationTypeId: 3
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing entryQualification', function() {
            httpBackend.expectPUT('/api/entryQualifications/1', {
                id: 1,
                basicList: true,
                dataMatchCode: 'EntryQualification B',
                entryQualificationTypeId: 3
            });
            entryQualification.save({
                id: 1,
                basicList: true,
                dataMatchCode: 'EntryQualification B',
                entryQualificationTypeId: 3
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();
