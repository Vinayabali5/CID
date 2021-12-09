angular.module('ExamBoardTableDirective')
    .controller('ExamBoardTableDirectiveController', function($log, $scope, $state, ExamBoard) {
        console.log('ExamBoardTableDirectiveController loaded');

        $scope.searchTerm = '';
        //	$scope.examBoardList = [];

        /*	$scope.paginationInfo = {
        			pageNumber : 1,
        			pageSize : 10,
        			sort : 'name',
        			order : 'ASC',
        			maxSize : 5
        	};
        */

        /*	$scope.setSort = function(column) {
        		if ($scope.paginationInfo.sort != column) {
        			$scope.paginationInfo.sort = column;
        			$scope.paginationInfo.order = 'ASC';
        			$scope.orderReverse = false;
        		} else {
        			$scope.orderReverse = !$scope.orderReverse;
        			if ($scope.orderReverse) {
        				$scope.paginationInfo.order = 'DESC';
        			} else {
        				$scope.paginationInfo.order = 'ASC';
        			}
        		}
        		$scope.getSyllabusPage();
        	};
        */

        $scope.setCurrentExamBoard = function(newExamBoard) {
            $scope.curExamBoard = newExamBoard;
        };

        $scope.getPage = function() {
            console.log('Loading page: ' + $scope.paginationInfo.pageNumber);
            ExamBoard.query({
                page: this.paginationInfo.pageNumber - 1,
                size: this.paginationInfo.pageSize,
                sort: this.paginationInfo.sort + ',' + this.paginationInfo.order
            }, function(data, header) {
                $scope.paginationInfo.pageNumber = data.page.number + 1;
                $scope.paginationInfo.pageSize = data.page.size;
                $scope.paginationInfo.totalItems = data.page.totalElements;
                $scope.paginationInfo.totalPages = data.page.totalPages;
                $scope.examBoardList = data.examBoardDtos;
            });
        };

        $scope.pageChanged = function() {
            console.log('Page changed to: ' + $scope.paginationInfo.pageNumber);
            $scope.getPage();
        };

        $scope.loadExamBoards = function() {
            $log.debug('$scope.loadExamBoards');
            ExamBoard.query().success(function(data) {
                $scope.examBoardList = data;
            });
        };

        $scope.search = function() {
            console.log('$scope.search');
            var search = $scope.searchTerm;
            var url = this.url;
            if (search.size > 3) {
                var appList = this.applicationList;
                $http.get(url).success(function(response) {
                    $scope.examBoardList = response;
                });
            }
        };

        //$scope.init();
        //$scope.getPage();
        $scope.loadExamBoards();
    });
