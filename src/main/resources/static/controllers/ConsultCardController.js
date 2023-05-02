angular.module('credibancoApp')
    .controller('ConsultCardController', function($scope, $http) {
        $scope.card = {};
        $scope.cardDetails = null;

        $scope.consultCard = function() {
            $http.get('api/card', { params: { pan: $scope.card.pan } })
                .then(function(response) {
                    console.log(response);
                    $scope.cardDetails = response.data;
                }, function(response) {
                    console.log(response);
                });
        };
    });