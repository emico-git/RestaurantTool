import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
    private String name;
    private Standort standort;
    private ArrayList<Tisch> tische = new ArrayList<Tisch>();
    private ArrayList<Mitarbeiter> mitarbeiter = new ArrayList<Mitarbeiter>();
    private ArrayList<Speise> speisen = new ArrayList<Speise>();

    public void preperation(){
        preperationTische();
        preperationGerichte();
    }

    public void preperationTische(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Wie viele Tische haben sie?");
        int a = scan.nextInt();
        for(int i = 0; i < a; i++){
            tische.add(new Tisch());

        }
        for (Tisch t: tische) {
            t.setPlaetze(4);
        }


    }

    public void preperationGerichte (){
        Scanner scan = new Scanner(System.in);
        System.out.println("-----------Gerichte-----------");
        String input = "y";
        while (input != "n"){
            System.out.println("Wie heisst ihr Gericht");
            String name = scan.next();
            System.out.println("Wie viel kostet es?");
            int preis = scan.nextInt();
            speisen.add(new Speise(preis, name));
            System.out.println("Wollen sie noch ein Gericht hinzufügen? (y/n)");
            input = scan.next();
        }


    }
}
