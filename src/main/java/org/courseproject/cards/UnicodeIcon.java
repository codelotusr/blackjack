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
    private final String art;
    private final String cardEquivalent;

    UnicodeIcon(String art, String cardEquivalent) {
        this.art = art;
        this.cardEquivalent = cardEquivalent;
    }

    @Override
    public String toString() {
        return art;
    }
}
