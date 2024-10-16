package mkurz;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Die Klasse Persistance bietet Methoden zum Speichern und Laden
 * von WortTrainer-Objekten in eine Datei.
 */
public class SaveLoadJson implements SaveLoad{

    private static final String FILE_PATH = "src/main/resources/worttrainer.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Speichert ein WortTrainer-Objekt in einer JSON-Datei.
     *
     * @param wt das zu speichernde WortTrainer-Objekt
     * @throws IOException wenn ein I/O-Fehler auftritt
     */
    public void save(WortTrainer wt) throws IOException {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(wt, writer);
        }
    }

    /**
     * Lädt ein WortTrainer-Objekt aus einer JSON-Datei.
     *
     * @return das geladene WortTrainer-Objekt
     * @throws IOException wenn ein I/O-Fehler auftritt
     */
    public WortTrainer load() throws IOException {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, WortTrainer.class);
        }
    }
}
