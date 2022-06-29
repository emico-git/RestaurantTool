/**
 * Speise Klasse, hier werden die Speisen gemacht.
 * @author Emil Udupuzhayil
 * @version 1.0
 */
public class Speise {
    private double preis;
    private String speise;

    /**
     *Hier werden Speisen initialisiert.
     */
    public Speise(double preis, String speise) {
        this.preis = preis;
        this.speise = speise;
    }


    public double getPreis() {
        return preis;
    }


    public void setPreis(double preis) {
        this.preis = preis;
    }


    public String getSpeise() {
        return speise;
    }

    public void setSpeise(String speise) {
        this.speise = speise;
    }
}
