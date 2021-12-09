(function() {
    'use strict';

    describe('AttendanceCodeService', function() {

        var httpBackend;
        var attendanceCode;

        beforeEach(module('AttendanceCodeService'));
        beforeEach(module('ui-notification'));
        beforeEach(inject(function($injector) {
            httpBackend = $injector.get('$httpBackend');
            httpBackend.whenGET('/api/attendanceCodes/').respond(200, [{
                id: 1,
                code: '2',
                description: 'Absent',
                registerMark: '/',
                absence: false,
                authorisedAbsence: false,
                late: false,
                authorisedLate: false,
                included: true,
                lastDateOfAttendance: true,
                htmlColour: null,
                accessColour: null
            }]);
            httpBackend.whenGET('/api/attendanceCodes/1').respond(200, {});
            httpBackend.whenPOST('/api/attendanceCodes/').respond(201, {});
            httpBackend.whenPUT('/api/attendanceCodes/2').respond(200, {});
            attendanceCode = $injector.get('AttendanceCode');
        }));

        afterEach(function() {
            httpBackend.verifyNoOutstandingRequest();
            httpBackend.verifyNoOutstandingExpectation();

        });

        it('should GET for api to retrieve all the attendanceCodes', function() {
            httpBackend.expectGET('/api/attendanceCodes/');
            attendanceCode.query();
            httpBackend.flush();
        });


        it('should GET from api to retrieve a specific attendanceCode', function() {
            httpBackend.expectGET('/api/attendanceCodes/1');
            attendanceCode.get(1);
            httpBackend.flush();
        });

        it('should POST to api to create a new attendanceCode', inject(function($http) {
            httpBackend.expectPOST('/api/attendanceCodes/', {
                code: '1'
            });
            attendanceCode.create({
                code: '1'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        }));

        it('should PUT to api to update an existing attendanceCode', function() {
            httpBackend.expectPUT('/api/attendanceCodes/2', {
                id: 2,
                code: '1',
                description: 'Present'
            });
            attendanceCode.save({
                id: 2,
                code: '1',
                description: 'Present'
            }).then(function(response) {
                expect(response).toBeDefined();
                expect(response.data).toBeDefined();
            });
            httpBackend.flush();
        });
    });

})();
