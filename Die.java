public class Die {

    public static int roll() {
        int roll1 = (int) (Math.random() * 6 + 1);
        int roll2 = (int) (Math.random() * 6 + 1);

        System.out.println("Rolled a " + roll1 + " and " + roll2);
        return roll1 + roll2;
    }

}