'use strict';

adminModule.controller('DesignationListCtrl', ['$scope', 'designations', function($scope, designations){
    $scope.designations = designations;
}])

