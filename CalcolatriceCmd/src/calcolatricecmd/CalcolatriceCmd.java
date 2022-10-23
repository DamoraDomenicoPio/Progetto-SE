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
        Funzioni f=new Funzioni(0.0);
        Scanner scan = new Scanner(System.in);
        System.out.println("*** CALCOLATRICE ***\n");
        while (i!=-1){
            System.out.println("Quale operazione intendi fare?");
            System.out.print("1. Pitagora * Inserire 2 cateti per conoscere l'ipotemusa *\n"
                    + "2. Seno * Inserisci un angolo in radianti per conoscere il seno *\n"
                    + "3. Coseno * Inserisci un angolo in radianti per conoscere il coseno *\n"
                    + "4. Radice quadrata * Inserisci un numero per conoscere la sua radice quadrata *\n"
                    + "5. Logaritmo * Inserisci un numero per conoscere il suo logaritmo in base 10\n"
                    + "6. Tangente * Inserisci un angolo in radianti per conoscere la tangente *\n"
                    + "7. Cotangente * Inserisci un angolo in radianti per conoscere la cotangente *\n"
                    + "8. Memorizza valore * Inserisci un numero per memorizzarlo *\n"
                    + "9. Visualizza valore * Visualizza il valore memorizzato precedentemente *\n"
                    + "10. Addizione * Inserisci 2 numeri per conoscere la loro somma *\n"
                    + "11. Sottrazione * Inserisci 2 numeri per conoscere la loro sottrazione *\n"
                    + "12. Moltiplicazione * Inserisci 2 numeri per conoscere la loro moltiplicazione *\n"
                    + "13. Divisione * Inserisci 2 numeri per conoscere la loro divisione *\n");
            i=scan.nextInt();
            switch(i) {
                case 1:
                    System.out.println("Inserisci due numeri");
                    a=scan.nextDouble();
                    b=scan.nextDouble();
                    //Teorema.pitagora(a, b);
                    System.out.println("Risultato: " + Funzioni.pitagora(a, b));
                    break;
                case 2:
                    System.out.println("Inserisci un numero");
                    a=scan.nextDouble();
                    System.out.println("Risultato: " + Funzioni.seno(a));
                    break;
                case 3:
                    System.out.println("Inserisci un numero");
                    a=scan.nextDouble();
                    System.out.println("Risultato: " + Funzioni.coseno(a));
                    break;
                case 4:
                    System.out.println("Inserisci un numero");
                    a=scan.nextDouble();
                    System.out.println("Risultato: " + Funzioni.radicaQuadrata(a));
                    break;
                case 5:
                    System.out.println("Inserisci un numero");
                    a=scan.nextDouble();
                    System.out.println("Risultato: " + Funzioni.logaritmo10(a));
                    break;
                case 6:
                    System.out.println("Inserisci un numero");
                    a=scan.nextDouble();
                    System.out.println("Risultato: " + Funzioni.tangente(a));
                    break;
                case 7:
                    System.out.println("Inserisci un numero");
                    a=scan.nextDouble();
                    System.out.println("Risultato: " + Funzioni.cotangente(a));
                    break;
                case 8:
                    System.out.println("Inserisci un numero");
                    a=scan.nextDouble();
                    f.setVal(a);
                    System.out.println("Valore memorizzato");
                    break;
                case 9:
                    System.out.println("Inserisci un numero");
                    System.out.println("Valore memorizzato:" + f.getVal());
                    break;
                case 10:
                    System.out.println("Inserisci due numeri");
                    a=scan.nextDouble();
                    b=scan.nextDouble();
                    System.out.println("Risultato: " + Funzioni.somma(a, b));
                    break;
                case 11:
                    System.out.println("Inserisci due numeri");
                    a=scan.nextDouble();
                    b=scan.nextDouble();
                    System.out.println("Risultato: " + Funzioni.sottrazione(a, b));
                    break;
                case 12:
                    System.out.println("Inserisci due numeri");
                    a=scan.nextDouble();
                    b=scan.nextDouble();
                    System.out.println("Risultato: " + Funzioni.moltiplicazione(a, b));
                    break;
                case 13:
                    System.out.println("Inserisci due numeri");
                    a=scan.nextDouble();
                    b=scan.nextDouble();
                    System.out.println("Risultato: " + Funzioni.divisione(a, b));
                    break;
                default:
                    if(i!=-1){
                        System.out.println("Codice non valido");
                    }   
            }
            System.out.println();
        }
        
                
    }
    
}
