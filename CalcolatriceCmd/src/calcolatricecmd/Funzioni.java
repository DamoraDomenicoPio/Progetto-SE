/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcolatricecmd;

/**
 *
 * @author assun
 */
public class Funzioni {
    double valore; 

    public Funzioni(double valore) {
        this.valore = valore;
    }
    
    public double setVal(double valore) {
        this.valore = valore; 
        return valore; 
    }
    
    public double getVal() {
        return this.valore;
    }
    
    //metodo che, date le lunghezze dei due cateti di un 
    //triangolo rettangolo, restituisce la lunghezza dell'ipotenusa
    public static double pitagora(double a, double b) {
        return Math.sqrt((a*a) + (b*b));
    }
    
    public static double seno(double angolo) {
        return Math.sin(angolo);
    }
    
    public static double coseno(double angolo) {
        return Math.cos(angolo); 
    }

    public static double tangente(double angolo) {
        return Math.tan(angolo);
    }
    
    public static double cotangente (double angolo) {
        return 1/Math.tan(angolo);
    }
    
    public static double radicaQuadrata(double x) {
        return Math.sqrt(x);
    }
    
    public static double logaritmo10(double x) {
        return Math.log(x)/Math.log(10); 
    }
}
