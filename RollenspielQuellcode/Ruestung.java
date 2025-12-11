public class Ruestung {
    private Ruestungsgegenstand helm;
    private Ruestungsgegenstand schild;
    private Ruestungsgegenstand brustpanzer;
    int summeVerteidigungspunkte;
    
    public Ruestung(){
        helm = new Ruestungsgegenstand("Helm");
        schild = new Ruestungsgegenstand("Schild");
        brustpanzer = new Ruestungsgegenstand("Brustpanzer");
        
    }
    
    public int getVerteidigungspunkte() {
        summeVerteidigungspunkte = 0;
        if(helm != null) {
            summeVerteidigungspunkte = summeVerteidigungspunkte + (helm.getVerteidigungspunkte());
        }
        if(schild != null) {
            summeVerteidigungspunkte = summeVerteidigungspunkte + (schild.getVerteidigungspunkte());
        }
        if(brustpanzer != null) {
            summeVerteidigungspunkte = summeVerteidigungspunkte + (brustpanzer.getVerteidigungspunkte());
        }
        veringereRuestungsHaltbarkeit(2);
        return summeVerteidigungspunkte;
    }
    
    public void veringereRuestungsHaltbarkeit(int pVeringerung) {
        helm.verringereHaltbarkeit(pVeringerung);
        schild.verringereHaltbarkeit(pVeringerung);
        brustpanzer.verringereHaltbarkeit(pVeringerung);
    }
}