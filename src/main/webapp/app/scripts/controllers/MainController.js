/**
 * Created by root on 29/07/15.
 */
angular.module('acomApp')
    .controller('MainCtrl', function ($scope, MainService, $timeout) {
        $scope.test = "old";
        $scope.files = [];

        MainService.getFiles().then(function (data) {
            $scope.files = data;
        });

        $scope.onFileSelect = function (files) {
            console.log(files.files);
            var formData = new FormData();
            formData.append("file", files.files[0]);

            MainService.saveFile(formData);

            $timeout(function () {
                MainService.getFiles().then(function (data) {
                    $scope.files = data;
                });
            }, 2000);
        };
    });