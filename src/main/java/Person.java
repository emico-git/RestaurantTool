/**
 * Person Oberklasse, Oberklassen von allen Personen
 * @author Emil Udupuzhayil
 * @version 1.0
 */
public class Person {
    private String name;
    private String vorname;
   

    public Person(String name, String vorname) {
        this.name = name;
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    
}
