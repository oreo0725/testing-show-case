function TennisGame(player1Name, player2Name) {
    this._player1 = player1Name;
    this._player2 = player2Name;

    this.p1Point = 0;
    this.p2Point = 0;
}

TennisGame.prototype = {

    player1Score: function() {
        this.p1Point++;
    },

    getResult: function() {
        if(this.p1Point == 1) {
            return 'Fifteen - Love';
        }
        return 'Love All';
    }
}


module.exports = TennisGame;