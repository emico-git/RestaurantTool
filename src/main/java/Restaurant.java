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
            String fileName = "Mitarbeiter.txt";
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                int  id = 0, lohn = 0, counter = 0;
                boolean kellner = false;
                String name = "", vorname = "", alter = "";
                String[] lineParts = line.split(";"); // Split line at occurences of semicolon
                for (String p : lineParts) {         // loop over all parts of the line
                    counter++;
                    switch (counter) {
                        case 1:
                            id =  Integer.valueOf(p);
                            break;

                        case 2:
                            name = p;
                            break;

                        case 3:
                            vorname = p;
                            break;

                        case 4:
                            alter = p;
                            break;

                        case 5:
                            lohn =  Integer.valueOf(p);
                            break;

                        case 6:
                        if(p.equals("Kellner") || p.equals("Kellnerin")){
                            kellner = true;
                        }
                            break;
                    }
                }
                mitarbeiter.add(new Mitarbeiter(id, name, vorname, alter, lohn, kellner));
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
