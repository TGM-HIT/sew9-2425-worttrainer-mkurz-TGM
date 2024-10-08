package mkurz;

import java.io.*;

/**
 * Die Klasse Persistance bietet Methoden zum Speichern und Laden
 * von WortTrainer-Objekten in eine Datei.
 */
public class Persistance {

    /**
     * Speichert ein WortTrainer-Objekt in einer Datei.
     *
     * @param wt das zu speichernde WortTrainer-Objekt
     * @throws IOException wenn ein I/O-Fehler auftritt
     */
    public static void save(WortTrainer wt) throws IOException {
        FileOutputStream f = new FileOutputStream(new File("src/main/resources/worttrainer.txt"));
        ObjectOutputStream o = new ObjectOutputStream(f);

        o.writeObject(wt);

        o.close();
        f.close();
    }

    /**
     * Lädt ein WortTrainer-Objekt aus einer Datei.
     *
     * @return das geladene WortTrainer-Objekt
     * @throws IOException wenn ein I/O-Fehler auftritt
     * @throws ClassNotFoundException wenn die Klasse des geladenen Objekts nicht gefunden wird
     */
    public static WortTrainer load() throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(new File("src/main/resources/worttrainer.txt"));
        ObjectInputStream o = new ObjectInputStream(f);

        WortTrainer wt = (WortTrainer) o.readObject();

        o.close();
        f.close();

        return wt;
    }
}