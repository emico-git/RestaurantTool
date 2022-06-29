import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Restaurant Klassen, Herz von der Applikation, hier sind fast alle Methoden drin
 * @author Emil Udupuzhayil
 * @version 1.0
 */
public class Restaurant {
    private String name;
    private Standort standort;
    private ArrayList<Tisch> tische = new ArrayList<Tisch>();
    private ArrayList<Mitarbeiter> mitarbeiter = new ArrayList<Mitarbeiter>();
    private ArrayList<Speise> speisen = new ArrayList<Speise>();
    private ArrayList<Mitarbeiter> koeche = new ArrayList<Mitarbeiter>();

    /**
     * Hier werden die verschiedenen Methoden für die Vorbereitung der Appliktion zusammen gebracht.
     */
    public void preperation(){
        preperationTische();
        preperationGerichte();
        preperationMitarbeiter();
    }

    /**
     *Hier werden die Anzahl die initialisiert.
     */
    public void preperationTische(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Wie viele Tische haben sie?");
        int a = scan.nextInt();
        for(int i = 0; i < a; i++){
            tische.add(new Tisch(4));
        }

    }

    /**
     *Hier werden die Gerichte initialisiert.
     */
    public void preperationGerichte (){
        Scanner scan = new Scanner(System.in);
        System.out.println("-----------Gerichte-----------");
        String input = "y";
        while (input.equals("y")){
            System.out.println("Wie heisst ihr Gericht");
            String name = scan.next();
            System.out.println("Wie viel kostet es? (bitte nur eine Zahl, z.b 7.00)");
            double preis = scan.nextDouble();
            speisen.add(new Speise(preis, name));
            System.out.println("Wollen sie noch ein Gericht hinzufügen? (y/n)");
            input = scan.next();
        }
    }

