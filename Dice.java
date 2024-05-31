public class Dice {
    static int roll1;
    static int roll2;

    public static int roll() {
        roll1 = (int) (Math.random() * 6 + 1);
        roll2 = (int) (Math.random() * 6 + 1);
        //roll1 = 1;
        //roll2 = 1;
        
        System.out.println("Rolled a " + roll1 + " and " + roll2);
        return roll1 + roll2;
    }

    public static boolean isDouble() {
        return roll1 == roll2;
    }

}