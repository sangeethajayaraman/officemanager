'use strict';

/* jasmine specs for controllers go here */

describe('controllers', function() {
    beforeEach(module('officemanager'));

    describe('PositionListController', function(){

        it('should create "positions" model with 3 positions', inject(function($controller) {
            var scope = {},
                ctrl = $controller('PositionListController', { $scope: scope });

            expect(scope.positions.length).toBe(2);
        }));
    });
});
