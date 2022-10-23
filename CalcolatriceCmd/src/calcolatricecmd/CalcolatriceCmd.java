/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calcolatricecmd;
import calcolatricecmd.*;
import java.util.Scanner;

/**
 *
 * @author assun
 */
public class CalcolatriceCmd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i=0;
        double a=0.0, b=0.0;
        Scanner scan = new Scanner(System.in);
        System.out.println("*** CALCOLATRICE ***\n");
        System.out.println("Quale operazione intendi fare?");
        System.out.print("1. Pitagora * Inserire 2 cateti per conoscere l'ipotemusa *\n"
                + "2. Seno * Inserisci un angolo in radianti per conoscere il seno *\n"
                + "3. Coseno * Inserisci un angolo in radianti per conoscere il coseno *\n"
                + "4. Radice quadrata * Inserisci un numero per conoscere la sua radice quadrata *\n"
                + "5. Logaritmo * Inserisci un numero per conoscere il suo logaritmo in base 10\n");
        i=scan.nextInt();
        switch(i) {
            case 1:
                System.out.println("Inserisci due numeri");
                a=scan.nextDouble();
                b=scan.nextDouble();
                //Teorema.pitagora(a, b);
                System.out.println("Risultato: ");
                break;
            case 2:
                System.out.println("Inserisci un numero");
                a=scan.nextDouble();
                System.out.println("Risultato: ");
                break;
            case 3:
                System.out.println("Inserisci un numero");
                a=scan.nextDouble();
                System.out.println("Risultato: ");
                break;
            case 4:
                System.out.println("Inserisci un numero");
                a=scan.nextDouble();
                System.out.println("Risultato: ");
                break;
            case 5:
                System.out.println("Inserisci un numero");
                a=scan.nextDouble();
                System.out.println("Risultato: ");
                break;
            default:
                System.out.println("odice non valido");
      }
                
    }
    
}
