public class Kunden extends Person{
    private Speise speise;

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
