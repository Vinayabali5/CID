describe('student-withdrawal directive', function() {

    beforeEach(module('ui.bootstrap.modal'));

    beforeEach(module('html'));
    beforeEach(module('StudentService'));
    beforeEach(module('StudentWithdrawalDirective'));

    beforeEach(inject(function(_$compile_, _$rootScope_) {
        // The injector unwraps the underscores (_) from around the parameter names when matching
        $compile = _$compile_;
        $rootScope = _$rootScope_;
    }));

    it('should display a button on the screen', function() {
        var element = $compile("<student-withdrawal></student-withdrawal>")($rootScope);
        $rootScope.$digest();
        expect(element.html()).toContain("<button");
        expect(element.html()).toContain('Withdraw Student');
        expect(element.html()).toContain("</button>");
    });

    it('should validate the user input when editing the data', function() {

    });

    describe('StudentWithdrawalController', function() {
        var $controller;

        beforeEach(inject(function(_$controller_, _$uibModal_) {
            $uibModal = _$uibModal_;
            $controller = _$controller_('StudentWithdrawalController', {
                $scope: {}
            });
            fakeModal = {};
            spyOn($uibModal, 'open').and.returnValue(fakeModal);
        }));

        it('should not open the modal dialog box if studentId and yearId are not set', function() {
            expect($controller.studentId).not.toBeDefined();
            expect($controller.yearId).not.toBeDefined();
            $controller.withdrawStudent();
            expect($uibModal.open).not.toHaveBeenCalled();
        });

        it('should not open the modal dialog box if studentId is not set', function() {
            $controller.yearId = 18;
            expect($controller.studentId).not.toBeDefined();
            expect($controller.yearId).toBeDefined();
            $controller.withdrawStudent();
            expect($uibModal.open).not.toHaveBeenCalled();
        });

        it('should not open the modal dialog box if yearId is not set', function() {
            $controller.studentId = 180000;
            expect($controller.studentId).toBeDefined();
            expect($controller.yearId).not.toBeDefined();
            $controller.withdrawStudent();
            expect($uibModal.open).not.toHaveBeenCalled();
        });

        it('should open the modal dialog box if studentId and yearId are set', function() {
            $controller.studentId = 180000;
            $controller.yearId = 18;
            $controller.withdrawStudent();
            expect($uibModal.open).toHaveBeenCalled();
        });

    });

    describe('StudentWithdrawalDialogController', function() {
        //$log, $rootScope, $uibModalInstance, studentYearEntity, Student
        var $controller;
        var MockStudentService;

        var modalInstance = {
            close: function() {},
            dismiss: function() {}
        };
        var MockStudentYear = {
            studentId: 180000,
            yearId: 18,
            destinationId: 1,
            endDate: null,
            collegeEmployer: null,
            courseCareer: null
        };


        beforeEach(inject(function(_$controller_) {
            MockStudentService = jasmine.createSpyObj('StudentService', ['withdraw']);
            MockStudentService.withdraw.and.returnValue({
                then: function() {}
            });
            $controller = _$controller_('StudentWithdrawalDialogController', {
                $rootScope: {},
                $uibModalInstance: modalInstance,
                studentYearEntity: MockStudentYear,
                Student: MockStudentService
            });
        }));

        it('should set a studentYear variable based on the studentYearEntity supplied', function() {
            expect($controller.studentYear).toBeDefined();
            expect($controller.studentYear).toBe(MockStudentYear);
        });

        it('should create a withdrawalRequest variable based on the studentYearEntity supplied', function() {
            expect($controller.withdrawalRequest).toBeDefined();
            expect($controller.withdrawalRequest.studentId).toBe(MockStudentYear.studentId);
            expect($controller.withdrawalRequest.yearId).toBe(MockStudentYear.yearId);
            expect($controller.withdrawalRequest.destinationId).toBe(MockStudentYear.destinationId);
            expect($controller.withdrawalRequest.withdrawalDate).toBe(MockStudentYear.endDate);
            expect($controller.withdrawalRequest.withdrawalResonId).toBe(MockStudentYear.withdrawalResonId);
            expect($controller.withdrawalRequest.collegeEmployer).toBe(MockStudentYear.destinationCollegeEmployer);
            expect($controller.withdrawalRequest.courseCareer).toBe(MockStudentYear.destinationCourseCareer);
        });

        it('should execute the Student service withdraw method when the withdraw command is called', function() {
            expect($controller.withdrawalRequest).toBeDefined();
            $controller.withdraw();
            expect(MockStudentService.withdraw).toHaveBeenCalled();
        });



    });

});
