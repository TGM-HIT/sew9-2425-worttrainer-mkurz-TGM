package mkurz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Die Klasse WortTrainer verwaltet die Wortliste und die Logik für das Spiel.
 * Sie wählt zufällige WortEinträge aus, überprüft die Eingaben des Benutzers
 * und verfolgt die Statistiken der Antworten.
 */
public class WortTrainer implements Serializable {
    private ArrayList<WortEintrag> list = new ArrayList<>();
    private WortEintrag selectWortEintrag;
    private int answer = 0;
    private int answerC = 0;

    /**
     * Konstruktor, der die Liste der WortEinträge übergibt.
     *
     * @param list die Liste der WortEinträge
     * @throws IllegalArgumentException wenn die Liste null ist
     */
    public WortTrainer(ArrayList<WortEintrag> list) {
        if (list == null) throw new IllegalArgumentException("Die Liste ist Leer");
        this.list = list;
        this.selectWortEintrag = list.get(0);
    }

    /**
     * Wählt einen zufälligen WortEintrag aus der Liste aus.
     *
     * @return der zufällig ausgewählte WortEintrag
     */
    public WortEintrag getRandomEintrag() {
        Random random = new Random();
        int r = random.nextInt(this.list.size());

        this.selectWortEintrag = this.list.get(r);
        return selectWortEintrag;
    }

    /**
     * Gibt den momentan ausgewählten WortEintrag zurück.
     *
     * @return der derzeit ausgewählte WortEintrag
     */
    public WortEintrag getCurrWortEintrag() {
        return this.selectWortEintrag;
    }

    /**
     * Setzt den aktuell ausgewählten WortEintrag.
     *
     * @param selectWortEintrag der zu setzende WortEintrag
     */
    public void setCurrWortEintrag(WortEintrag selectWortEintrag) {
        this.selectWortEintrag = selectWortEintrag;
    }

    /**
     * Überprüft die Benutzereingabe und aktualisiert die Statistiken.
     *
     * @param input die Benutzereingabe zum zu überprüfenden Wort
     * @throws IllegalArgumentException wenn die Eingabe zu kurz ist oder kein gültiges Tier darstellt
     */
    public void check(String input) {
        if (input.length() < 2) throw new IllegalArgumentException("Das Wort ist zu kurz.");
        for (int i = 0; i < input.length(); i++) {
            if (!((input.charAt(i) >= 65 && input.charAt(i) <= 90) || (input.charAt(i) >= 97 && input.charAt(i) <= 122))) {
                throw new IllegalArgumentException("Das ist kein Tier.");
            }
        }

        answer++;
        if (input.equalsIgnoreCase(selectWortEintrag.getWort())) {
            answerC++;
            this.getRandomEintrag();
        } else {
            throw new IllegalArgumentException("Die Antwort ist Falsch.");
        }
    }

    /**
     * Gibt die Anzahl der Antworten zurück.
     *
     * @return die Gesamtanzahl der Antworten
     */
    public int getAnswer() {
        return this.answer;
    }

    /**
     * Gibt die Anzahl der richtigen Antworten zurück.
     *
     * @return die Anzahl der richtigen Antworten
     */
    public int getAnswerC() {
        return this.answerC;
    }

    /**
     * Gibt die Wortliste zurück.
     *
     * @return die Liste der WortEinträge
     */
    public ArrayList<WortEintrag> getList() {
        return this.list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Count: ").append(answer).append("\n");
        sb.append("Correct: ").append(answerC).append("\n");
        sb.append("Incorrect: ").append(answer - answerC).append("\n");

        return sb.toString();
    }
}