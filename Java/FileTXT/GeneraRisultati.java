/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popoladatabase;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1997g
 */
public class GeneraRisultati {

    public static void main(String[] args) {
        String campionato;
        int num;
        int cont = 0;
        int punteggio;
        String tempoms;
        int inizio;
        String nomeFile = "risultati.txt";

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter(":");

        System.out.print("Numero Campionato: ");
        campionato = sc.nextLine();
        System.out.print("Numero giornate da inserire per questo campionato: ");
        num = Integer.parseInt(sc.nextLine());
        System.out.print("Da quale giornata vuoi inserire? ");
        inizio = Integer.parseInt(sc.nextLine());

        try (BufferedWriter out = new BufferedWriter(new FileWriter(nomeFile, true))) {

            //PER OGNI PILOTA:
            while (cont < num) {
                for (int i = 0; i < 20; i++) {
                    out.write((campionato) + ":");
                    out.write((cont + inizio) + ":");

                    System.out.print("Codice Pilota: ");
                    out.write(sc.nextLine() + ":");

                    System.out.print("Punteggio: ");
                    punteggio = Integer.parseInt(sc.nextLine());
                    out.write(punteggio + ":");

                    System.out.print("Miglior tempo (mm:ss:lll): ");
                    tempoms = sc.nextLine();
                    out.write(tempoms + ":");

                    System.out.print("Tempo Qualifica (mm:ss:lll): ");
                    out.write(sc.nextLine() + ":");

                    if (punteggio == 0 & tempoms.compareTo("0:0:0") == 0) {
                        out.write("1");
                    } else {
                        out.write("0");
                    }
                    System.out.println("PILOTA INSERITO\n");
                    out.newLine();
                }
                cont++;
            }

        } catch (IOException ex) {
            Logger.getLogger(GeneraRisultati.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
