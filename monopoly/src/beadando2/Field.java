package beadando2;
/**
 * A különböző mezőket koordináló szülőosztály
 * @author fiokn
 */
public abstract class Field
{
    /**
     * A táblán belüli saját pozícióját tárolja, a telkek listázásához szükséges.
     */
    protected int position;
    
    protected Field(int p) { position = p; }
    /**
     * p játékost taktikája szerint kiválogatja
     * @param p 
     */
    public void action(Player p)
    {
        switch (p)
        {
            case Greedy g -> action(g);
            case Careful c -> action(c);
            case Tactician t -> action(t);
            default -> { throw new IllegalArgumentException("invalid player type"); }
        }
    }
    abstract void action(Greedy g);
    abstract void action(Careful c);
    abstract void action(Tactician t);
}