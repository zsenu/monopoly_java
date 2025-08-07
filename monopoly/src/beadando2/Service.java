package beadando2;
/**
 * A szolgáltatás mező.
 * @author fiokn
 */
public class Service extends Field
{
    /**
     * A mezőre lépő játékos bűntetése.
     */
    private final int cost;
    
    public Service(int p, int c)       { super(p); cost = c;     }
        
    @Override
    protected void action(Greedy g)    { g.changeBalance(-cost); }
    @Override
    protected void action(Careful c)   { c.changeBalance(-cost); }
    @Override
    protected void action(Tactician t) { t.changeBalance(-cost); }
}