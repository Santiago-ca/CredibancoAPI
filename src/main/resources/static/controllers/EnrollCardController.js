angular.module('credibancoApp')
    .controller('EnrollCardController', function($scope, $http, CardService) {
        $scope.card = CardService.getCardData();

        $scope.enrollCard = function() {
            $http.post('/api/card/enroll', $scope.card)
                .then(function(response) {
                    console.log(response);
                }, function(response) {
                    console.log(response);
                });
        };
    });