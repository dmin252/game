import java.util.ArrayList;

public class Board {

    // populate the board
    public static ArrayList<Square> makeBoard() {
        ArrayList<Square> board = new ArrayList<Square>();
        board.add(new Go());
        board.add(new Property("Mediterranean Avenue", 60));
        board.add(new CommunityChest());
        board.add(new Property("Baltic Avenue", 60));
        board.add(new FreeParking());
        board.add(new Railroad("Reading Railroad"));
        board.add(new Property("Oriental Avenue", 100));
        board.add(new Chance());
        board.add(new Property("Vermont Avenue", 100));
        board.add(new Property("Connecticut Avenue", 120));
        board.add(new FreeParking());
        board.add(new Property("St. Charles Place", 140));
        board.add(new Utility("Electric Company"));
        board.add(new Property("States Avenue", 140));
        board.add(new Property("Virginia Avenue", 160));
        board.add(new Railroad("Pennsylvania Railroad"));
        board.add(new Property("St. James Place", 180));
        board.add(new CommunityChest());
        board.add(new Property("Tennessee Avenue", 180));
        board.add(new Property("New York Avenue", 200));
        board.add(new FreeParking());
        board.add(new Property("Kentucky Avenue", 220));
        board.add(new Chance());
        board.add(new Property("Indiana Avenue", 220));
        board.add(new Property("Illinois Avenue", 240));
        board.add(new Railroad("B. & O. Railroad"));
        board.add(new Property("Atlantic Avenue", 260));
        board.add(new Property("Ventnor Avenue", 260));
        board.add(new Utility("Water Works"));
        board.add(new Property("Marvin Gardens", 280));
        board.add(new FreeParking());
        board.add(new Property("Pacific Avenue", 300));
        board.add(new Property("North Carolina Avenue", 300));
        board.add(new CommunityChest());
        board.add(new Property("Pennsylvania Avenue", 320));
        board.add(new Railroad("Short Line"));
        board.add(new Chance());
        board.add(new Property("Park Place", 350));
        board.add(new FreeParking());
        board.add(new Property("Boardwalk", 400));
        
        return board;
    }
}