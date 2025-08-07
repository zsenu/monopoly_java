package beadando2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//import console.Console;
public class Beadando2
{
    public static void main(String[] args)
    {
        try 
        {
            File inputFile = new File("input.txt");
            Scanner reader = new Scanner(inputFile);
            
            Game g = new Game();
            // System.out.print("field count = ");
            // int fieldCount = Integer.parseInt(Console.readLine());
            int fieldCount = Integer.parseInt(reader.nextLine());
            for (int i = 0; i < fieldCount; i++)
            {
                // System.out.print("data for field #" + (i + 1) + ": ");
                //String[] input = Console.readLine().split(" ");
                String[] input = reader.nextLine().split(" ");
                switch (input[0])
                {
                    case "property" -> g.addField(new Property(i + 1));
                    case "service"  -> g.addField(new Service(i + 1, Integer.parseInt(input[1])));
                    case "fortune"  -> g.addField(new Fortune(i + 1, Integer.parseInt(input[1])));
                    default -> throw new IllegalArgumentException("invalid field type");
                }
            }
            // System.out.print("player count = ");
            // int playerCount = Integer.parseInt(Console.readLine());
            int playerCount = Integer.parseInt(reader.nextLine());
            for (int i = 0; i < playerCount; i++)
            {
                // System.out.print("data for player #" + (i + 1) + ": ");
                // String[] input = Console.readLine().split(" ");
                String[] input = reader.nextLine().split(" ");
                switch (input[1])
                {
                    case "greedy"    -> g.addPlayer(new Greedy(input[0]));
                    case "careful"   -> g.addPlayer(new Careful(input[0]));
                    case "tactician" -> g.addPlayer(new Tactician(input[0]));
                    default -> throw new IllegalArgumentException("invalid player type: \"" + input[1] + "\"");
                }
            }
            // System.out.print("number of rounds to simulate = ");
            // int n = Integer.parseInt(Console.readLine());
            int n = Integer.parseInt(reader.nextLine());
            for (int i = 0; i < n; i++) { g.playTurn(reader); }
            reader.close();
            
            System.out.println("\nplayer standings after " + n + " rounds:");
            g.gameState();
        }
        catch (FileNotFoundException e)
        { System.out.println("error: input.txt not found"); }
    }
}