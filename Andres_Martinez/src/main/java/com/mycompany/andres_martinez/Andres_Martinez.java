package com.mycompany.andres_martinez;
import java.util.Scanner;

public class Andres_Martinez {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        float n1, n2, n3, n4, n5, n6, n7;
        float c1, c2, c3, c4, nt, nt1, nt2, nt3, nt4;
        
        System.out.print("Ingrese la nota 1 del primer corte (5%): ");
        n1 = teclado.nextFloat();
        System.out.println("");
        
        System.out.print("Ingrese la nota 2 del primer corte (15%): ");
        n2 = teclado.nextFloat();
        System.out.println("");
        
        System.out.print("Ingrese la nota 1 del segundo corte (10%): ");
        n3 = teclado.nextFloat();
        System.out.println("");
        
        System.out.print("Ingrese la nota 2 del segundo corte (10%): ");
        n4 = teclado.nextFloat();
        System.out.println("");
        
        System.out.print("Ingrese la nota 1 del tercer corte (10%): ");
        n5 = teclado.nextFloat();
        System.out.println("");
        
        System.out.print("Ingrese la nota 2 del tercer corte (20%): ");
        n6 = teclado.nextFloat();
        System.out.println("");
        
        System.out.print("Ingrese la nota del cuarto corte (30%): ");
        n7 = teclado.nextFloat();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
        c1 = (n1 * (float)5/100) + (n2 * (float)15/100);
        c2 = (n3 * (float)10/100) + (n4 * (float)10/100);
        c3 = (n5 * (float)10/100) + (n6 * (float)20/100);
        c4 = n7 * (float)30/100;
        
        nt = c1 + c2 + c3 + c4;
        
        nt1= c1*(float)(100/20);
        nt2= c2*(float)(100/20);
        nt3= c3*(float)(100/30);
        nt4= c4*(float)(100/30);
        
        System.out.println("-----------------------------------------------------");
        System.out.println("Nota del primer corte: " + nt1);
        System.out.println("-----------------------------------------------------");
        System.out.println("Nota del segundo corte: " + nt2);
        System.out.println("-----------------------------------------------------");
        System.out.println("Nota del tercer corte: " + nt3);
        System.out.println("-----------------------------------------------------");
        System.out.println("Nota del cuarto corte: " + nt4);
        System.out.println("-----------------------------------------------------");
        System.out.println("Nota final total: " + nt);
        System.out.println("-----------------------------------------------------");
        
        if (nt < 60) {
            System.out.println("Perdió la materia");
        } else if (nt >= 60 && nt < 85) {
            System.out.println("Nota buena");
        } else {
            System.out.println("Nota excelente");
        }
    }
}

// Se le solicita desarrollar un programa en java netbeans que pida 4 notas, corte 1 20%, corte 2 20%, corte 30% tenga en cuanta que
//que pida 7 notas y me saque las definitivas por corte. Tambien debera sacar la definitiva del semestre.
// al finalizar si la definitiva esta entre 0 y 60 pierde, 60 y 85 bueno, 85 a 100 excelente