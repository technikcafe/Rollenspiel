public class Held {
    private int lebenspunkte;   
    private int angriffschaden;
    private String faehigkeit = "heilen";
    private Ruestung meineRuestung;
    private String name;
    private int erfahrung = 50; // Erfahrung zwischen 0 und 100
    private Waffe meineWaffe;
    private Drache meinDrache;

    public Held(int pLebenspunkte, int pAngriffschaden, String pFaehigkeit, String pName) {
        lebenspunkte = pLebenspunkte;    
        //faehigkeit = pFaehigkeit
        angriffschaden = pAngriffschaden;
        name = pName;
        meineRuestung = new Ruestung();       
        meineWaffe = new Waffe();
        meinDrache = new Drache("Samaug");
    }

    public Held() {    
        lebenspunkte = 100;    
        //faehigkeit;
        meineRuestung = new Ruestung();
        name = "Gandalf";        
        meineWaffe = new Waffe();
        meinDrache = new Drache("Samaug");
    }  
    
    /**
    * Die Methode blocken nimmt den Schaden des Drachens und verringert ihn um die Verteidigungspunkte der Rüstung 
    */
    public void blocken() { 
        int angriff = meinDrache.angriff();
        int schaden = angriff - meineRuestung.getVerteidigungspunkte();
        if(schaden < 0) {
            schaden = 0;
        }
        lebenspunkte = lebenspunkte - schaden;
        if (lebenspunkte <= 0){
            System.out.println("Der Held ist gestorben. Du verlierst!");
        }else{
            System.out.println("Der Drache hat dich mit "+schaden+" HP Angegriffen, du hast "+ schaden+" Lebenspunkte verloren. Es bleiben dir "+ lebenspunkte+" Lebenspunkte");
        }
    }

    /**
    * Die Methode angriff greift den Drachen mit dem Schaden der Waffe an und sammelt Erfahrungspunkte
    */
    public void angriff() {
        int schlagen = meineWaffe.schlagen();//Wir lassen uns die Angriffskraft der Waffe geben     
        int angriff = (int) schlagen+erfahrung;            
        int neueErfahrung = zufallszahl(0,8);  
        System.out.println("Der Drache wurde mit "+angriff+" HP Angegriffen, du hast "+neueErfahrung+" Erfahrungspunkte dazugewonnen");
        erfahrung += neueErfahrung;
        meinDrache.blocken(angriff); 
    }

    /**
    * Die Methode heilen heilt den Held, wenn er weniger als 100HP hat mit einer Wahrscheinlichkeit von 60% um 30-50 HP
    */
    public void heilen () {
        if (lebenspunkte < 100) {
            if(zufallszahl(0,100)>40){
                int heilung = zufallszahl(30,50);  
                lebenspunkte += heilung;
                System.out.println(" Der Held hat sich um "+ heilung +" Lebenspunkte geheilt und hat jetzt "+ lebenspunkte+ " Lebenspunkte");
            }else{
                System.out.println(" Das Heilen war leider nicht erfolgreich, es muss der falsche Trank gewesen sein.");
            }  
        } else {
            System.out.println(" Der Held ist nicht verletzt!");
        }
    }

    /**
    * Die Methode zufallszahl generiert eine Zufallszahl zwischen min und max
    * @param: pMin, pMax
    */
    private int zufallszahl(int pMin, int pMax){
               
        return (int) (Math.random()*(pMax-pMin)+pMin);
        
    }

    /**
    * Die Methode spielen automatisiert den Kampf
    * @param: pRunden
    */
    public void spiele(int pRunden){
        for(int i = 0; i< pRunden;i++){
            angriff();
            blocken();
        }
    }
}
