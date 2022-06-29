/**
 * Kunden Klasse, hier werden die Kunden gemacht.
 * @author Emil Udupuzhayil
 * @version 1.0
 */

public class Kunden extends Person{
    private Speise speise;

    /**
     *Hier werden Kunden initialisiert
     */
    public Kunden(String name, String vorname, Speise speise){
        super(name, vorname);
        this.speise = speise;
    }

    public Speise getSpeise() {
        return speise;
    }

    public void setSpeise(Speise speise) {
        this.speise = speise;
    }

    
    

}
