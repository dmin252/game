public class AI extends Player{
    
    public AI(String name, int money) {
        super(name, money);
    }

    public boolean getBuyDecision() {
        double x = Math.random();
        return x > 0.5;
    }
}
