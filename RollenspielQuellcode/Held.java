/**
 * Die Klasse Held repräsentiert einen Helden in einem Spiel.
 * Der Held hat Lebenspunkte, Fähigkeiten, Ausrüstung und kämpft gegen einen Drachen.
 */
public class Held {
    // Instanzvariablen
    private int lebenspunkte;           // Aktuelle Lebenspunkte des Helden
    private String faehigkeit;          // Aktive Fähigkeit des Helden
    private Ruestung meineRuestung;     // Die getragene Rüstung
    private String name;                // Name des Helden
    private int erfahrung;              // Erfahrung zwischen 0 und 100
    private Waffe meineWaffe;           // Die geführte Waffe
    private Drache meinDrache;          // Der Gegner-Drache

    /**
     * Konstruktor mit Parametern zur Erstellung eines individuellen Helden.
     * 
     * @param pLebenspunkte Die Lebenspunkte des Helden
     * @param pAngriffschaden Wird nicht verwendet (kann für zukünftige Erweiterungen dienen)
     * @param pFaehigkeit Die Fähigkeit des Helden
     * @param pName Der Name des Helden
     */
    public Held(int pLebenspunkte, int pAngriffschaden, String pFaehigkeit, String pName) {
            
        lebenspunkte = pLebenspunkte;
        faehigkeit =  pFaehigkeit;
        name = pName;
        erfahrung = 50;
        
        // Standardausrüstung und Gegner erstellen
        meineRuestung = new Ruestung();
        meineWaffe = new Waffe();
        meinDrache = new Drache("Smaug");
    }

    /**
     * Standard-Konstruktor, der einen Helden mit Standardwerten erstellt.
     */
    public Held() {
        //Hier wird der andere Konstruktor aufgerufen
        this(100, 0, "heilen", "Gandal");
    }  

    /**
     * Blockiert einen Angriff des Drachen.
     * Berechnet den Schaden basierend auf Drachenangriff und Rüstungsschutz.
     */
    public void blocken() {
        // Prüfen, ob der Held noch lebt
        if (!istAmLeben()) {
            System.out.println(name + " kann nicht blocken, da er bereits besiegt ist!");
            return;
        }
        
        // Prüfen, ob der Drache noch lebt
        if (meinDrache.besiegt()) {
            System.out.println("Der Drache ist bereits besiegt! Es gibt keinen Angriff zu blocken.");
            return;
        }
        
        int angriff = meinDrache.angriff();
        int ruestungsSchutz = meineRuestung.getVerteidigungspunkte();                            
        int schaden = angriff - ruestungsSchutz;
        if(schaden <0){
            schaden = 0;
        }       
        
        int alteLebenspunkte = lebenspunkte;
        lebenspunkte = lebenspunkte - schaden;
        
        // Lebenspunkte können nicht negativ sein
        if(lebenspunkte<0){
            lebenspunkte = 0;
        }
        
        System.out.println(name + " wird mit " + angriff + " Schadenspunkten angegriffen.");
        System.out.println("Rüstung absorbiert " + ruestungsSchutz + " Schadenspunkte.");
        System.out.println(name + " verliert " + (alteLebenspunkte - lebenspunkte) + " Lebenspunkte.");
        
        if (istAmLeben()) {
            System.out.println("Verbleibende Lebenspunkte: " + lebenspunkte);
        } else {
            System.out.println(name + " wurde besiegt!");
        }
    }

    /**
     * Führt einen Angriff auf den Drachen aus.
     * Der Schaden setzt sich aus Waffenschaden und Erfahrung zusammen.
     * Nach einem erfolgreichen Angriff werden Erfahrungspunkte vergeben.
     */
    public void angriff() {
        // Prüfen, ob der Held noch lebt
        if (!istAmLeben()) {
            System.out.println(name + " kann nicht angreifen, da er bereits besiegt ist!");
            return;
        }
        
        // Prüfen, ob der Drache noch lebt
        if (meinDrache.besiegt()) {
            System.out.println("Der Drache ist bereits besiegt!");
            return;
        }
        
        int waffenSchaden = meineWaffe.schlagen();
        int angriff = waffenSchaden + erfahrung;
        int neueErfahrung = zufallszahl(0, 8);
        
        System.out.println("\n" + name + " greift an!");
        System.out.println("Waffenschaden: " + waffenSchaden);
        System.out.println("Erfahrungsbonus: " + erfahrung);
        System.out.println("Gesamtschaden: " + angriff);
        
        erfahrung += neueErfahrung;
               
        System.out.println("Erfahrungspunkte gewonnen: " + neueErfahrung);
        System.out.println("Aktuelle Erfahrung: " + erfahrung);        
        meinDrache.blocken(angriff);
    }

