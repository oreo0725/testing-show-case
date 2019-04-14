var expect = require('expect.js');
var TennisGame = require('../src/TennisGame');

describe('Example Test', function () {
  it('This test should pass', function () {
    expect(1+2).to.equal(3);
  });

});


describe('This is a TennisGame', function() {

    var game;
    
    function assertGameResultIs(result) {
        expect(game.getResult()).to.equal(result);
    }
    // runs before each test in this block
    beforeEach(function() {
      game = new TennisGame("Mario", "Luigi");
    });

    it('0-0 => Love all', function () {
        assertGameResultIs('Love All');
    });

    it('1-0 => "Fifteen love"', function () {
        game.player1Point();

        assertGameResultIs('Fifteen - Love');
    });

    it('2-0 => "Thirty Love"', function () {
        game.player1Point();
        game.player1Point();

        assertGameResultIs('Thirty - Love');
    });

    it('3-0 => "Forty Love"', function () {
        game.player1Point();
        game.player1Point();
        game.player1Point();

        assertGameResultIs('Forty - Love');
        // expect(game.getWinner()).to.equal('Mario');
    });

    it('0-1 => "love Fifteen"', function () {
        game.player2Point();

        assertGameResultIs('Love - Fifteen');
    });

    it('1-1 => "Fifteen all"', function () {
        game.player1Point();
        game.player2Point();

        assertGameResultIs('Fifteen All');
    });

    it('3-3 => "Deuce"', function () {
        game.player1Point();
        game.player2Point();

        assertGameResultIs('Fifteen All');
    });

});


