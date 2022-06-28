import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
    private String name;
    private Standort standort;
    private ArrayList<Tisch> tische = new ArrayList<Tisch>();
    private ArrayList<Mitarbeiter> mitarbeiter = new ArrayList<Mitarbeiter>();
    private ArrayList<Speise> speisen = new ArrayList<Speise>();
    private ArrayList<Mitarbeiter> koeche = new ArrayList<Mitarbeiter>();

    public void preperation(){
        preperationTische();
        preperationGerichte();
        preperationMitarbeiter();
    }

    public void menu(){
        grafiken();
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
        while (input.equals("y")){
            System.out.println("Wie heisst ihr Gericht");
            String name = scan.next();
            System.out.println("Wie viel kostet es?");
            double preis = scan.nextDouble();
            speisen.add(new Speise(preis, name));
            System.out.println("Wollen sie noch ein Gericht hinzufügen? (y/n)");
            input = scan.next();
        }
    }

    public void preperationMitarbeiter (){
        System.out.println("Mitarbeiter.txt wird gelesen");
        try {
            Thread.sleep(4000);
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
                    try{
                    System.out.println("----------- "+ m.getId() +" -----------");
                    System.out.println("Name: "+ "\t" + m.getVorname() + " " + m.getName());
                    Thread.sleep(500);
                    System.out.println("Alter: "+ "\t" + m.getAlter());
                    Thread.sleep(500);
                    System.out.println("Lohn: "+ "\t" + m.getLohn());
                    Thread.sleep(500);
                    System.out.println("Job: "+ "\t" + m.getJob());
                    }catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
        }
    }

    public void grafiken(){
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
        System.out.println("+-----------------------------------------------+");
        System.out.println("|\t\t        Küche\t\t\t|" );
        System.out.println("|\t\t\t\t\t\t|");
        System.out.println("|\t\t" + koeche.get(0).getName() + "\t\t" + koeche.get(1).getName() + "\t\t|");
        System.out.println("|\t\t\t\t\t\t|");
        System.out.println("+-----------------------------------------------+");

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
            System.out.println("\t+-------------------------------+");
            System.out.println("\t|\t      Tisch "+ counter +"\t\t|");
            System.out.println("\t|\t\t\t\t|");
            System.out.println("\t|\t\t\t\t|");
            System.out.println("\t|\t\t\t\t|");
            System.out.println("\t|\t\t\t\t|");
            System.out.println("\t+-------------------------------+");
        }
        
    }



    public void test(){
        
        
    }
}
