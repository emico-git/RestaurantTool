/**
 * Mitarbeiter Klasse, Hier werden die Mitarbeiter gemacht.
 * @author Emil Udupuzhayil
 * @version 1.0
 */
public class Mitarbeiter extends Person{
    private int lohn;
    private String job;
    private String alter;
    private int id;


    /**
     *Hier werden Mitarbeiter initialisiert
     */
    public Mitarbeiter(int id, String name, String vorname, String alter, int lohn, String job){
        super(name, vorname);
        this.lohn = lohn;
        this.job = job;
        this.id = id;
        this.alter = alter;
    }


    public int getLohn() {
        return lohn;
    }

    public void setLohn(int lohn) {
        this.lohn = lohn;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAlter() {
        return alter;
    }

    public void setAlter(String alter) {
        this.alter = alter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    

    



    
}
