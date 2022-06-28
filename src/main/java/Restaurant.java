import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
            tische.add(new Tisch(4));

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

    public void preperationMitarbeiter (){
        System.out.println("Mitarbeiter.txt wird gelesen");
        try {
            int index = 0;
            String fileName = "D:\\OneDrive - KBW Kantonsschule Büelrain Winterthur\\01BBW\\02.5_Modul_326\\Projekt\\Projekt\\Mitarbeiter.txt";
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                int counter = 0;
                String[] lineParts = line.split(";"); // Split line at occurences of semicolon
                for (String p : lineParts) {         // loop over all parts of the line
                    counter++;
                    switch (counter) {
                        case 1:

                            break;

                        case 2:

                            break;

                        case 3:

                            break;

                        case 4:

                            break;

                        case 5:

                            break;

                        case 6:

                            break;
                    }
                }
                index++;
                line = br.readLine();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            System.out.println("--------------TEST--------------");
            for (Ort o: orte) {
                System.out.println("Name: " + o.getName());
                System.out.println("X-Koordiante: " + o.getKoordinateX());
                System.out.println("Y-Koordiante: " + o.getKoordinateY());
                System.out.println("Startpunkt: " + o.isStarpunkt());
                System.out.println();
            }
            System.out.println("--------------------------------");
        }
    }
}
