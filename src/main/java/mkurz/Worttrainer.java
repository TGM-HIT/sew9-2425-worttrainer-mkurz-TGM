package mkurz;

import java.util.ArrayList;

public class Worttrainer {
    private Wort currentWort;
    private int count;
    private int correct;
    private int incorrect;
    private final ArrayList<Wort> list;

    public Worttrainer(ArrayList<Wort> list) {
        this.list = list;
    }

    public boolean checkWort(String wort) {
        this.count++;
        if(this.currentWort.getWort().equals(wort)) {
            this.correct++;
            return true;
        }else {
            this.incorrect++;
            return false;
        }
    }

    public Wort selectWort() {
        this.currentWort = list.get((int) (Math.random() * list.size()));
        return currentWort;
    }

    public Wort selectWort(int index){
        this.currentWort = list.get(index);
        return this.currentWort;
    }

    public void deselectWort() {
        this.currentWort = null;
    }

    public boolean isValid(){
        if(this.list == null){
            return false;
        }
        for(Wort w : list) {
            if (!w.isValid()) {
                return false;
            }
        }
        return true;
    }
}
