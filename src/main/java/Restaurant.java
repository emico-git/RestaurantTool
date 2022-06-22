import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
    private String name;
    private Standort standort;
    private ArrayList<Tisch> tische = new ArrayList<Tisch>();
    private ArrayList<Mitarbeiter> mitarbeiter = new ArrayList<Mitarbeiter>();
    private ArrayList<Speise> speisen = new ArrayList<Speise>();

    public void preperation(){


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
        System.out.println("Wie viele Gerichte haben sie?");
        int a = scan.nextInt();


    }
}
