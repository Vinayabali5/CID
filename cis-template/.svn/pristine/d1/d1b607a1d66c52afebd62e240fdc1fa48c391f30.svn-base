(function() {
    'use strict';

    describe('AttendanceMonitoringService', function() {

        var httpBackend;
        var attendanceMonitoring;

        beforeEach(module('AttendanceMonitoringService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/attendanceMonitorings/').respond(200, [{
                id: 1,
                code: '2',
                description: 'Absent',
                warningColour: '/'
            }]);
            httpBackend.whenGET('/api/attendanceMonitorings/1').respond(200, {});
            httpBackend.whenPOST('/api/attendanceMonitorings/').respond(201, {});
            httpBackend.whenPUT('/api/attendanceMonitorings/2').respond(200, {});
            attendanceMonitoring = $injector.get('AttendanceMonitoring');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the attendanceMonitorings', function() {
            httpBackend.expectGET('/api/attendanceMonitorings/');
            attendanceMonitoring.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific attendanceMonitoring', function() {
            httpBackend.expectGET('/api/attendanceMonitorings/1');
            attendanceMonitoring.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new attendanceMonitoring', inject(function($http) {
            httpBackend.expectPOST('/api/attendanceMonitorings/', {
                code: '1'
            });
            attendanceMonitoring.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing attendanceMonitoring', function() {
            httpBackend.expectPUT('/api/attendanceMonitorings/2', {
                id: 2,
                code: '1',
                description: 'Present',
                warningColour: '/'
            });
            attendanceMonitoring.save({
                id: 2,
                code: '1',
                description: 'Present',
                warningColour: '/'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();
