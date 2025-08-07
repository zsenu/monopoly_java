package beadando2;
/**
 * A taktikus játékos.
 * @author fiokn
 */
public class Tactician extends Player
{
    /**
     * Az adott körben vásárlási szándákát tároló logikai érték.
     */
    private boolean buy = false;
     
    public Tactician(String s) { super(s); }
    /**
     * basic getter
     * @return Megváltoztatja a játékos vásárlási szándékát, majd visszaadja azt.
     */
    public boolean choice()
    {
        buy = !buy;
        return buy;
    }
}