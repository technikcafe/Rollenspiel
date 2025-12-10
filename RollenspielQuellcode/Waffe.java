
public class Waffe
{
    private int schaden;
    private int haltbarkeit;
    private String name;
    
    public Waffe()
    {
       schaden = 20;
       haltbarkeit = 100;
       name = "Schwert";
    }
    
    public Waffe(int pSchaden,int pHaltbarkeit, String pName)
    {
        pSchaden = (int) schaden*(zufallszahl(100,200)/100);
        pHaltbarkeit = haltbarkeit;
        pName = name;
    }

    public int schlagen()
    {
        if(haltbarkeit > 0)
        {
            haltbarkeit = haltbarkeit - 10;
            schaden--;
            
        }
        
        else
        {
            schaden = 0;
            System.out.println("Waffe kaputt");
        }
        
        return schaden;
    }
    private int zufallszahl(int min, int max){
        return (int) (Math.random()*(max-min)+min);
    }
}
