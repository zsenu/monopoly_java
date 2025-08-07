package beadando2;
/**
 * A szerencse mező.
 * @author fiokn
 */
public class Fortune extends Field
{
    /**
     * A mezőre lépőnek járó jutalom.
     */
    private final int reward;
    
    public Fortune(int p, int r)       { super(p); reward = r;    }
        
    @Override
    protected void action(Greedy g)    { g.changeBalance(reward); }
    @Override
    protected void action(Careful c)   { c.changeBalance(reward); }
    @Override
    protected void action(Tactician t) { t.changeBalance(reward); }
}