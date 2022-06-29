import java.util.ArrayList;
/**
 * Tisch Klasse, hier werden gemacht und ein Teil der Rechnung berechnet.
 * @author Emil Udupuzhayil
 * @version 1.0
 */
public class Tisch {
    private int plaetze;
    private ArrayList<Kunden> kunden = new ArrayList<Kunden>();
    private boolean frei = true;
    private boolean reserviert = false;

    public Tisch(){

    }
    public Tisch(int plaetze){
        this.plaetze = plaetze;
    }

    public int getPlaetze() {
        return plaetze;
    }

    public void setPlaetze(int plaetze) {
        this.plaetze = plaetze;
    }
    public ArrayList<Kunden> getKunden() {
        return kunden;
    }
    public void setKunden(ArrayList<Kunden> kunden) {
        this.kunden = kunden;
    }
    public boolean isFrei() {
        return frei;
    }
    public void setFrei(boolean frei) {
        this.frei = frei;
    }

    public void addKunde(String name, String vorname, Speise speise){
        kunden.add(new Kunden(name, vorname, speise ));
    }

    public int anzKunden(){
        return kunden.size();
    }


    public Kunden getKunde(int index){
        return kunden.get(index);
    }

    public boolean isReserviert() {
        return reserviert;
    }

    public void setReserviert(boolean reserviert) {
        this.reserviert = reserviert;
    }

    public double rechnungTotal(){
        double total = 0;
        for (Kunden k: kunden) {
            total = total + k.getSpeise().getPreis();
        }
        for (int i = 0;i < kunden.size(); i++){
            kunden.remove(i);
        }
        setFrei(true);
        setReserviert(false);
        return total;
    }
}
