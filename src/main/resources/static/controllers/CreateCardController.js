angular.module('credibancoApp')
    .controller('CreateCardController', function($scope, $http, $uibModal,$location, CardService) {
        $scope.card = {};
		$scope.enrollEnabled = false;
		
		$scope.enrollCard = function(){
			$location.path('enroll-card')
		};
        $scope.createCard = function() {
            $http.post('/api/card/create', $scope.card)
                .then(function(response) {
                    console.log(response);
                    if (response.data.responseCode === '00') {
						 $scope.enrollEnabled = true;
                        CardService.setCardData({
                            pan: $scope.card.pan,
                            validationNumber: response.data.validationNumber
                        });
                        $uibModal.open({
                            template: '<div class="modal-body">{{message}}</div>',
                            controller: function($scope) {
                                $scope.message = response.data.messageCode+" No olvides enrolar la nueva tarjeta";
                            }
                        });
                    }else{
						$uibModal.open({
                            template: '<div class="modal-body">{{message}}</div>',
                            controller: function($scope) {
                                $scope.message = response.data.messageCode+" Error "+response.data.responseCode;
                            }
                        });
                    }
                });
        };
 });