    /**
     *Hier werden der Mitarbeiter.txt File gelesen und die Mitarbeiter initialisiert und auf der Konsole ausgegeben.
     */
    public void preperationMitarbeiter (){
        System.out.println("Mitarbeiter.txt wird gelesen");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            String fileName = "Mitarbeiter.txt";
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                int  id = 0, lohn = 0, counter = 0;
                
                String name = "", vorname = "", alter = "", job = "";
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
                        if(p.equals("Kellner")){
                            job = "Kellner";
                        }
                        if(p.equals("Kellnerin")){
                            job = "Kellnerin";
                        }
                        if(p.equals("Koch")){
                            job = "Koch";
                        }
                        if(p.equals("Köchin")){
                            job = "Köchin";
                        }
                            break;
                    }
                }
                mitarbeiter.add(new Mitarbeiter(id, name, vorname, alter, lohn, job));
                if(job.equals("Koch") || job.equals("Köchin")){
                koeche.add(new Mitarbeiter(id, name, vorname, alter, lohn, job));
                }
                line = br.readLine();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{   
                try{
                System.out.println("Loading Mitarbeiter.");
                Thread.sleep(1000);
                System.out.println("Loading Mitarbeiter..");
                Thread.sleep(1000);
                System.out.println("Loading Mitarbeiter...");
                Thread.sleep(1000);
                }catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                System.out.println("-----------Mitarbeiter-----------");
                for(Mitarbeiter m: mitarbeiter){
                    System.out.println("----------- "+ m.getId() +" -----------");
                    System.out.println("Name: "+ "\t" + m.getVorname() + " " + m.getName());
                    System.out.println("Alter: "+ "\t" + m.getAlter());
                    System.out.println("Lohn: "+ "\t" + m.getLohn());
                    System.out.println("Job: "+ "\t" + m.getJob());

                }
        }
    }

    /**
     *Hier werden die ersten verschieden Grafik Methoden zusammen gebracht
     */
    public void grafiken(){
       kuecheGrafik();
       TischGrafik();
    }

    /**
     *Hier werden die Grafik Methoden, für die Kunden erfassung, zusammen gebracht.
     */
    public void grafikenUpdatenErfassen(){
        kundenErfassen();
        kuecheGrafik();
        TischGrafik();
     }

    /**
     *Hier werden die Grafik Methoden, für die Tisch reservierung, zusammen gebracht.
     */
     public void grafikenUpdatenReservieren(){
         tischReservieren();
         kuecheGrafik();
         TischGrafik();
     }

    /**
     *Hier werden die Grafik Methoden, für die Rechnung Erstellung, zusammen gebracht.
     */
     public void grafikenUpdatenRechnungErstellen(){
        rechnungErstellen();
        kuecheGrafik();
        TischGrafik();
     }

    /**
     *Hier wird die Küchengrafik gemacht.
     */
    public void kuecheGrafik(){
        System.out.println("----------------Menu----------------");
        /*
        Küche
        +-----------------------------------------------+
		|                      Küche	                |		
		|                                               |
		|           Koch1               Koch2           |
		|                                               |
		+-----------------------------------------------+
         */
        System.out.println("+-------------------------------+");
        System.out.println("|\t\t        Küche\t\t\t|" );
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("|\t\t" + koeche.get(0).getName() + "\t\t" + koeche.get(1).getName() + "\t\t|");
        System.out.println("|\t\t\t\t\t\t\t\t|");
        System.out.println("+-------------------------------+");

    }

    /**
     *Hier wird die Tisch Grafik gemacht.
     */
    public void TischGrafik(){
        int counter = 0;
        /*
        Tische:
        +-------------------------------+				
		|             Tisch 1           |	
	    |                               |   
		|				                |
		|                          	    | 
		|        	                    |   
		+-------------------------------+ 
        */
        for (Tisch t : tische) {

            counter++;
            if(t.isFrei() == true && t.isReserviert() == false){

                System.out.println("\t\t+-----------------------+");
                System.out.println("\t\t|\t      Tisch " + counter + "\t\t|");
                System.out.println("\t\t|\t\t\t\t\t\t|");
                System.out.println("\t\t|\t\t\t\t\t\t|");
                System.out.println("\t\t|\t\t\t\t\t\t|");
                System.out.println("\t\t+-----------------------+");
            }

            if(t.isReserviert() == true && t.isFrei() == false){
                System.out.println("\t\t+-----------------------+");
                System.out.println("\t\t|\t      Tisch " + counter + "\t\t|");
                System.out.println("\t\t|\t\t*reserviert*\t|");
                System.out.println("\t\t|\t\t\t\t\t\t|");
                System.out.println("\t\t|\t\t\t\t\t\t|");
                System.out.println("\t\t+-----------------------+");
            }

            if(t.isFrei() == false && t.isReserviert() == false){

                switch(t.anzKunden()){

                    case 1:
                        System.out.println("\t\t+-----------------------+");
                        System.out.println("\t\t|\t      Tisch "+ counter +"\t\t|");
                        System.out.println( t.getKunde(0).getVorname() + "\t|\t"+ t.getKunde(0).getSpeise().getSpeise() +"\t\t\t\t|");
                        System.out.println("\t\t|\t\t\t\t\t\t|");
                        System.out.println("\t\t|\t\t\t\t\t\t|");
                        System.out.println("\t\t+-----------------------+");
                        break;
                    
                    case 2:
                        System.out.println("\t\t+-----------------------+");
                        System.out.println("\t\t|\t      Tisch "+ counter +"\t\t|");
                        System.out.println(t.getKunde(0).getVorname() + "\t|\t"+ t.getKunde(0).getSpeise().getSpeise() +"\t\t"+ t.getKunde(1).getSpeise().getSpeise() +"\t|" + t.getKunde(1).getVorname());
                        System.out.println("\t\t|\t\t\t\t\t\t|");
                        System.out.println("\t\t|\t\t\t\t\t\t|");
                        System.out.println("\t\t+-----------------------+");
                        break;

                    case 3:
                        System.out.println("\t\t+-----------------------+");
                        System.out.println("\t\t|\t      Tisch "+ counter +"\t\t|");
                        System.out.println(t.getKunde(0).getVorname() + "\t|\t"+ t.getKunde(0).getSpeise().getSpeise() +"\t\t"+ t.getKunde(1).getSpeise().getSpeise() +"\t|" + t.getKunde(1).getVorname());
                        System.out.println("\t\t|\t\t\t\t\t\t|");
                        System.out.println(t.getKunde(2).getVorname() + "\t|\t"+ t.getKunde(2).getSpeise().getSpeise() +"\t\t\t\t|");
                        System.out.println("\t\t+-----------------------+");
                        break;

                    case 4:
                        System.out.println("\t\t+-----------------------+");
                        System.out.println("\t\t|\t      Tisch "+ counter +"\t\t|");
                        System.out.println(t.getKunde(0).getVorname() + "\t|\t"+ t.getKunde(0).getSpeise().getSpeise() +"\t\t"+ t.getKunde(1).getSpeise().getSpeise() +"\t|" + t.getKunde(1).getVorname());
                        System.out.println("\t\t|\t\t\t\t\t\t|");
                        System.out.println(t.getKunde(2).getVorname() + "\t|\t"+ t.getKunde(2).getSpeise().getSpeise() +"\t\t"+ t.getKunde(3).getSpeise().getSpeise() +"\t|" + t.getKunde(3).getVorname());
                        System.out.println("\t\t+-----------------------+");
                        break;
                }
            }
        }
    }

    /**
     *Hier wird die Kunden Erfassung gemacht
     */
    public void kundenErfassen(){
        Scanner scan = new Scanner(System.in);
        int tischIndex = 0;
        int counter = -1;
        System.out.println("Wie viel Kunden hat es?");
        int anzKunden = scan.nextInt();
        for (Tisch t : tische) {
            counter++;
            if(t.isFrei() == true){
                tischIndex = counter;
            }
        }
        for(int i = 0; i < anzKunden; i++){
            String name = "", vorname = "", gerichtName = "";
            
            System.out.println("Wie heisst der Kunde zum vornamen?");
            vorname = scan.next();
            System.out.println("Wie heisst der Kunde zum nachnamen?");
            name = scan.next();
            System.out.println("Was bestellt der Kunde?");
            gerichtName = scan.next();
            for(Speise s : speisen){
                if(gerichtName.equals(s.getSpeise())){
                    tische.get(tischIndex).addKunde(name, vorname, s);
                }
            }
            tische.get(tischIndex).setFrei(false);
        }
    }

    /**
     *Hier wird die Tischreservierung gemacht.
     */
    public void tischReservieren(){
        Scanner scan = new Scanner(System.in);
        int counter = -1;
        System.out.println("Welchen Tisch wollen sie Reservieren");
        int indexTisch = scan.nextInt();
        indexTisch--;
        if(tische.get(indexTisch).isFrei() == true){
            tische.get(indexTisch).setReserviert(true);
            tische.get(indexTisch).setFrei(false);
        }else{
            System.out.println("Der ausgewählte Tisch ist nicht Frei.");
        }

    }

    /**
     *Hier wird der zweite Teil für die Rechnung berechnung gemacht.
     */
    public void rechnungErstellen(){
        Scanner scan = new Scanner(System.in);
        double total;
        System.out.println("Für welchen Tisch wollen sie die Rechnung.");
        int indexTisch = scan.nextInt();
        indexTisch--;
        if(tische.get(indexTisch).isFrei() == false){
            Tisch tisch = tische.get(indexTisch);
            total = tisch.rechnungTotal();
            System.out.println("Der Totale Betrag beträgt " + total + " CHF.");
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }


        }else{
            System.out.println("Niemand sitzt an dem ausgewählten Tisch.");
        }
    }


}
