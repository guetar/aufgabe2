/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author guetar
 */
public class Mitglied {

    private String name;
    private String tel;
    private String instrument;
    private ArrayList<Song> repertoire;
    private ArrayList<String> messages;
    private ArrayList<Termin> termine;

    /**
     * Konstruktor
     * 
     * @param name Name
     * @param tel Telefonnummer
     * @param instrument Instrument
     * @param von Eintrittsdatum in die Band
     * @param bis Austrittsdatum aus der Band
     */
    public Mitglied(String name, String tel, String instrument) {
        this.name = name;
        this.tel = tel;
        this.instrument = instrument;
        this.repertoire = new ArrayList<Song>();
        this.messages = new ArrayList<String>();
        this.termine = new ArrayList<Termin>();
    }
    
    /**
     * Speichert die Nachrichten zu Terminaenderungen, die das Mitglied betreffen
     * 
     * @param m Nachricht
     * @return Erfolg
     */
    public Boolean message(String m) {
        return messages.add(m);
    }
    
    /**
     * Liefert alle eingegangenen Nachrichten
     * 
     * @return Nachrichten 
     */
    public ArrayList<String> getMessages() {
        return messages;
    }
    
    /**
     * Fuegt dem Repertoire des Mitglieds einen Song hinzu.
     * 
     * @param s hinzuzufuegender Song
     * @return Erfolg
     */
    public Boolean addSong(Song s) {
        return repertoire.add(s);
    }
    
    /**
     * Gibt das Repertoire des Mitglieds zurück
     */
    public ArrayList<Song> getRepertoire() {
        return repertoire;
    }
    
    /**
     * Fügt Termin hinzu
     * 
     * @param t hinzuzufügender Song
     * @return "true" wenn erfolgreich, "false", wenn schon vorhanden
     */
    public boolean addTermin(Termin t) {
        return termine.add(t);
    }
    
    /**
     * Entfernt Termin
     * 
     * @param t zu entfernender Termin
     * @return "true" wenn erfolgreich, "false", wenn nicht vorhanden
     */
    public boolean removeTermin(Termin t) {
        return termine.remove(t);
    }

    /**
     * Getter für Name
     * 
     * @return Name
     */
    public String getName() {
        return name;
    }

    @Override
    /**
     * Liefert die Daten des Mitglieds als String getrennt durch Leerzeichen in
     * der Reihenfolge: Name, Telefonnummer und Instrument
     */
    public String toString() {
        return name + " " + tel + " " + instrument;
    }
}
