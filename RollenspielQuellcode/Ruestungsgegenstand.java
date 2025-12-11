/**
 * Die Klasse Ruestungsgegenstand repräsentiert einen einzelnen Rüstungsgegenstand
 * wie Helm, Schild oder Brustpanzer.
 * 
 * ToDO:
 * - schutz über einen Parameter abfragen, dait verschieden Rüstungen verschieden Schutz bieten
 * 
 * 
 */
public class Ruestungsgegenstand
{
    // Instanzvariablen
    private int haltbarkeit;    // Haltbarkeit in Prozent (0-100)
    private int schutz;         // Basisschutz des Rüstungsteils
    private String typ;         // Art des Rüstungsteils (z.B. "Helm", "Schild")

    /**
     * Konstruktor für einen Rüstungsgegenstand.
     * FEHLER: Alle Rüstungsgegenstände haben die gleichen Werte, unabhängig vom Typ.
     * 
     * @param pTyp Der Typ des Rüstungsgegenstands
     */
    public Ruestungsgegenstand(String pTyp)
    {
        haltbarkeit = 100;
        schutz = 10;
        typ = pTyp;  
    }

    /**
     * Berechnet die aktuellen Verteidigungspunkte basierend auf Schutz und Haltbarkeit.
     * FEHLER: Ganzzahldivision führt zu falschen Ergebnissen!
     * 
     * @return Die aktuellen Verteidigungspunkte
     */
    public int getVerteidigungspunkte() {
        return (int)( schutz *  (haltbarkeit / 100.0));
    }
    
    /**
     * Verringert die Haltbarkeit des Rüstungsgegenstands.
     * FEHLER: Parametername ist irreführend - es sollte pVerringerung heißen.
     * 
     * @param pHaltbarkeit Die Menge, um die die Haltbarkeit verringert wird
     */
    public void verringereHaltbarkeit(int pHaltbarkeit) {
        if (haltbarkeit - pHaltbarkeit >= 0) {
            haltbarkeit -= pHaltbarkeit;
        } else {
            haltbarkeit = 0;
        }
    }
}