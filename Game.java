import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    static final int STARTING_MONEY = 1500;
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
        if (player.isInJail() && !Dice.isDouble()) {
            player.setJailTurns(player.getJailTurns() - 1);
            System.out.println(player.getName() + " is in jail for " + player.getJailTurns() + " more turns.");
            if (player instanceof Human) {
                if (player.getJailTurns() == 0) {
                    player.setInJail(false);
                    System.out.println(player.getName() + " served the jail time and is out of jail.");
                    movePlayer(player, roll);
                } else {
                    if (player.getMoney() >= 50) {
                        System.out.println("Do you want to pay $50 to get out of jail? (y/n)");
                        String input = scanner.nextLine();
                        if (input.equals("y")) {
                            player.setMoney(player.getMoney() - 50);
                            player.setInJail(false);
                            player.setJailTurns(0);
                            System.out.println(player.getName() + " paid $50 and got out of jail.");
                            movePlayer(player, roll);
                        }
                    } else {
                        System.out.println(player.getName() + " does not have enough money to pay the $50 fine.");
                    }
                }
            } else {
                if (player.getJailTurns() == 0) {
                    player.setInJail(false);
                    System.out.println(player.getName() + " served the jail time and is out of jail.");
                    movePlayer(player, roll);
                }
            }
        } else {
            if (player.isInJail() && Dice.isDouble()) {
                player.setInJail(false);
                player.setJailTurns(0);
                System.out.println(player.getName() + " rolled a double and is out of jail.");
            }
            int oldPosition = player.getPosition();
            int newPosition = (oldPosition + roll) % boardSquares.size();
            player.setPosition(newPosition);
            if (oldPosition + roll >= boardSquares.size()) {
                player.setMoney(player.getMoney() + 200);
                System.out.println(player.getName() + " passed Go and collected $200");
            }
            System.out.println(player.getName() + " moved to " + boardSquares.get(newPosition).getName());
            handleSquare(player, boardSquares.get(newPosition));
        }
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
        } else if (square instanceof GoToJail) {
            player.setPosition(10);
            player.setInJail(true);
            player.setJailTurns(3);
            System.out.println(player.getName() + " landed on Go To Jail and is now in jail.");
        } else if (square instanceof LuxuryTax) {
            player.setMoney(player.getMoney() - 100);
            System.out.println(player.getName() + " landed on Luxury Tax and paid $100.");
            if (player.getMoney() < 0) {
                System.out.println(player.getName() + " is bankrupt and out of the game!");
                players.remove(player);
                for (Property propertyToRemove : player.getProperties()) {
                    propertyToRemove.setOwner(null);
                }
            } 
        } else if (square instanceof IncomeTax) {
            int totalWorth = player.getMoney();
            for (Property property : player.getProperties()) {
                totalWorth += property.getpurchasePrice();
                if (property instanceof RealEstate) {
                    totalWorth += ((RealEstate) property).getNumberHouses() * ((RealEstate)property).getHouseCost();
                }
            }
            if (totalWorth * 0.1 < 200) {
                player.setMoney(player.getMoney() - (int)(totalWorth * 0.1));
                System.out.println(player.getName() + " landed on Income Tax and paid 10% of their total worth.");
            } else {
                player.setMoney(player.getMoney() - 200);
                System.out.println(player.getName() + " landed on Income Tax and paid $200.");
            }
            if (player.getMoney() < 0) {
                System.out.println(player.getName() + " is bankrupt and out of the game!");
                players.remove(player);
                for (Property propertyToRemove : player.getProperties()) {
                    propertyToRemove.setOwner(null);
                }
            } 
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

        if (player instanceof Human) {
            System.out.println("Do you want to buy a house? (y/n)");
            String input = scanner.nextLine();
            if (input.equals("y")) {
                buildHouses(player);
            }
        } else if (player instanceof AI) {
            for (Property property : player.getProperties()) {
                if (property instanceof RealEstate) {
                    RealEstate realEstate = (RealEstate) property;
                    if (realEstate.getNumberHouses() < RealEstate.MAX_HOUSES
                            && ownsColorSet(player, realEstate.getColor())
                            && player.getMoney() >= realEstate.getHouseCost() && ((AI) player).getBuyDecision()) {
                        realEstate.incrementNumberHouses();
                        player.setMoney(player.getMoney() - realEstate.getHouseCost());
                        System.out.println(player.getName() + " built " + 1 + " house on " + realEstate.getName());
                        break;
                    }
                }
            }
        }
    }

    public static void addPlayers() {
        players.add(new AI("Player 1", STARTING_MONEY));
        players.add(new AI("Player 2", STARTING_MONEY));
        players.add(new Human("HumanPlayer", STARTING_MONEY));
    }

    public static boolean ownsColorSet(Player player, String color) {
        int totalProperties = 0;
        int ownedProperties = 0;

        for (Square square : boardSquares) {
            if (square instanceof RealEstate) {
                RealEstate realEstate = (RealEstate) square;
                if (realEstate.getColor().equals(color)) {
                    totalProperties++;
                    if (realEstate.getOwner() == player) {
                        ownedProperties++;
                    }
                }
            }
        }
        return totalProperties == ownedProperties;
    }

    public static void buildHouses(Player player) {
        System.out.println(player.getName() + " is building houses.");
        for (Square square : boardSquares) {
            if (square instanceof RealEstate) {
                RealEstate realEstate = (RealEstate) square;
                if (realEstate.getOwner() == player && ownsColorSet(player, realEstate.getColor()) && realEstate.getNumberHouses() < RealEstate.MAX_HOUSES) {
                    System.out.println("You have $" + player.getMoney() + ". How many houses do you want to build for " + realEstate.getName() + "("+ realEstate.getNumberHouses() + " Houses)? It costs $" + realEstate.getHouseCost() + " for one?");
                    int input = scanner.nextInt();
                    if (input >= 0 && input <= RealEstate.MAX_HOUSES - realEstate.getNumberHouses() && player.getMoney() >= realEstate.getHouseCost() * input) {
                        realEstate.setNumberHouses(realEstate.getNumberHouses() + input);
                        player.setMoney(player.getMoney() - realEstate.getHouseCost() * input);
                        System.out.println(player.getName() + " built " + input + " houses on " + realEstate.getName());
                    } else {
                        System.out.println("Invalid input.");
                    }
                }
            }
        }
    }

}