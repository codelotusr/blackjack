package org.courseproject.cards;

public enum UnicodeIcon {
    ACEOFSPADES("""
             _____
            |A .  |
            | /.\\ |
            |(_._)|
            |  |  |
            |____V|
            """, "Ace of Spades"),
    ACEOFDIAMONDS("""
             _____
            |A ^  |
            | / \\ |
            | \\ / |
            |  .  |
            |____V|
            """, "Ace of Diamonds");
    private final String code;
    private final String cardEquivalent;

    UnicodeIcon(String code, String cardEquivalent) {
        this.code = code;
        this.cardEquivalent = cardEquivalent;
    }

    @Override
    public String toString() {
        return code;
    }
}
