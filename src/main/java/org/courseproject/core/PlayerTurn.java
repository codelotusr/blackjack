package org.courseproject.core;

import org.courseproject.interfaces.HandleTurn;

public class PlayerTurn implements HandleTurn {
    @Override
    public void executeTurn(Game game) {
        System.out.println("Enter your choice:");
        System.out.println("1) Hit");
        System.out.println("2) Stand");
        int choice = game.getScanner().nextInt();
        game.getScanner().nextLine();
        switch (choice) {
            case 1 -> {
                game.printHit(game.getPlayer());
                game.getPlayer().addCard(game.getDeck().dealCard());
                game.displayTable();
                if (game.getPlayer().getHandValue() > Game.getInstance().getValueLimit()) {
                    game.printBusted(game.getPlayer());
                    game.handlePlayerLoss();
                }
            }
            case 2 -> {
                System.out.println(game.getPlayer().getName() + " stands");
                game.setPlayerTurn(false);
            }
            default -> System.out.println("Invalid choice. Please select a valid option.");
        }
    }
}

