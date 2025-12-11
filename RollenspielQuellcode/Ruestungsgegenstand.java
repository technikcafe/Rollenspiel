public class Ruestungsgegenstand
{
    //Eigenschaften des Rüstungsgegenstand
    private int haltbarkeit;
    private int schutz;
    private String name;
    /*
     * Konstruktor der Klasse
     *erstellt ein neues Objekt vom Typ Ruestungsgegenstand
     *Name wird übernommen und Haltbarkeit sowie Schutz auf die Startwerte gesetzt
     */
    public Ruestungsgegenstand(String pName) 
    {
        haltbarkeit = 100; //Startwert von Haltbarkeit
        schutz = 10; //Startwert von schutz
    }
    // Diese Methode berechnet die aktuellen Verteidigungspunkte
    // Sie hängt davon ab, wie viel Haltbarkeit noch vorhanden ist
    public int getVerteidigungspunkte() {
        return (int) schutz * (haltbarkeit / 100);
    }

    /*
     * Methode zur reduzierung der Haltbarkeit der Rüstungsgegenständen
     * Parameter pHaltbarkeit --> um wie viel die Haltbarkeit sinken soll
     * Wenn das Ergebniss unter Null fällt wird die Haltbarkeit auf 0 gesetzt 
     */
    public void verringereHaltbarkeit(int pHaltbarkeit) {
        if (haltbarkeit - pHaltbarkeit >= 0) {
            haltbarkeit -= pHaltbarkeit;// Haltbarkeit verringern 
        } else {
            haltbarkeit = 0; // mindeswert
        }
    }
}
