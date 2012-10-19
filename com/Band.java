/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.GregorianCalendar;
import java.util.ArrayList;

/**
 *
 * @author guetar
 */
public class Band {

    private ArrayList<Mitglied> mitglieder;
    private ArrayList<Song> repertoire;
    private ArrayList<Probe> proben;
    private ArrayList<Auftritt> auftritte;
    private ArrayList<Ort> orte;
    private ArrayList<Probe> proben_trash;
    private ArrayList<Auftritt> auftritt_trash;


    public Band() {
        mitglieder = new ArrayList<Mitglied>();
        repertoire = new ArrayList<Song>();
        proben = new ArrayList<Probe>();
        auftritte = new ArrayList<Auftritt>();
    }

    // Mitglieder
    public void mitglied_hinzufuegen(Mitglied _m) {
        mitglieder.add(_m);
    }

    public void mitglied_entfernen(Mitglied _m) {
        if (mitglieder.contains(_m)) {
            mitglieder.remove(_m);
        }
    }

    public ArrayList<Mitglied> mitglieder_auflisten() {
        return mitglieder;
    }

    public ArrayList<Mitglied> mitglieder_auflisten(GregorianCalendar _von, GregorianCalendar _bis) {
        ArrayList<Mitglied> mitglieder_liste = new ArrayList<Mitglied>();

        for (Mitglied m : mitglieder) {
            if (m.getVon().before(_bis) && m.getBis().after(_von)) {
                mitglieder_liste.add(m);
            }
        }

        return mitglieder_liste;
    }

    // Repertoire
    public void song_hinzufuegen(Song _s) {
        repertoire.add(_s);
    }

    public void song_entfernen(Song _s) {
        if (repertoire.contains(_s)) {
            repertoire.remove(_s);
        }
    }

    public ArrayList<Song> songs_auflisten() {
        return repertoire;
    }

    public ArrayList<Song> songs_auflisten(GregorianCalendar _von) {
        ArrayList<Song> repertoire_liste = new ArrayList<Song>();

        for (Song m : repertoire) {
            if (_von.before(m.getVon())) {
                repertoire_liste.add(m);
            }
        }

        return repertoire_liste;
    }

    // Termine
    public ArrayList<Termin> termine_auflisten(GregorianCalendar _von, GregorianCalendar _bis) {
        ArrayList<Termin> termin_liste = new ArrayList<Termin>();

        for (Termin t : proben) {
            if (_von.before(t.getVon()) && _bis.after(t.getBis())) {
                termin_liste.add(t);
            } else if (_bis.before(t.getBis())) {
                break;
            }
        }

        for (Termin t : auftritte) {
            if (_von.before(t.getVon()) && _bis.after(t.getBis())) {
                termin_liste.add(t);
            } else if (_bis.before(t.getBis())) {
                break;
            }
        }

        return termin_liste;
    }

    // Proben
    public void probe_hinzufuegen(Probe _p) {
        for (int i = 0; i < proben.size(); i++) {
            if (_p.getVon().before(proben.get(i).getVon())) {
                proben.add(i, _p);
                return;
            }
        }
        proben.add(_p);
    }

    public void probe_entfernen(Probe _p) {
        if (proben.contains(_p)) {
            proben.remove(_p);
        }
    }

    public ArrayList<Probe> proben_auflisten(GregorianCalendar _von, GregorianCalendar _bis) {
        ArrayList<Probe> proben_liste = new ArrayList<Probe>();

        for (Probe p : proben) {
            if (_von.before(p.getVon()) && _bis.after(p.getBis())) {
                proben_liste.add(p);
            } else if (_bis.before(p.getBis())) {
                break;
            }
        }

        return proben_liste;
    }

    // Auftritte
    public void auftritt_hinzufuegen(Auftritt _a) {
        for (int i = 0; i < proben.size(); i++) {
            if (_a.getVon().before(proben.get(i).getVon())) {
                auftritte.add(i, _a);
                return;
            }
        }
        auftritte.add(_a);
    }

    public void auftritt_entfernen(Auftritt _a) {
        if (auftritte.contains(_a)) {
            auftritte.remove(_a);
        }
    }

    public ArrayList<Auftritt> auftritte_auflisten(GregorianCalendar _von, GregorianCalendar _bis) {
        ArrayList<Auftritt> auftritte_liste = new ArrayList<Auftritt>();

        for (Auftritt a : auftritte) {
            if (_von.before(a.getVon()) && _bis.after(a.getBis())) {
                auftritte_liste.add(a);
            } else if (_bis.before(a.getBis())) {
                break;
            }
        }

        return auftritte_liste;
    }

    public int kosten_summieren(GregorianCalendar _von, GregorianCalendar _bis) {
        int kosten = 0;
        ArrayList<Probe> proben_kosten = proben_auflisten(_von, _bis);

        for (Probe p : proben_kosten) {
            kosten += p.getMiete();
        }

        return kosten;
    }

    public int umsatz_summieren(GregorianCalendar _von, GregorianCalendar _bis) {
        int umsatz = 0;
        ArrayList<Auftritt> auftritte_kosten = auftritte_auflisten(_von, _bis);

        for (Auftritt a : auftritte_kosten) {
            umsatz += a.getGage();
        }

        return umsatz;
    }

    public int gewinn_summieren(GregorianCalendar _von, GregorianCalendar _bis) {
        return umsatz_summieren(_von, _bis) - kosten_summieren(_von, _bis);
    }

    /**
     * liefert Liste mit Orten, die eine bestimmte Infrastruktur haben.
     *
     * @param zplaetze Gesuchte Anzahl an ZuschauerplÃ¤tzen(oder 0, wenn egal)
     * @param asteckdosen Gesuchte Anzahl an Steckdosen(oder 0, wenn egal)
     * @param catering true setzen,wenn Catering vorhanden sein soll, false,
     * wenn egal
     * @return die Orte, die die bestimmte Infrastruktur haben. null, wenn kein
     * Ort die Voraussetzungen erfuellt.
     */
    public ArrayList<Ort> finde_Ort(int zplaetze, int asteckdosen, boolean catering) {
        ArrayList<Ort> geforte = new ArrayList<Ort>();
        for (Ort o : orte) {
            if (!catering || (catering && o.hatCatering())) {
                if (o.getAnzSteckdosen() >= asteckdosen && o.getAnzZuschauerPl() >= zplaetze) {
                    geforte.add(o);
                }
            }
        }
        if (geforte.isEmpty()) {
            return null;
        }

        return geforte;
    }
}
