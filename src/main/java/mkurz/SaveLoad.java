package mkurz;

import java.io.IOException;

public interface SaveLoad {
    public void save(WortTrainer wt) throws IOException;
    public WortTrainer load() throws IOException,ClassNotFoundException;
}
