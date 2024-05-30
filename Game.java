import java.util.ArrayList;

public class Game {
    static Die dice = new Die();
    static Board board = new Board();
    static final int STARTING_MONEY = 100;
    static ArrayList<Player> players = new ArrayList<Player>();
    static ArrayList<Square> boardSquares = Board.makeBoard();

    public static void main(String[] args) {
        addPlayers();
        while (players.size() > 1) {
            for (Player player : new ArrayList<>(players)) {
                if (players.size() <= 1) break;
                takeTurn(player);
            }
        }
        System.out.println(players.get(0).getName() + " wins!");
    }
    public static void movePlayer(Player player, int roll) {
        int newPosition = (player.getPosition() + roll) % boardSquares.size();
        player.setPosition(newPosition);
        System.out.println(player.getName() + " moved to " + boardSquares.get(newPosition).getName());
        handleSquare(player, boardSquares.get(newPosition));
    }
    
    public static void handleSquare(Player player, Square square) {
        if (square instanceof Property) {
            handleProperty(player, (Property) square);
        } else if (square instanceof Go) {
            // Handle landing on Go
            player.setMoney(player.getMoney() + 200);
            System.out.println(player.getName() + " landed on Go and collected $200.");
        } else if (square instanceof FreeParking) {
            // Handle Free Parking
            System.out.println(player.getName() + " landed on Free Parking.");
        } else if (square instanceof Chance) {
            // Handle Chance
            System.out.println(player.getName() + " landed on Chance.");
        } else if (square instanceof CommunityChest) {
            // Handle Community Chest
            System.out.println(player.getName() + " landed on Community Chest.");
        }
    }
    
    public static void handleProperty(Player player, Property property) {
        if (property.getOwner() == null) {
            if (player instanceof AI) {
                if (((AI) player).getBuyDecision() && player.getMoney() >= property.getpurchasePrice()) {
                    buyProperty(player, property);
                }
            } else {
                // Prompt human player to buy
            }
        } else if (property.getOwner() != player) {
            payRent(player, property);
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
        player.setMoney(player.getMoney() - rent);
        owner.setMoney(owner.getMoney() + rent);
        System.out.println(player.getName() + " paid $" + rent + " rent to " + owner.getName());
        checkBankruptcy(player);
    }
    
    public static void checkBankruptcy(Player player) {
        if (player.getMoney() < 0) {
            System.out.println(player.getName() + " is bankrupt and out of the game!");
            players.remove(player);
            for (Property property : player.getProperties()) {
                property.setOwner(null);
            }
        }
    }

    public static void takeTurn(Player player) {
        System.out.println(player.getName() + "'s turn:");
        int roll = Die.roll();
        movePlayer(player, roll);
    }
    
    

    public static void addPlayers() {
        players.add(new AI("Player 1", STARTING_MONEY));
        players.add(new AI("Player 2", STARTING_MONEY));
    }
}