/**
 * @author <a href="mailto:koolrich@gmail.com">Richard Nduka</a>
 */

'use strict'

describe('designationControllers', function(){
    var $scope, ctrl;
    beforeEach(module("admin"));

    beforeEach(function(){
        this.addMatchers({
            toEqualData: function(expected){
                return angular.equals(this.actual, expected);
            }
        });
    });

    describe('DesignationListCtrl', function(){
        beforeEach(inject(function($rootScope, $controller){
            $scope = $rootScope.$new();
            ctrl = $controller('DesignationListCtrl', {
                $scope: $scope,
                designations: [{designationId:1, name: "Java Developer"}, {designationId:2, name:"Sales Executive"}]
            });
        }));

        it ('should have a list of designations', function(){
            expect($scope.designations).toEqualData([{designationId:1, name: "Java Developer"},
                {designationId:2, name:"Sales Executive"}]);
        });
    });
})
