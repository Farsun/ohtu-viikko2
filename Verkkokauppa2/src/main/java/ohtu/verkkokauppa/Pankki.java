package ohtu.verkkokauppa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pankki implements PankkiRajapinta {

    //private static Pankki instanssi;

    /*public static Pankki getInstance() {
        if (instanssi == null) {
            instanssi = new Pankki();
        }

        return instanssi;
    }*/
    private Kirjanpito kirjanpito;
    @Autowired
    public Pankki(KirjanpitoInterface kPito) {
        kirjanpito = (Kirjanpito)kPito;
    }

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");
        
        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
