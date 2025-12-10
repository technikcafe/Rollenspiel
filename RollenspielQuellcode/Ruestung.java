public class Ruestung {
    private Helm helm;
    private Schild schild;
    private Brustpanzer brustpanzer;
    int summeVerteidigungspunkte;
    
    public Ruestung(){
        helm = new Helm();
        schild = new Schild();
        brustpanzer = new Brustpanzer();
        
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