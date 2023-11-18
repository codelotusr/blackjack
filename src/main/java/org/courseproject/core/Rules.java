package org.courseproject.core;

public class Rules {
    private final String rules;

    public Rules() {
        this.rules = """
                Each player starts with two cards, one of the dealer's cards is hidden until the end.
                To 'Hit' is to ask for another card. To 'Stand' is to hold your total and end your turn.
                If you go over 21 you bust, and the dealer wins regardless of the dealer's hand.
                """;
    }

    public static Rules getInstance() {
        return new Rules();
    }

    @Override
    public String toString() {
        return rules;
    }
}
