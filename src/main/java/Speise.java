public class Speise {
    private int preis;
    private String speise;

    public Speise(int preis, String speise) {
        this.preis = preis;
        this.speise = speise;
    }

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public String getSpeise() {
        return speise;
    }

    public void setSpeise(String speise) {
        this.speise = speise;
    }
}
