angular.module('credibancoApp')
    .controller('DeleteCardController', function($scope, $http, $uibModal) {
        $scope.card = {};

        $scope.deleteCard = function() {
            $http.post('/api/card/delete', $scope.card)
                .then(function(response) {
                    console.log(response);
                    if (response.data.responseCode === '00') {
                        $uibModal.open({
                            template: '<div class="modal-body">{{message}}</div>',
                            controller: function($scope) {
                                $scope.message = response.data.messageCode;
                            }
                        });
                    } else {
                        $uibModal.open({
                            template: '<div class="modal-body">{{message}}</div>',
                            controller: function($scope) {
                                $scope.message = response.data.messageCode + " Error " + response.data.responseCode;
                            }
                        });
                    }
                });
        };
    });