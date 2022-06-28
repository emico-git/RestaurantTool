public class Mitarbeiter extends Person{
    private int lohn;
    private boolean mitarbeiter;

    public Mitarbeiter(int id, String name, String vorname, String alter, int lohn, boolean mitarbeiter){
        super(id, name, vorname, alter);
        this.lohn = lohn;
        this.mitarbeiter = mitarbeiter;
    }
}
