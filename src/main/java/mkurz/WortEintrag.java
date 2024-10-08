package mkurz;

import java.io.Serializable;
import java.net.URI;

/**
 * Die Klasse WortEintrag repräsentiert einen einzelnen WortEintrag mit einem Wort
 * und einer zugehörigen URL, die auf ein Bild verweist.
 */
public class WortEintrag implements Serializable {
    private final String wort;
    private final URI url;

    /**
     * Konstruktor für einen WortEintrag.
     *
     * @param wort das Wort
     * @param url die URL, die auf ein Bild verweist
     */
    public WortEintrag(String wort, URI url) {
        this.wort = wort;
        this.url = url;
    }

    /**
     * Überprüft, ob der WortEintrag gültig ist (d.h. ob das Wort und die URL vorhanden sind).
     *
     * @return true, wenn der WortEintrag gültig ist, andernfalls false
     */
    public boolean isValid() {
        return wort != null && url != null && !wort.isEmpty();
    }

    /**
     * Gibt das Wort zurück.
     *
     * @return das Wort
     */
    public String getWort() {
        return wort;
    }

    /**
     * Gibt die URL zurück.
     *
     * @return die URL des Bildes
     */
    public URI getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "-" + wort + '\n' + "-" + url + '\n';
    }
}