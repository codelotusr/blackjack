

import org.courseproject.Suit;
import org.courseproject.Value;
import org.courseproject.temp.CardNameGetter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardNameGetterTest {
    private CardNameGetter underTest;
    @BeforeEach
    void setUp() {
        underTest = new CardNameGetter();
    }

    @Test
    void itShouldPrintCardName() {
        String cardName = String.valueOf(Value.ACE);
        String cardSuit = String.valueOf(Suit.DIAMOND);

        // check
        assertEquals("The Ace of Diamonds", underTest.getCardName(cardName, cardSuit));

    }
}
