public class Mitarbeiter extends Person{
    private int lohn;
    private boolean kellner;

    public Mitarbeiter(int id, String name, String vorname, String alter, int lohn, boolean kellner){
        super(id, name, vorname, alter);
        this.lohn = lohn;
        this.kellner = kellner;
    }
}
