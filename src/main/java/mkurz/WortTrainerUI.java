package mkurz;

import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;

/**
 * Die Klasse WortTrainerUI ist die Benutzeroberfläche für das Worttrainer-Spiel.
 * Sie ist für die Steuerung der Hauptanwendung verantwortlich, einschließlich
 * der Anzeige der aktuellen Wortstatistik und der Benutzerinteraktion.
 * @author Matthias
 */
public class WortTrainerUI {
    public static void main(String[] args) throws MalformedURLException {
        WortTrainer wt = null;

        // Prompt user to start over
        int startOver = JOptionPane.showConfirmDialog(null,
                "Möchten Sie das Worttrainer zuruecksetzen?",
                "Worttrainer",
                JOptionPane.YES_NO_OPTION);

        try {
            if (startOver == JOptionPane.YES_OPTION) {
                // Create a new WortTrainer and save it
                ArrayList<WortEintrag> list = new ArrayList<>();
                list.add(new WortEintrag("Hund", new URI("https://woofwell.com/cdn/shop/files/Golden-Retriever-Health-WoofWell-Breed-Specific-Dog-Supplements_1600x.jpg?v=1621360789")));
                list.add(new WortEintrag("Katze", new URI("https://images.stockcake.com/public/7/3/5/735c9253-585e-4e1f-8329-d012fb99111f_medium/cozy-tabby-cat-stockcake.jpg")));
                list.add(new WortEintrag("Vogel", new URI("https://images.stockcake.com/public/6/f/f/6ff6a602-b116-4399-8ea0-66c712bd72d1_medium/vivid-autumn-bird-stockcake.jpg")));
                wt = new WortTrainer(list);

                // Save the new WortTrainer
                Persistance.save(wt);
            } else {
                // Load existing WortTrainer
                wt = Persistance.load();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (Exception uriException) {
            uriException.printStackTrace();
            return;
        }

        while (true) {
            WortEintrag currentEntry = wt.getCurrWortEintrag();
            ImageIcon icon = new ImageIcon(currentEntry.getUrl().toURL());
            String message = "Aktuelle Statistik:\n" + wt +
                    "\nBitte geben Sie das Wort ein:";

            // Zeige das Bild und die Statistik in einem JOptionPane
            Object[] options = {icon, message};
            String input = (String) JOptionPane.showInputDialog(null, options,
                    "Worttrainer", JOptionPane.PLAIN_MESSAGE, null, null, null);

            if (input == null) {
                break;
            }

            try {
                wt.check(input);
                JOptionPane.showMessageDialog(null, "Richtig!");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        try {
            Persistance.save(wt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
