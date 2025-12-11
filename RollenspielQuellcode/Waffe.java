/**
 * Die Klasse Waffe repräsentiert eine Waffe in einem Spiel.
 * Sie verwaltet Schadenswert, Haltbarkeit und Namen der Waffe.
 */
public class Waffe
{
    // Instanzvariablen
    private int schaden;        // Der Schaden, den die Waffe verursacht
    private int haltbarkeit;    // Die verbleibende Haltbarkeit der Waffe
    private String name;        // Der Name der Waffe
    
    /**
     * Standard-Konstruktor, der eine Waffe mit Standardwerten erstellt.
     * Standardwerte: Schaden=20, Haltbarkeit=100, Name="Schwert"
     */
    public Waffe()
    {
       schaden = 20;
       haltbarkeit = 100;
       name = "Schwert";
    }
    
    /**
     * Konstruktor mit Parametern zur Erstellung einer individuellen Waffe.
     * ACHTUNG: Dieser Konstruktor enthält einen Fehler - die Parameterzuweisungen sind falsch!
     * Die Parameter sollten den Instanzvariablen zugewiesen werden, nicht umgekehrt.
     * 
     * @param pSchaden Der Basis-Schadenswert der Waffe
     * @param pHaltbarkeit Die Haltbarkeit der Waffe
     * @param pName Der Name der Waffe
     */
    public Waffe(int pSchaden, int pHaltbarkeit, String pName)
    {
        schaden = (int)(pSchaden * (zufallszahl(100,200) / 100.0));
        pHaltbarkeit = pHaltbarkeit; 
        name = pName;               
    }

    /**
     * Führt einen Schlag mit der Waffe aus.
     * Reduziert die Haltbarkeit und passt den Schaden an.
     * Wenn die Haltbarkeit auf 0 fällt, wird die Waffe unbrauchbar.
     * 
     * @return Den aktuellen Schadenswert nach dem Schlag
     */
    public int schlagen()
    {
        if(haltbarkeit > 0)  // Überprüfung, ob die Waffe noch intakt ist
        {
            if(haltbarkeit<10){
                haltbarkeit = 0;
            } else {
                haltbarkeit = haltbarkeit - 10;  // Haltbarkeit um 10 reduzieren
            }            
        }
        else  // Waffe ist kaputt
        {
            schaden = 0;  // Kaputte Waffe verursacht keinen Schaden
            System.out.println("Waffe kaputt");  // Hinweis an den Spieler
        }
        
        return schaden;  // Rückgabe des aktuellen Schadenswerts
    }
    
    /**
     * Generiert eine Zufallszahl innerhalb eines Bereichs.
     * Die Methode ist privat, da sie nur intern verwendet wird.
     * 
     * @param min Die untere Grenze (inklusive)
     * @param max Die obere Grenze (exklusive)
     * @return Eine zufällige Ganzzahl zwischen min (inklusive) und max (exklusive)
     */
    private int zufallszahl(int min, int max){
        return (int) (Math.random() * (max - min) + min);
    }
}