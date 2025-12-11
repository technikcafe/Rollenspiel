
public class Ruestung {
    private Ruestungsgegenstand helm;
    private Ruestungsgegenstand schild;
    private Ruestungsgegenstand brustpanzer;   
    
    public Ruestung() {
        // Initialisiert die Rüstungsgegenstände mit Standardwerten
        helm = new Ruestungsgegenstand("Helm");
        schild = new Ruestungsgegenstand("Schild");
        brustpanzer = new Ruestungsgegenstand("Brustpanzer");        
    }
    
    /**
     * Berechnet die Summe der Verteidigungspunkte aller Rüstungsgegenstände.
     * Verringert dabei die Haltbarkeit der Rüstung um den angegebenen Wert.
     * 
     * @return Die Summe der Verteidigungspunkte
     */
    public int getVerteidigungspunkte() {
        int summeVerteidigungspunkte = 0; 
        if (helm != null) {
            summeVerteidigungspunkte += helm.getVerteidigungspunkte();
        }
        if (schild != null) {
            summeVerteidigungspunkte += schild.getVerteidigungspunkte();
        }
        if (brustpanzer != null) {
            summeVerteidigungspunkte += brustpanzer.getVerteidigungspunkte();
        }
        veringereRuestungsHaltbarkeit(2); 
        return summeVerteidigungspunkte;
    }
    
    /**
     * Verringert die Haltbarkeit aller Rüstungsgegenstände um den angegebenen Wert.
     * 
     * @param pVeringerung Der Wert, um den die Haltbarkeit verringert wird.
     */
    public void veringereRuestungsHaltbarkeit(int pVeringerung) {        
        helm.verringereHaltbarkeit(pVeringerung);
        schild.verringereHaltbarkeit(pVeringerung);
        brustpanzer.verringereHaltbarkeit(pVeringerung);
    }
}