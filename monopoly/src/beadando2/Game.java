package beadando2;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * A társasjáték létfontosságú adatait és metódusait foglalja magába.
 * @author fiokn
 */
public class Game
{
    /**
     * A dobáshoz szükséges random számgenerátor.
     */
    private final Random            dice    = new Random();
    /**
     * A pálya mezőit tartalmazó lista.
     */
    private final ArrayList<Field>  fields  = new ArrayList<>();
    /**
     * A játékosokat tartalmazó lista.
     */
    private final ArrayList<Player> players = new ArrayList<>();
    /**
     * f mezőt a pályához adja.
     * @param f 
     */
    public void addField(Field f)   { fields.add(f);  }
    /**
     * p játékost a játékosok listájához adja.
     * @param p 
     */
    public void addPlayer(Player p) { players.add(p); }
    /**
     * p játékost roll mennyiséggel mozgatja el a pályán, számolva a túllépésekkel.
     * @param p
     * @param roll 
     */
    private void movePlayer(Player p, int roll)
    {
        int target = p.getLocation() + roll;
        while (target >= fields.size()) { target -= fields.size(); }
        p.move(target);
    }
    /**
     * Szimulál egy teljes kört, azaz minden játékban lévő játékos dob, majd lép és taktikája szerint játszik.
     * Az előre megadott dobásokat a reader olvasóból nyeri ki, feltéve, hogy azok léteznek.
     * @param reader 
     */
    public void playTurn(Scanner reader)
    {
        int roll;
        for (Player p : players)
        {
            if (reader.hasNextLine()) { roll = Integer.parseInt(reader.nextLine()); }
            else                      { roll = dice.nextInt(6) + 1; }
            if (p.isInGame())
            {
                movePlayer(p, roll);
                fields.get(p.getLocation()).action(p);
            }
        }
    }
    /**
     * A feladat megoldásához szükséges kiíró metódus, mely a játékosok adatait és telkeit felsorolja.
     */
    public void gameState()
    {
        for (Player p : players)
        {
            System.out.println("-------------------------");
            System.out.println("name:\t\t" + p.getName());
            if (!p.isInGame()) { System.out.println("in game:\tno"); }
            else
            {
                System.out.println("in game:\tyes");
                System.out.println("balance:\t" + p.getBalance());
                System.out.println("owned properties:");
                for (Property prop : p.getProperties())
                { System.out.println(prop); }
                if (p.getProperties().isEmpty()) { System.out.println("\nnone"); }
            }
        }
    }
}