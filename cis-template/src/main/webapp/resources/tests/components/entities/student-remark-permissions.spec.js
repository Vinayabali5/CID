(function() {
    'use strict';

    describe('StudentRemarkPermissionService', function() {

        var httpBackend;
        var studentRemarkPermission;

        beforeEach(module('StudentRemarkPermissionService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/studentRemarkPermissions/').respond(200, [{
                id: 1,
                code: '1',
                description: 'Programme note'
            }]);
            httpBackend.whenGET('/api/studentRemarkPermissions/1').respond(200, {});
            httpBackend.whenPOST('/api/studentRemarkPermissions/').respond(201, {});
            httpBackend.whenPUT('/api/studentRemarkPermissions/1').respond(200, {});
            studentRemarkPermission = $injector.get('StudentRemarkPermission');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the studentRemarkPermissions', function() {
            httpBackend.expectGET('/api/studentRemarkPermissions/');
            studentRemarkPermission.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific studentRemarkPermission', function() {
            httpBackend.expectGET('/api/studentRemarkPermissions/1');
            studentRemarkPermission.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new studentRemarkPermission', inject(function($http) {
            httpBackend.expectPOST('/api/studentRemarkPermissions/', {
                code: '1'
            });
            studentRemarkPermission.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing notetype', function() {
            httpBackend.expectPUT('/api/studentRemarkPermissions/1', {
                id: 1,
                code: '1',
                description: 'Programme note'
            });
            studentRemarkPermission.save({
                id: 1,
                code: '1',
                description: 'Programme note'
            }, function() {}).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();
