package org.courseproject.core;

import org.courseproject.interfaces.HandleTurn;

public class DealerTurn implements HandleTurn {
    @Override
    public void executeTurn(Game game) {
        if (!game.isPlayerTurn()) {
            game.displayTable();
        }
        int dealerLimit = 17;
        while (game.getDealer().getHandValue() < dealerLimit) {
            game.getDealer().addCard(game.getDeck().dealCard());
            game.printHit(game.getDealer());
            game.displayTable();
            if (game.getDealer().getHandValue() > Game.getInstance().getValueLimit()) {
                game.printBusted(game.getDealer());
                game.handlePlayerWin();
            }
        }
    }
}

