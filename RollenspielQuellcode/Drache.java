//import java.util.Random;

/**
 * Die Klasse Drache repräsentiert einen Drachen in einem Spiel.
 * Sie verwaltet den Namen, die Lebenspunkte und den Angriffsschaden des Drachen.
 */
public class Drache{
    // Instanzvariablen
    private String name;          // Der Name des Drachen
    private int lebenspunkte;     // Aktuelle Lebenspunkte des Drachen
    private int angriffschaden;   // Basisschaden des Drachenangriffs

    /**
     * Konstruktor für die Drache-Klasse.
     * Erstellt einen Drachen mit zufälligen Lebenspunkten zwischen 200 und 399.
     * 
     * @param pName Der Name des Drachen
     */
    public Drache(String pName){
        name = pName;
        // Zufällige Lebenspunkte zwischen 200 und 399 (200 + 0-199)
        lebenspunkte = (int) ((Math.random()*200)+200);
        angriffschaden = 50;  // Fester Basisschaden von 50
    }

    /**
     * Verteidigt den Drachen gegen einen Angriff.
     * Hat eine 20% Chance, dem Angriff auszuweichen.
     * Wenn nicht ausgewichen wird, werden Lebenspunkte abgezogen.
     * 
     * @param pAngriff Der Schadenswert des Angriffs
     */
    public void blocken(int pAngriff){
        // 20% Chance auszuweichen (Zufallszahl > 80)
        if(zufallszahl(0,100)>80){
            System.out.println("Der Drache weicht dem Angriff aus!");        
            return ;  // Frühzeitiger Rückzug, kein Schaden wird genommen
        }else{
            // Überprüfen, ob der Angriff den Drachen besiegen würde
            if(lebenspunkte - pAngriff <= 0){
                lebenspunkte = 0;
                System.out.println("Drache ist besiegt!");
            }
            else{
                // Normalen Schaden abziehen
                lebenspunkte = lebenspunkte - pAngriff; 
            }
        }
    }

    /**
     * Führt einen Angriff des Drachen aus.
     * Hat eine 10% Chance für einen kritischen Feuerangriff.
     * 
     * @return Der Schadenswert des Angriffs
     */
    public int angriff(){
        angriffschaden = (int)(angriffschaden*zufallszahl(50,150)/100);
        // 5% Chance für kritischen Treffer (Zufallszahl > 95)
        if(zufallszahl(0,100)>95){
            // FEHLER: Hier wird angriffschaden zurückgegeben, aber die Ausgabe sagt angriffschaden*10
            System.out.println("Der Drache speit Feuer und greift dich mit " + angriffschaden*5 + " an");        
            return angriffschaden*5; 
        }
        // Normaler Angriff
        System.out.println("Der Drache greift mit " + angriffschaden + " an");        
        return angriffschaden;
    }
    
    public String getName(){
        return name;
    }
    
    public boolean besiegt(){
        if(lebenspunkte > 0){
            return false;
        }
        else{
            return true;
        }
    }
    /**
     * Generiert eine Zufallszahl innerhalb eines Bereichs.
     * Private Hilfsmethode für Zufallsberechnungen.
     * 
     * @param min Die untere Grenze (inklusive)
     * @param max Die obere Grenze (exklusive)
     * @return Eine zufällige Ganzzahl zwischen min (inklusive) und max (exklusive)
     */
    private int zufallszahl(int min, int max){
        return (int) (Math.random()*(max-min)+min);
    }
}