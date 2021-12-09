angular.module('cid.tests').controller('TestStudentSpecialCategoryController', function($log, $scope, StudentSpecialCategory) {
    var vm = this;


    this.studentSpecialCategories = [];
    this.studentId = 131168;


    this.init = function() {
        $log.log('StudentSpecialCategoryRecordsController::loadStudentSpecialCategory called');
        this.getStudentSpecialCategory();
    };

    this.getStudentSpecialCategory = function(id) {
        var lookupStudentSpecialCategoryId;
        if (id) {
            lookupStudentSpecialCategoryId = id;
        } else {
            lookupStudentSpecialCategoryId = this.studentId;
        }

        StudentSpecialCategory.getForm(vm.studentId).then(function(response) {
            $log.log(response.data);
            vm.studentSpecialCategories = response.data;
        }, function(response) {
            $log.log("EE - Failed to retrieve data for register");
        });
    };

    this.init();
});
