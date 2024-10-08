package mkurz;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersistanceTest {

    private static final String FILE_PATH = "src/main/resources/worttrainer.json";
    private WortTrainer trainer;

    @BeforeEach
    public void setUp() {
        ArrayList<WortEintrag> wortListe = new ArrayList<>();
        wortListe.add(new WortEintrag("Hund", URI.create("https://example.com/hund.jpg")));
        trainer = new WortTrainer(wortListe);
    }

    @AfterEach
    public void tearDown() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testSaveAndLoad() throws IOException, ClassNotFoundException {
        Persistance.save(trainer);
        WortTrainer loadedTrainer = Persistance.load();
        assertEquals(trainer.toString(), loadedTrainer.toString());
    }

}