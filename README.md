# Capitaly Board Game Simulation (Java)

A simplified simulation of the **Capitaly** board game, implemented in Java using Apache NetBeans.

## Game Logic

- Multiple players with different strategies (Greedy, Careful, Tactical) compete on a circular board.
- The board contains three types of fields:
  - **Properties**: Can be bought for 1000 currency units, and upgraded with houses for 4000.
  - **Services**: Require payment to the bank when landed on.
  - **Luck**: Provide bonus money to the player.
- Players roll a die and move accordingly. If they land on a property owned by another player, they pay rent:
  - 500 without house
  - 2000 with house
- If a player can’t pay, they are eliminated from the game.
- Game configuration (board layout, field types, players, strategies, and dice rolls) is read from a **text file**.

## Player Strategies

- **Greedy**: Buys all available properties and upgrades if affordable.
- **Careful**: Only spends up to half of their current balance.
- **Tactical**: Skips every second buying opportunity.

## Output

After a given number of rounds, the program prints:
- Each player's balance
- Owned properties

## Technologies Used

- **Java**
- Developed in **Apache NetBeans**

## Documentation

The repository includes:
- A Hungarian-language documentation file
- Class diagrams
- Manual test cases

## Running the Project

1. Open the project in **Apache NetBeans**.
2. Build and run the project.
3. Interact with the puzzle through the provided interface.
