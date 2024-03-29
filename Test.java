/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.TreeSet;

/**
 *
 * @author guetar
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * Erstellen der Band und eines Zeitraums zur Suche
         */
        GregorianCalendar von = new GregorianCalendar(1985, 2, 21);
        GregorianCalendar bis = new GregorianCalendar(2012, 9, 30);
        Band b = new Band();

        /**
         * Mitglieder erzeugen
         */
        Mitglied andreas = new Mitglied("Andreas Kodolsky", "0676/7787986", "Gitarre");
        Mitglied michael = new Mitglied("Michael Preis", "0664/8798653", "Bass");
        Mitglied lukas = new Mitglied("Lukas Permanschlager", "0676/4382904839", "Schlagzeug");
        Mitglied dominik = new Mitglied("Dominik Haltauf", "0664/473892347", "Bass");

        /**
         * Mitglieder der band hinzufuegen, entfernen und wieder hinzfuegen
         */
        b.mitgliedHinzufuegen(andreas, new GregorianCalendar(2000, 2, 24));
        b.mitgliedHinzufuegen(michael, new GregorianCalendar(2000, 2, 24));
        b.mitgliedHinzufuegen(lukas, new GregorianCalendar(2000, 2, 24));
        b.mitgliedHinzufuegen(dominik, new GregorianCalendar(2000, 4, 6));
        b.mitgliedEntfernen(lukas, new GregorianCalendar(2001, 3, 2));
        b.mitgliedEntfernen(dominik, new GregorianCalendar(2002, 5, 2));
        b.mitgliedHinzufuegen(lukas, new GregorianCalendar(2003, 5, 6));

        /**
         * Ausgabe der Mitglieder zu bestimmten Zeitpunkten
         */
        System.out.println("\nAusgabe Mitglieder----------------------------------");
        System.out.println("Erwarteter Output: \n2000, 3, 12: 3 Mitglieder\n2001, 2, 2: 4 Mitglieder\n2002, 3, 2: 3 Mitglieder\n2003, 3, 2: 2 Mitglieder\naktuell: 3 Mitglieder");
        System.out.println("----------------------------------------------------\n");

        System.out.println("Auflistung der Gruppenmitglieder zum Datum 2000, 3, 12:");
        HashSet<Mitglied> mitglieder = b.mitgliederAuflisten(new GregorianCalendar(2000, 3, 3));
        if (mitglieder != null) {
            for (Mitglied m : mitglieder) {
                System.out.println(m.toString());
            }
        } else {
            System.out.println("Ungültiges Datum");
        }

        System.out.println("\nAuflistung der Gruppenmitglieder zum Datum 2001, 2, 2:");
        mitglieder = b.mitgliederAuflisten(new GregorianCalendar(2001, 2, 2));
        if (mitglieder != null) {
            for (Mitglied m : mitglieder) {
                System.out.println(m.toString());
            }
        } else {
            System.out.println("Ungültiges Datum");
        }

        System.out.println("\nAuflistung der Gruppenmitglieder zum Datum 2002, 3, 2:");
        mitglieder = b.mitgliederAuflisten(new GregorianCalendar(2002, 3, 2));
        if (mitglieder != null) {
            for (Mitglied m : mitglieder) {
                System.out.println(m.toString());
            }
        } else {
            System.out.println("Ungültiges Datum");
        }

        System.out.println("\nAuflistung der Gruppenmitglieder zum Datum 2003, 3, 2:");
        mitglieder = b.mitgliederAuflisten(new GregorianCalendar(2003, 3, 2));
        if (mitglieder != null) {
            for (Mitglied m : mitglieder) {
                System.out.println(m.toString());
            }
        } else {
            System.out.println("Ungültiges Datum");
        }

        System.out.println("\nAuflistung der aktuellen Gruppenmitglieder:");
        mitglieder = b.mitgliederAuflisten();
        if (mitglieder != null) {
            for (Mitglied m : mitglieder) {
                System.out.println(m.toString());
            }
        } else {
            System.out.println("Ungültiges Datum");
        }
        System.out.println("");


        /**
         * Dem Repertoire der Band einige Songs hinzufuegen und und auflisten
         */
        System.out.println("\nAusgabe Songs---------------------------------------");
        System.out.println("Erwarteter Output: \nEINZUFUEGEN");
        System.out.println("----------------------------------------------------\n");

        Song love = new Song("I love you", "04:33", new GregorianCalendar(2002, 2, 2));
        Song nolove = new Song("I loved you but now I love another woman", "03:22", new GregorianCalendar(2003, 2, 4));
        Song notso = new Song("I love you not so much any more", "04:33", new GregorianCalendar(2003, 7, 22));
        Song hate = new Song("I loved you now I hate you", "03:22", new GregorianCalendar(2001, 1, 4));
        love.addVersion(notso);
        nolove.addVersion(hate);

        andreas.addSong(love);
        andreas.addSong(nolove);

        Song herzschmerz = new Song("Mein Herz tut mir so weh!", "03:55", new GregorianCalendar(2000, 8, 4));
        Song beileid = new Song("Mein Beieid!", "05:20", new GregorianCalendar(2002, 6, 6));

        michael.addSong(herzschmerz);
        michael.addSong(beileid);

        ArrayList<Song> repertoire = b.songsAuflisten(new GregorianCalendar(2002, 8, 8), true);

        System.out.println("Auflistung des Repertoires:");
        for (Song s : repertoire) {
            System.out.println(s.toString());
        }
        System.out.println("");

        /**
         * Einige Termine hinzufuegen und auflisten
         */
        System.out.println("\nAusgabe Termine-------------------------------------");
        System.out.println("Erwarteter Output: \nEINZUFUEGEN");
        System.out.println("----------------------------------------------------\n");

        Ort o1 = new Ort("p1 Studio", "Musterstr. 23", 8);
        b.ortHinzufuegen(o1);
        Ort o2 = new Ort("p2 Garage", "Maxerstr. 32", 4);
        b.ortHinzufuegen(o2);
        Ort o3 = new Ort("p3 Keller", "Maxerstr. 32", 4);
        b.ortHinzufuegen(o3);
        Ort o4 = new Ort("p4 Standort", "Maxerstr. 32", 4);
        b.ortHinzufuegen(o4);
        Ort o5 = new Ort("a1 Rauschhaus", "Alkgasse 13", 50);
        b.ortHinzufuegen(o5);
        Ort o6 = new Ort("a2 Gasometer", "Gasstr.666", 3000);
        b.ortHinzufuegen(o6);
        Ort o7 = new Ort("a3 Testhaus", "Teststr.123", 20);
        b.ortHinzufuegen(o7);
        Probe p1 = new Probe(o1, new GregorianCalendar(2001, 6, 5, 18, 0), "3:00", mitglieder, 30);
        Probe p2 = new Probe(o2, new GregorianCalendar(2001, 7, 2, 18, 0), "3:00", mitglieder, 100);
        Probe p3 = new Probe(o3, new GregorianCalendar(2001, 7, 4, 18, 0), "3:00", mitglieder, 100);
        Probe p4 = new Probe(o4, new GregorianCalendar(2002, 7, 6, 18, 0), "3:00", mitglieder, 100);
        Probe p5 = new Probe(o3, new GregorianCalendar(2002, 7, 8, 18, 0), "3:00", mitglieder, 100);
        Probe p6 = new Probe(o4, new GregorianCalendar(2003, 7, 10, 18, 0), "3:00", mitglieder, 100);
        Auftritt a1 = new Auftritt(o5, new GregorianCalendar(2001, 9, 2, 18, 0), "2:00", mitglieder, 800);
        Auftritt a2 = new Auftritt(o6, new GregorianCalendar(2002, 9, 3, 18, 0), "2:00", mitglieder, 800);
        Auftritt a3 = new Auftritt(o7, new GregorianCalendar(2013, 3, 30, 18, 0), "2:00", mitglieder, 200);

        b.terminHinzufuegen(p1);
        b.terminHinzufuegen(p2);
        b.terminHinzufuegen(p3);
        b.terminHinzufuegen(p4);
        b.terminHinzufuegen(a1);
        b.terminHinzufuegen(a3);
        b.terminHinzufuegen(a2);

        ArrayList<? extends Termin> termine = b.termineAuflisten(von, bis);

        System.out.println("Auflistung aller Termine:");
        for (Termin t : termine) {
            System.out.println(t.toString());
        }
        System.out.println("");

        ArrayList<Probe> proben = b.probenAuflisten(von, bis);

        System.out.println("Auflistung aller Proben:");
        for (Probe p : proben) {
            System.out.println(p.toString());
        }
        System.out.println("");

        ArrayList<Auftritt> auftritte = b.auftritteAuflisten(von, bis);

        System.out.println("Auflistung aller Auftritte:");
        for (Auftritt a : auftritte) {
            System.out.println(a.toString());
        }
        System.out.println("");

        /**
         * Termin loeschen und anschließend wiederherstellen
         */
        b.terminLoeschen(p1);
        b.terminAendern(p3, p5);
        b.terminAendern(p4, p6);

        termine = b.termineAuflisten(von, bis);

        System.out.println("Auflistung der Termine nach dem Loeschen von p1,");
        System.out.println("sowie dem Aendern von p3 in p5 bzw p4 in p6:");
        for (Termin t : termine) {
            System.out.println(t.toString());
        }
        System.out.println("");

        b.terminWiederherstellen(p1);
        b.terminWiederherstellen(p3);
        b.terminWiederherstellen(p4);

        System.out.println("Dominiks Nachrichten:");

        ArrayList<String> messages = dominik.getMessages();

        for (String s : messages) {
            System.out.println(s);
        }
        System.out.println("");

        termine = b.termineAuflisten(von, bis);

        System.out.println("Auflistung der Termine nach der Wiederherstellung:");
        for (Termin t : termine) {
            System.out.println(t.toString());
        }
        System.out.println("");

        /**
         * Abstimmen ueber einen Auftritt
         */
        System.out.println("\nAusgabe Abstimmung----------------------------------");
        System.out.println("Erwarteter Output: \nDer Termin, die Abstimmungsergebnisse inklusive Begruendungen der Mitglider,\nLukas ist dagegen und daher findet der Termin nicht statt");
        System.out.println("----------------------------------------------------\n");

        Auftritt moeglAuftritt1 = new Auftritt(new Ort("a2 Gasometer", "Gasstr.666", 3000), new GregorianCalendar(1995, 9, 3, 18, 0), "2:00", mitglieder, 800);
        Abstimmung abstimmungProbe1 = b.abstimmenTermin(moeglAuftritt1);
        abstimmungProbe1.abstimmen(andreas, true, "passt");
        abstimmungProbe1.abstimmen(michael, true, "Leiwand!");
        abstimmungProbe1.abstimmen(lukas, false, "do kau i ned!!");
        abstimmungProbe1.abstimmen(dominik, true, "haut hi");

        /**
         * Ausgabe des Ergebnis der Abstimmung
         */
        String[] ergebnisAbstimmung = abstimmungProbe1.getResult();
        System.out.println(ergebnisAbstimmung[1]);

        if (ergebnisAbstimmung[0].equals("1")) {
            b.terminHinzufuegen(moeglAuftritt1);
            System.out.println(">> Termin findet statt");
        } else if (ergebnisAbstimmung[0].equals("0")) {
            System.out.println(">> Termin findet nicht statt");
        }
        System.out.println("");

        b.postenHinzufuegen(new Posten(200,"Anonyme Spende",new GregorianCalendar(2012,8,24)));
        b.postenHinzufuegen(new Posten(-800,"Neue Gitarre",new GregorianCalendar(2012,1,2)));       
        b.postenHinzufuegen(new Posten(300,"Autogrammstunde",new GregorianCalendar(2012,3,24)));
        b.postenHinzufuegen(new Posten(-300,"Bus Miete",new GregorianCalendar(2006,1,2)));  

        /**
         * Eine Bilanz über den gesuchten Zeitraum erstellen
         */
        System.out.println("\nAusgabe Bilanz------------------------------------");
        System.out.println("Erwarteter Output: \nKosten durch Proben in diesem Zeitraum: 330 Euro"
                +"\nKosten durch Sonstiges in diesem Zeitraum: 1100 Euro"
                +"\nGesamtkosten in diesem Zeitraum: 1430 Euro"
                + "\nUmsatz durch Auftritte in diesem Zeitraum: 1600 Euro"
                +"\nUmsatz durch Sonstiges in diesem Zeitraum: 500 Euro"
                +"\nGesamtumsatz in diesem Zeitraum: 2100 Euro"
                + "\nMacht einen Gesamtgewinn von: 670 Euro");
        System.out.println("----------------------------------------------------\n");
        Bilanz bilanz=b.getBilanz();
        System.out.println("Kosten durch Proben in diesem Zeitraum: " + bilanz.kosten(true, false, von, bis) + " Euro");
        System.out.println("Kosten durch Sonstiges in diesem Zeitraum: " + bilanz.kosten(false, true, von, bis) + " Euro"); 
        System.out.println("Gesamtkosten in diesem Zeitraum: " + bilanz.kosten(true, true, von, bis) + " Euro");         
        System.out.println("Umsatz durch Auftritte in diesem Zeitraum: " + bilanz.umsatz(true, false, von, bis) + " Euro");
        System.out.println("Umsatz durch Sonstiges in diesem Zeitraum: " + bilanz.umsatz(false, true, von, bis) + " Euro");   
        System.out.println("Gesamtumsatz in diesem Zeitraum: " + bilanz.umsatz(true, true, von, bis) + " Euro");        
        System.out.println("Macht einen Gesamtgewinn von: " + bilanz.gewinn(true, true, true, von, bis) + " Euro");
        System.out.println("");

        /**
         * Einige Orte hinzufuegen und auflisten
         */
        System.out.println("\nAusgabe Orte----------------------------------------");
        System.out.println("Erwarteter Output:\nErste Abfrage gibt Orte mit mehr als 200 Plaetze aus,\nzweite mit mehr als 20 Plaetze\ndritte mit mehr als 100.000");
        System.out.println("----------------------------------------------------\n");

        System.out.println("\nOrte mit mehr als 200 Plätzen:");
        ArrayList<Ort> orte = b.findeOrt(200);
        if (!orte.isEmpty()) {
            for (Ort o : orte) {
                System.out.println(o);
            }
        } else {
            System.out.println("Keinen Ort gefunden!");
        }

        System.out.println("\nOrte mit mehr als 20 Plätzen:");
        orte = b.findeOrt(20);
        if (!orte.isEmpty()) {
            for (Ort o : orte) {
                System.out.println(o);
            }
        } else {
            System.out.println("Keinen Ort gefunden!");
        }

        System.out.println("\nOrte mit mehr als 100.000 Plätzen:");
        orte = b.findeOrt(100000);
        if (!orte.isEmpty()) {
            for (Ort o : orte) {
                System.out.println(o);
            }
        } else {
            System.out.println("Keinen Ort gefunden!");
        }

        System.out.println("");
    }
}