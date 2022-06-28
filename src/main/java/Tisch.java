import java.util.ArrayList;

public class Tisch {
    private int plaetze;
    private ArrayList<Kunden> kunden = new ArrayList<Kunden>();
    private boolean frei = true;

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
    
}
