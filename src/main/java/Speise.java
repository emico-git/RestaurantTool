public class Speise {
    private double preis;
    private String speise;

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
