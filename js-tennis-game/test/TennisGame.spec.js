var expect = require('expect.js');
var TennisGame = require('../src/TennisGame');

describe('Example Test', function () {
  it('This test should pass', function () {
    expect(1+2).to.equal(3);
  });

});


describe('This is a TennisGame', function() {

    var game;

    // runs before each test in this block
    beforeEach(function() {
      game = new TennisGame("Mario", "Luigi");
    });

    it('0-0 => Love all', function () {
        expect(game.getResult()).to.equal('Love All');
    });

    it('1-0 => "Fifteen love"', function () {
        game.player1Score();

        expect(game.getResult()).to.equal('Fifteen - Love');
    });
});
