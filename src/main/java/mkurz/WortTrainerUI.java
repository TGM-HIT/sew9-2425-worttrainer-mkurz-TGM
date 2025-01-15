package mkurz;

import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Die Klasse WortTrainerUI ist die Benutzeroberfläche für das Worttrainer-Spiel.
 * Sie ist für die Steuerung der Hauptanwendung verantwortlich, einschließlich
 * der Anzeige der aktuellen Wortstatistik und der Benutzerinteraktion.
 * @author Matthias
 */
public class WortTrainerUI {
    public static void main(String[] args) throws URISyntaxException, MalformedURLException {
        WortTrainer wt = null;
        SaveLoad slj = new SaveLoadJson();


        int startOver = JOptionPane.showConfirmDialog(null,
                "Möchten Sie das Worttrainer zuruecksetzen?",
                "Worttrainer",
                JOptionPane.YES_NO_OPTION);

        if (startOver == JOptionPane.YES_OPTION) {

            ArrayList<WortEintrag> list = new ArrayList<>();

            list.add(createWortEintrag("Hund",""));
            list.add(createWortEintrag("Katze","https://images.stockcake.com/public/7/3/5/735c9253-585e-4e1f-8329-d012fb99111f_medium/cozy-tabby-cat-stockcake.jpg"));
            list.add(createWortEintrag("Vogel","https://images.stockcake.com/public/6/f/f/6ff6a602-b116-4399-8ea0-66c712bd72d1_medium/vivid-autumn-bird-stockcake.jpg"));
            wt = new WortTrainer(list);

            try {
                slj.save(wt);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        } else {
            try {
                wt = slj.load();
            } catch (IOException | ClassNotFoundException e) {
                ArrayList<WortEintrag> list = new ArrayList<>();

                list.add(createWortEintrag("Hund",""));
                list.add(createWortEintrag("Katze","https://images.stockcake.com/public/7/3/5/735c9253-585e-4e1f-8329-d012fb99111f_medium/cozy-tabby-cat-stockcake.jpg"));
                list.add(createWortEintrag("Vogel","https://images.stockcake.com/public/6/f/f/6ff6a602-b116-4399-8ea0-66c712bd72d1_medium/vivid-autumn-bird-stockcake.jpg"));

                wt = new WortTrainer(list);

            }
        }

        while (true) {
            WortEintrag currentEntry = wt.getCurrWortEintrag();
            ImageIcon icon = null;
            try {
                icon = new ImageIcon(currentEntry.getUrl().toURL());
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IllegalArgumentException e){
                wt.next();
                //icon = new ImageIcon(new URI("https://www.freeiconspng.com/uploads/orange-error-icon-0.png").toURL());
                System.out.println("No Pic");
                continue;
            }
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
            slj.save(wt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static WortEintrag createWortEintrag(String wort, String url){
        try {
            return new WortEintrag(wort, new URI(url));
        } catch (URISyntaxException e) {
            return null;
        }

    }
}
