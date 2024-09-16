package mkurz;

import java.net.URI;

public class Wort {
    private final String wort;
    private final URI url;

    public Wort(String wort, URI url) {
        this.wort = wort;
        this.url = url;
    }

    public boolean isValid() {
        return wort != null && url != null && !wort.isEmpty();
    }

    public String getWort() {
        return wort;
    }

    public URI getUrl() {
        return url;
    }
}
