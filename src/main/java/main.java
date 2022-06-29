import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Restaurant r = new Restaurant();
        Scanner scan = new Scanner(System.in);
        r.test();
        r.preperation();
        r.grafiken();
        boolean run = true;
        while(run){
            System.out.println("Was wollen sie machen... (geben sie eine Zahl ein)");
            System.out.println("1.\tKunden erfassen.");
            System.out.println("2.\tTisch reservieren.");
            System.out.println("3.\tRechnung von Tisch/Tisch befreien.");
            System.out.println("4.\tTool schliessen");
            String input = scan.next();
            switch (input) {
                case "1":
                    r.grafikenUpdatenErfassen();
                    break;

                case "2":
                    r.grafikenUpdatenReservieren();
                    break;
                case "3":
                    r.grafikenUpdatenRechnungErstellen();
                    break;
                case "4":
                    System.out.println("Wollen sie wirklich das Tool schliessen? (y/n)");
                    if(scan.next().equals("y")){
                        run = false;
                    }
                    break;
            }
        }
        
    }
}
