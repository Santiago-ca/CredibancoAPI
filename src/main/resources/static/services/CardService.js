angular.module('credibancoApp')
    .factory('CardService', function() {
        var cardData = {};

        return {
            setCardData: function(data) {
                cardData = data;
            },
            getCardData: function() {
                return cardData;
            }
        };
    });