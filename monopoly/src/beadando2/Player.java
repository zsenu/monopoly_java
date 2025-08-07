package beadando2;
import java.util.ArrayList;
/**
 * A játékosok általános adatait, cselekvéseit tároló osztály.
 * @author fiokn
 */
public abstract class Player
{
    /**
     * A játékos neve.
     */
    private final String               name;
    /**
     * A játékos egyenlege.
     */
    private int                        balance  = 10000;
    /**
     * A játékos pozíciója a játéktáblán.
     */
    private int                        location = -1;
    /**
     * Játékban van-e még a játékos?
     */ 
    private boolean                    inGame   = true;
    /**
     * A játékos által birtokolt telkek listája.
     */
    private final ArrayList<Property>  properties = new ArrayList<>();
    
    public Player(String n) { name = n; }
    /**
     * basic getter
     * @return A játékos nevét adja vissza (String típus).
     */
    public String              getName()       { return name;       }
    /**
     * basic getter
     * @return A játékos egyenlegét adja vissza (egész érték).
     */ 
    public int                 getBalance()    { return balance;    }
    /**
     * basic getter
     * @return A játékos táblán lévő pozícióját adja vissza.
     */
    public int                 getLocation()   { return location;   }
    /**
     * basic setter
     * @param where A megadott helyre mozgatja a játékost. 
     */
    public void                move(int where) { location = where;  }
    /**
     * basic getter
     * @return Megadja, hogy a játékos játékban van-e?
     */
    public boolean             isInGame()      { return inGame;     }
    /**
     * basic getter
     * @return A játékos telkeinek listáját adja vissza.
     */
    public ArrayList<Property> getProperties() { return properties; }
    /**
     * p telket a játékos által birtokolt listájéhoz adja hozzá.
     * @param p 
     */
    public void                buy(Property p) { properties.add(p); }              
    /**
     * amount mennyiséggel változtatja a játékos egyenlegét.
     * @param amount 
     */
    public void changeBalance(int amount)
    {
        balance += amount;
        if (balance < 0)
        {
            inGame = false;
            for (Property p : properties) { p.reset(); }
            properties.clear();
        }
    }
}