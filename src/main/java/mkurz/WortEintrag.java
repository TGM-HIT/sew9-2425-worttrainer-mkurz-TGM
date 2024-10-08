package mkurz;

import java.io.Serializable;
import java.net.URI;

public class WortEintrag implements Serializable {
    private final String wort;
    private final URI url;

    public WortEintrag(String wort, URI url) {
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

    @Override
    public String toString() {
        return "-" + wort + '\n' + "-" + url + '\n';
    }
}
