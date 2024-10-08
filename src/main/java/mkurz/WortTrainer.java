package mkurz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;


public class WortTrainer implements Serializable{
    private ArrayList<WortEintrag> list = new ArrayList<>();
    private WortEintrag selectWortEintrag;
    private int answer = 0;
    private int answerC = 0;

    /**
     * Konstruktor �bergibt liste
     * @param list die Liste
     */
    public WortTrainer(ArrayList<WortEintrag> list) {
        if(list == null) throw new IllegalArgumentException("Die Liste ist Leer");
        this.list = list;
    }


    /**
     * W�hlt einen zuf�lligen Worteintrag aus
     * @return selectWortEintrag der ausgew�hlte Worteintrag
     */
    public WortEintrag getRandomEintrag() {
        Random random = new Random();
        int r = random .nextInt(this.list.size());

        this.selectWortEintrag = this.list.get(r);
        return selectWortEintrag;
    }


    /**
     * Gibt den momentan ausgew�hlten Worteintrag zur�ck
     * @return selectWortEintrag der Worteintrag
     */
    public WortEintrag getCurrWortEintrag() {
        return this.selectWortEintrag;
    }

    /**
     * Setzt den ausgew�hlten Worteintrag
     * @param selectWortEintrag der Ausgew�hle Worteintrag
     */
    public void setCurrWortEintrag(WortEintrag selectWortEintrag) {
        this.selectWortEintrag = selectWortEintrag;
    }

    public void check(String input) {
        if(input.length() < 2) throw new IllegalArgumentException("Das Wort ist zu kurz.");
        for(int i = 0;i < input.length();i++) {
            if(!((input.charAt(i) >= 65 && input.charAt(i) <= 90) || (input.charAt(i) >= 97 && input.charAt(i) <= 122))) {
                throw new IllegalArgumentException("Das ist kein Tier.");
            }
        }

        answer++;
        if(input.equalsIgnoreCase(selectWortEintrag.getWort())) {
            answerC++;
            this.getRandomEintrag();
        } else {
            throw new IllegalArgumentException("Die Antwort ist Falsch.");
        }

    }

    /**
     * Gibt die anzahl and  Antworten zur�ck
     * @return answer Die anzahl an Antworten
     */
    public int getAnswer() {
        return this.answer;
    }

    /**
     * Gibt die anzahl and richtigen Antworten zur�ck
     * @return answerC Die anzahl an richtigen Antworten
     */
    public int getAnswerC() {
        return this.answerC;
    }

    /**
     * Die die Wortliste zurueck
     * @return list Die Wortliste
     */
    public ArrayList<WortEintrag> getList() {
        return this.list;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Count: ").append(answer).append("\n");
        sb.append("Correct: ").append(answerC).append("\n");
        sb.append("Incorrect: ").append(answer-answerC).append("\n");

        return sb.toString();
    }
}