    /**
     * Heilt den Helden um einen zufälligen Betrag.
     * Hat eine 60% Erfolgschance.
     * Kann nur verwendet werden, wenn der Held verletzt ist.
     */
    public void heilen() {
        if (!istAmLeben()) {
            System.out.println(name + " kann nicht geheilt werden, da er bereits besiegt ist!");
            return;
        }
        
        if (lebenspunkte >= 100) {
            System.out.println(name + " ist nicht verletzt!");
            return;
        }
        
        System.out.println( name + " versucht zu heilen...");
        
        if (zufallszahl(0, 100) > 40) {
            int heilung = zufallszahl(30, 50);
            int alteLebenspunkte = lebenspunkte;
            lebenspunkte =  lebenspunkte + heilung;
            int tatsaechlicheHeilung = lebenspunkte - alteLebenspunkte;
            
            System.out.println("Heilung erfolgreich!");
            System.out.println(name + " hat sich um " + tatsaechlicheHeilung + " Lebenspunkte geheilt");
            System.out.println("Aktuelle Lebenspunkte: " + lebenspunkte );
        } else {
            System.out.println("Das Heilen war leider nicht erfolgreich, es muss der falsche Trank gewesen sein.");
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
    private int zufallszahl(int min, int max) {        
        return (int) (Math.random() * (max - min) + min);
    }
    
    /**
     * Simuliert einen Kampf über eine bestimmte Anzahl von Runden.
     * In jeder Runde greift der Held an und blockt dann.
     * Der Kampf endet frühzeitig, wenn der Held oder der Drache besiegt wird.
     * 
     * @param runden Anzahl der Kampfrunden
     */
    public void spiele(int runden) {
        System.out.println("=== KAMPF BEGINNT ===");
        System.out.println(name + " (LP: " + lebenspunkte + ") vs. " + 
                          meinDrache.getName() + " beginnt!");
        
        for (int i = 0; i < runden; i++) {
            System.out.println("\n=== Runde " + (i + 1) + " ===");
            
            // Prüfen, ob der Kampf bereits beendet ist
            if (!istAmLeben()) {
                System.out.println(name + " ist tot! Kampf beendet.");
                break;
            }
            
            if (meinDrache.besiegt()) {
                System.out.println("Der Drache ist besiegt! Kampf gewonnen!");
                break;
            }
            
            angriff();
            
            // Nur blocken, wenn der Drache nach dem Angriff noch lebt
            if (!meinDrache.besiegt()) {
                blocken();
            }
            
            // Kurze Pause für bessere Lesbarkeit
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Unterbrechung ignorieren und weitermachen
                Thread.currentThread().interrupt();
            }
        }
        
        System.out.println("\n=== KAMPF ENDE ===");
        if (istAmLeben() && !meinDrache.besiegt()) {
            System.out.println("HERAUSRAGENDER SIEG!");
        } else if (!istAmLeben()) {
            System.out.println("Der Held wurde besiegt.");
        } else {
            System.out.println("Unentschieden - beide kämpfen weiter.");
        }
    }
    
    // ========== GETTER-METHODEN ==========
    
    /**
     * Überprüft, ob der Held noch am Leben ist.
     * 
     * @return true, wenn der Held noch Lebenspunkte hat, sonst false
     */
    private boolean istAmLeben() {
        return lebenspunkte > 0;
    }
    
    /**
     * Zeigt den aktuellen Status des Helden an.
     */
    private void zeigeStatus() {
        System.out.println("\n=== STATUS VON " + name.toUpperCase() + " ===");
        System.out.println("Lebenspunkte: " + lebenspunkte);
        System.out.println("Erfahrung: " + erfahrung);
        System.out.println("Fähigkeit: " + faehigkeit);
        //System.out.println("Waffe: " + meineWaffe.getName());
        //System.out.println("Rüstung: " + (meineRuestung != null ? "Vorhanden" : "Keine"));
        System.out.println("Status: " + (istAmLeben() ? "Am Leben" : "Besiegt"));
    }
}