const POINT_MAP = {
    0: 'Love',
    1: 'Fifteen',
    2: 'Thirty',
    3: 'Forty'
}

function TennisGame(player1Name, player2Name) {
    this._player1 = player1Name;
    this._player2 = player2Name;

    this.p1Point = 0;
    this.p2Point = 0;
}

TennisGame.prototype = {

    player1Point: function() {
        this.p1Point++;
    },

    player2Point: function() {
        this.p2Point++;
    },

    getResult: function() {
        if(this.p1Point == this.p2Point) {
            return POINT_MAP[this.p1Point] + ' All';
        }
        else {
            return POINT_MAP[this.p1Point] + ' - ' + POINT_MAP[this.p2Point];
        }
        
    }
}


module.exports = TennisGame;