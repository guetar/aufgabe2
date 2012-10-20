/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.GregorianCalendar;

/**
 *
 * @author Matthias
 */
public class Posten {

    private int wert;
    private String beschreibung;
    private GregorianCalendar datum;
    private Termin termin;

    /**
     * Erstellt eine neue Instanz von Posten
     *
     * @param wert positiv oder negativ, je nach dem, ob Umsatz oder Kosten
     * @param beschreibung textuelle beschreibung des Postens(null bei einem
     * Termin)
     * @param datum Datum
     * @param termin Termin, auf den sich der Posten bezieht, sonst null
     */
    public Posten(int wert, String beschreibung, GregorianCalendar datum, Termin termin) {
        this.wert = wert;
        this.datum = datum;
        if (termin != null) {
            this.beschreibung = (termin instanceof Auftritt) ? "Auftritt" : "Probe";
        } else {
            this.beschreibung = beschreibung;
        }
    }
    /**
     * Getter Methode des Datums
     * @return Datum des Postens
     */
    public GregorianCalendar getDatum(){
    return datum;
    }
    
    /**
     * Getter Methode des Wert
     * @return Wert des Postens
     */
    public int getWert(){
    return wert;
    }
    
    /**
     * Getter Methode für die Beschreibung
     * @return Beschreibung des Postens
     */
    public String getBeschr(){
    return beschreibung;
    }
}
