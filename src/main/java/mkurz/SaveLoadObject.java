package mkurz;

import java.io.*;

public class SaveLoadObject implements SaveLoad{
    public void save(WortTrainer wt) throws IOException {
        FileOutputStream f = new FileOutputStream(new File("src/main/resources/worttrainer.txt"));
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(wt);
        o.close();
        f.close();
    }
    public WortTrainer load() throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(new File("src/main/resources/worttrainer.txt"));
        ObjectInputStream o = new ObjectInputStream(f);
        WortTrainer wt = (WortTrainer) o.readObject();
        o.close();
        f.close();
        return wt;
    }
}
