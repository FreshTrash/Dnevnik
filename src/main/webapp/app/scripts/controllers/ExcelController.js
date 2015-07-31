/**
 * Created by root on 29/07/15.
 */
angular.module('acomApp')
    .controller('ExcelCtrl', function ($scope, $stateParams, MainService) {
        $scope.limit = 5;
        $scope.rows = [];

        MainService.getFile($stateParams.id).then(function (data) {
            console.log(data);
            $scope.rows = data;
        });
    });