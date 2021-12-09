/**
 * This is the Word Generator Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';
    angular
        .module('WordGeneratorDirective')
        .controller('WordGeneratorDirectiveController', wordGeneratorDirectiveController);

    wordGeneratorDirectiveController.$inject = ['$log', '$scope', '$rootScope', '$http', 'GLOBAL'];

    function wordGeneratorDirectiveController($log, $scope, $rootScope, $http, GLOBAL) {
        /* jshint validthis:true */
        var vm = this;

        vm.studentLetter = studentLetter;
        vm.parentLetter = parentLetter;


        function downloadFile(url, filename) {
            var a = document.createElement("a");
            document.body.appendChild(a);
            a.style = "display: none";

            $http.get(url, {
                responseType: 'arraybuffer'
            }).then(function(reponse) {
                var file = new Blob([reponse.data], {
                    type: 'application/vnd.openxmlformats-officedocument.wordprocessingml.document'
                });
                var fileURL = window.URL.createObjectURL(file);
                a.href = fileURL;
                a.download = filename;
                a.click();
                document.body.removeChild(a);
            });

        }

        function studentLetter(studentId) {
            downloadFile(GLOBAL.API + '/wordGenerator/studentLetter/' + studentId, 'student-letter-' + studentId + '.docx');
        }

        function parentLetter(studentId) {
            downloadFile(GLOBAL.API + '/wordGenerator/parentLetter/' + studentId, 'parent-letter-' + studentId + '.docx');
        }
    }

})();
