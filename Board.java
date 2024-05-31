import java.util.ArrayList;

public class Board {

    // populate the board
    public static ArrayList<Square> makeBoard() {
        ArrayList<Square> board = new ArrayList<Square>();
        board.add(new Go());
        board.add(new RealEstate("Mediterranean Avenue", 60, "Brown"));
        board.add(new CommunityChest());
        board.add(new RealEstate("Baltic Avenue", 60, "Brown"));
        board.add(new FreeParking());
        board.add(new Railroad("Reading Railroad"));
        board.add(new RealEstate("Oriental Avenue", 100, "Light Blue"));
        board.add(new Chance());
        board.add(new RealEstate("Vermont Avenue", 100, "Light Blue"));
        board.add(new RealEstate("Connecticut Avenue", 120, "Light Blue"));
        board.add(new Jail());
        board.add(new RealEstate("St. Charles Place", 140, "Pink"));
        board.add(new Utility("Electric Company"));
        board.add(new RealEstate("States Avenue", 140, "Pink"));
        board.add(new RealEstate("Virginia Avenue", 160, "Pink"));
        board.add(new Railroad("Pennsylvania Railroad"));
        board.add(new RealEstate("St. James Place", 180, "Orange"));
        board.add(new CommunityChest());
        board.add(new RealEstate("Tennessee Avenue", 180, "Orange"));
        board.add(new RealEstate("New York Avenue", 200, "Orange"));
        board.add(new FreeParking());
        board.add(new RealEstate("Kentucky Avenue", 220, "Red"));
        board.add(new Chance());
        board.add(new RealEstate("Indiana Avenue", 220, "Red"));
        board.add(new RealEstate("Illinois Avenue", 240, "Red"));
        board.add(new Railroad("B. & O. Railroad"));
        board.add(new RealEstate("Atlantic Avenue", 260, "Yellow"));
        board.add(new RealEstate("Ventnor Avenue", 260, "Yellow"));
        board.add(new Utility("Water Works"));
        board.add(new RealEstate("Marvin Gardens", 280, "Yellow"));
        board.add(new GoToJail());
        board.add(new RealEstate("Pacific Avenue", 300, "Green"));
        board.add(new RealEstate("North Carolina Avenue", 300, "Green"));
        board.add(new CommunityChest());
        board.add(new RealEstate("Pennsylvania Avenue", 320, "Green"));
        board.add(new Railroad("Short Line"));
        board.add(new Chance());
        board.add(new RealEstate("Park Place", 350, "Dark Blue"));
        board.add(new FreeParking());
        board.add(new RealEstate("Boardwalk", 400, "Dark Blue"));
        
        return board;
    }
}