import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    static final int STARTING_MONEY = 100;
    static ArrayList<Player> players = new ArrayList<Player>();
    static ArrayList<Square> boardSquares = Board.makeBoard();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numTurns = 0;
        addPlayers();
        while (players.size() > 1) {
            for (Player player : new ArrayList<>(players)) {
                if (players.size() <= 1)
                    break;
                takeTurn(player);
                printGameStatus(numTurns, player);
                numTurns++;
            }
        }
        System.out.println(players.get(0).getName() + " wins!");
    }

    public static void printGameStatus(int numTurns, Player currentPlayer) {
        System.out.println("Turn " + numTurns + " (Current Player: " + currentPlayer.getName() + ")");
        for (Player player : players) {
            System.out.println(player.getName() + " is at " + boardSquares.get(player.getPosition()).getName()
                    + " with $" + player.getMoney());
            System.out.println("Properties owned: " + player.getPropertiesNames());
        }
    }

    public static void movePlayer(Player player, int roll) {
        int newPosition = (player.getPosition() + roll) % boardSquares.size();
        player.setPosition(newPosition);
        if (player.getPosition() + roll >= boardSquares.size()) {
            player.setMoney(player.getMoney() + 200);
            System.out.println(player.getName() + " passed Go and collected $200");
        }
        System.out.println(player.getName() + " moved to " + boardSquares.get(newPosition).getName());
        handleSquare(player, boardSquares.get(newPosition));
    }

    public static void handleSquare(Player player, Square square) {
        if (square instanceof Property) {
            handleProperty(player, (Property) square);
        } else if (square instanceof FreeParking) {
            // Handle Free Parking
            System.out.println(player.getName() + " landed on Free Parking.");
        } else if (square instanceof Chance) {
            System.out.println(player.getName() + " landed on Chance.");
        } else if (square instanceof CommunityChest) {
            System.out.println(player.getName() + " landed on Community Chest.");
        }
    }

    public static void handleProperty(Player player, Property property) {
        if (property.getOwner() == null) {
            if (player instanceof AI) {
                if (player.getMoney() >= property.getpurchasePrice() && ((AI) player).getBuyDecision()) {
                    buyProperty(player, property);
                }
            } else {
                if (player.getMoney() >= property.getpurchasePrice()) {
                    System.out.println("You have $" + player.getMoney() + ". Would you like to buy "
                            + property.getName() + " for $" + property.getpurchasePrice()
                            + "? (y/n)");
                    String input = scanner.nextLine();
                    if (input.equals("y")) {
                        buyProperty(player, property);
                    }
                } else {
                    System.out.println(player.getName() + " does not have enough money to buy " + property.getName());
                }
            }
        } else if (property.getOwner() != player) {
            payRent(player, property);
        } else {
            System.out.println(player.getName() + " already owns " + property.getName());
        }
    }

    public static void buyProperty(Player player, Property property) {
        player.setMoney(player.getMoney() - property.getpurchasePrice());
        player.addProperty(property);
        property.setOwner(player);
        System.out.println(player.getName() + " bought " + property.getName() + " for $" + property.getpurchasePrice());
    }

    public static void payRent(Player player, Property property) {
        Player owner = property.getOwner();
        int rent = property.getCost();
        if (player.getMoney() < rent) {
            owner.setMoney(owner.getMoney() + player.getMoney());
            player.setMoney(0);
            System.out.println(player.getName() + " is bankrupt and out of the game!");
            players.remove(player);
            for (Property propertyToRemove : player.getProperties()) {
                propertyToRemove.setOwner(null);
            }
        } else {
            player.setMoney(player.getMoney() - rent);
            owner.setMoney(owner.getMoney() + rent);
            System.out.println(player.getName() + " paid $" + rent + " rent to " + owner.getName());
        }
    }

    public static void takeTurn(Player player) {
        System.out.println(player.getName() + "'s turn:");
        int roll = Dice.roll();
        movePlayer(player, roll);
    }

    public static void addPlayers() {
        players.add(new AI("Player 1", STARTING_MONEY));
        players.add(new AI("Player 2", STARTING_MONEY));
        players.add(new Human("HumanPlayer", STARTING_MONEY));
    }
}