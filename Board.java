import java.util.ArrayList;

public class Board {

    // populate the board
    public static ArrayList<Square> makeBoard() {
        ArrayList<Square> board = new ArrayList<Square>();
        board.add(new Go());
        board.add(new RealEstate("Mediterranean Avenue", 60, "Brown", 50, new int[] { 2, 10, 30, 90, 160, 250 }));
        board.add(new CommunityChest());
        board.add(new RealEstate("Baltic Avenue", 60, "Brown", 50, new int[] { 4, 20, 60, 180, 320, 450 }));
        board.add(new IncomeTax());
        board.add(new Railroad("Reading Railroad"));
        board.add(new RealEstate("Oriental Avenue", 100, "Light Blue", 50, new int[] { 6, 30, 90, 270, 400, 550 }));
        board.add(new Chance());
        board.add(new RealEstate("Vermont Avenue", 100, "Light Blue", 50, new int[] { 6, 30, 90, 270, 400, 550 }));
        board.add(new RealEstate("Connecticut Avenue", 120, "Light Blue", 50, new int[] { 8, 40, 100, 300, 450, 600 }));
        board.add(new Jail());
        board.add(new RealEstate("St. Charles Place", 140, "Pink", 100, new int[] { 10, 50, 150, 450, 625, 750 }));
        board.add(new Utility("Electric Company"));
        board.add(new RealEstate("States Avenue", 140, "Pink", 100, new int[] { 10, 50, 150, 450, 625, 750 }));
        board.add(new RealEstate("Virginia Avenue", 160, "Pink", 100, new int[] { 12, 60, 180, 500, 700, 900 }));
        board.add(new Railroad("Pennsylvania Railroad"));
        board.add(new RealEstate("St. James Place", 180, "Orange", 100, new int[] { 14, 70, 200, 550, 750, 950 }));
        board.add(new CommunityChest());
        board.add(new RealEstate("Tennessee Avenue", 180, "Orange", 100, new int[] { 14, 70, 200, 550, 750, 950 }));
        board.add(new RealEstate("New York Avenue", 200, "Orange", 100, new int[] { 16, 80, 220, 600, 800, 1000 }));
        board.add(new FreeParking());
        board.add(new RealEstate("Kentucky Avenue", 220, "Red", 150, new int[] { 18, 90, 250, 700, 875, 1050 }));
        board.add(new Chance());
        board.add(new RealEstate("Indiana Avenue", 220, "Red", 150, new int[] { 18, 90, 250, 700, 875, 1050 }));
        board.add(new RealEstate("Illinois Avenue", 240, "Red", 150, new int[] { 20, 100, 300, 750, 925, 1100 }));
        board.add(new Railroad("B. & O. Railroad"));
        board.add(new RealEstate("Atlantic Avenue", 260, "Yellow", 150, new int[] { 22, 110, 330, 800, 975, 1150 }));
        board.add(new RealEstate("Ventnor Avenue", 260, "Yellow", 150, new int[] { 22, 110, 330, 800, 975, 1150 }));
        board.add(new Utility("Water Works"));
        board.add(new RealEstate("Marvin Gardens", 280, "Yellow", 150, new int[] { 24, 120, 360, 850, 1025, 1200 }));
        board.add(new GoToJail());
        board.add(new RealEstate("Pacific Avenue", 300, "Green", 200, new int[] { 26, 130, 390, 900, 1100, 1275 }));
        board.add(new RealEstate("North Carolina Avenue", 300, "Green", 200,
                new int[] { 26, 130, 390, 900, 1100, 1275 }));
        board.add(new CommunityChest());
        board.add(
                new RealEstate("Pennsylvania Avenue", 320, "Green", 200, new int[] { 28, 150, 450, 1000, 1200, 1400 }));
        board.add(new Railroad("Short Line"));
        board.add(new Chance());
        board.add(new RealEstate("Park Place", 350, "Dark Blue", 200, new int[] { 35, 175, 500, 1100, 1300, 1500 }));
        board.add(new LuxuryTax());
        board.add(new RealEstate("Boardwalk", 400, "Dark Blue", 200, new int[] { 50, 200, 600, 1400, 1700, 2000 }));

        return board;
    }
}