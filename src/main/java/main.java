import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Restaurant r = new Restaurant();
        Scanner scan = new Scanner(System.in);
        
        r.preperation();
        r.grafiken();
        boolean run = true;
        while(run){
            System.out.println("Was wollen sie machen... (geben sie eine Zahl ein)");
            System.out.println("1.\tKunden erfassen.");
            System.out.println("2.\tTisch reservieren.");
            System.out.println("quit.\tTool verlassen");
            String input = scan.next();
            switch (input) {
                case "1":
                    r.grafikenUpdaten();
                    break;


            }
        }
        
    }
}
