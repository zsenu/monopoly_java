package beadando2;
/**
 * Telek mező.
 * @author fiokn
 */
public class Property extends Field
{
    /**
     * A telek birtokoltsági állapotát jelző logikai változó.
     */
    private boolean owned = false;
    /**
     * A telek tulajdonosa. Ha nem birtokolja senki, null értéket vesz fel.
     */
    private Player  owner = null;
    /**
     * Megadja, hogy a telekre van-e ház építve.
     */
    private boolean house = false;
 
    public Property(int p)    { super(p);     }
    
    /**
     * basic getter
     * @return A telek birtokoltságát adja meg (logikai változó)
     */
    public boolean isOwned()  { return owned; }
    /**
     * basic getter
     * @return A telek tulajdonosát adja vissza. Tulajdonos hiányában null értéket ad vissza.
     */
    public Player  getOwner() { return owner; }
    /**
     * basic getter
     * @return Megadja, hogy van-e a telekre ház építve.
     */
    public boolean hasHouse() { return house; }
    /**
     * p játékos megveszi a telket, azaz számlája terhelődik, és az általa birtokolt telkek állománya bővül.
     * @param p 
     */
    public void buyProperty(Player p)
    {
        owned = true;
        owner = p;
        p.changeBalance(-1000);
        p.buy(this);
    }
    /**
     * p játékos házat épít telkére, melynek hatására számlája terhelődik.
     * @param p 
     */
    public void buyHouse(Player p)
    {
        house = true;
        p.changeBalance(-4000);
    }
    /**
     * p játékos a telek tulajdonosának a ház létezésétől függően díjat fizet, ha nincs elég pénze, akkor csak annyit, amennyije maradt.
     * @param p 
     */
    public void payOwner(Player p)
    {
        int cost = (house ? 2000 : 500);
        if (p.getBalance() >= cost)
            { owner.changeBalance(cost); }
        else
            { owner.changeBalance(p.getBalance()); }
        p.changeBalance(-cost);
    }
    /**
     * A mohó játékos döntési sorozata a mezőre lépés során.
     * @param g 
     */
    @Override
    protected void action(Greedy g)
    {
        if (!owned && g.getBalance() >= 1000)
        { buyProperty(g); }
        else if (owned && owner == g && !house && g.getBalance() >= 4000)
        { buyHouse(g); }
        else if (owned && owner != g)
        { payOwner(g); }
    }
    /**
     * Az óvatos játékos döntési sorozata a mezőre lépés során.
     * @param c 
     */
    @Override
    protected void action(Careful c)
    {
        if (!owned && c.getBalance() >= 2000)
        { buyProperty(c); }
        else if (owned && owner == c && !house && c.getBalance() >= 8000)
        { buyHouse(c); }
        else if (owned && owner != c)
        { payOwner(c); }
    }
    /**
     * A taktikus játékos döntési sorozata a mezőre lépés során.
     * @param t 
     */
    @Override
    protected void action(Tactician t)
    {
        if (!owned && t.getBalance() >= 1000 && t.choice() )
        { buyProperty(t); }
        else if (owned && owner == t && !house && t.getBalance() >= 4000 && t.choice())
        { buyHouse(t); }
        else if (owned && owner != t)
        { payOwner(t); }
    }
    /**
     * A mező adatainak kiírása a feladat megoldásakor.
     * @return String formában a telek adatait felsorolja.
     */
    @Override
    public String toString()
    {
        String res  = "\nposition:\t" +  super.position + "\n";
               res += "has house:\t"  + (house ? "yes" : "no");
        return res;
    }
    public void reset() { owned = false; owner = null; house = false; }
}