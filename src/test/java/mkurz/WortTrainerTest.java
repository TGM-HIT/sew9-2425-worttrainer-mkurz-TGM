package mkurz;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WortTrainerTest {
    private WortTrainer trainer;
    private ArrayList<WortEintrag> wortListe;

    @BeforeEach
    public void setUp() {
        wortListe = new ArrayList<>();
        wortListe.add(new WortEintrag("Hund", URI.create("https://example.com/hund.jpg")));
        wortListe.add(new WortEintrag("Katze", URI.create("https://example.com/katze.jpg")));
        trainer = new WortTrainer(wortListe);
    }

    @Test
    public void testConstructorThrowsExceptionForNullList() {
        assertThrows(IllegalArgumentException.class, () -> new WortTrainer(null));
    }

    @Test
    public void testCheckCorrectAnswer() {
        trainer.getRandomEintrag();
        String wort = trainer.getCurrWortEintrag().getWort();
        assertDoesNotThrow(() -> trainer.check(wort));
    }

    @Test
    public void testCheckIncorrectAnswer() {
        trainer.getRandomEintrag();
        assertThrows(IllegalArgumentException.class, () -> trainer.check("Fisch"));
    }

    @Test
    public void testGetAnswerStatistics() {
        trainer.getRandomEintrag();
        trainer.check(trainer.getCurrWortEintrag().getWort());
        assertEquals(1, trainer.getAnswer());
        assertEquals(1, trainer.getAnswerC());
    }
}
