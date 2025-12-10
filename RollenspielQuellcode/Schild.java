public class Schild
{
    private int haltbarkeit;
    private int schutz;
    private String name;

    public Schild()
    {
        haltbarkeit = 100;
        schutz = 10;
    }

    public int getVerteidigungspunkte() {
        return (int) schutz * (haltbarkeit / 100);
    }
    
    public void verringereHaltbarkeit(int pHaltbarkeit) {
        if (haltbarkeit - pHaltbarkeit >= 0) {
            haltbarkeit -= pHaltbarkeit;
        } else {
            haltbarkeit = 0;
        }
    }
}
