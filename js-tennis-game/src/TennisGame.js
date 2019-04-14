function TennisGame(player1Name, player2Name) {
    this._player1 = player1Name;
    this._player2 = player2Name;
}

TennisGame.prototype = {

    player1Score: function() {

    },

    getResult: function() {
        return 'Love All';
    }
}


module.exports = TennisGame;