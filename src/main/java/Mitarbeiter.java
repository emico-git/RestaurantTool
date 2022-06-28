public class Mitarbeiter extends Person{
    private int lohn;
    private String job;

    public Mitarbeiter(int id, String name, String vorname, String alter, int lohn, String job){
        super(id, name, vorname, alter);
        this.lohn = lohn;
        this.job = job;
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

    

    



    
}
