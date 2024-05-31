public class MoveToSquareCard extends Card {
    private int squareIndex;

    public MoveToSquareCard(String description, int squareIndex) {
        super(description);
        this.squareIndex = squareIndex;
    }

    @Override
    public void applyEffect(Player player) {
        player.setPosition(squareIndex);
        System.out.println(player.getName() + " moves to " + Game.boardSquares.get(squareIndex).getName());
        Game.handleSquare(player, Game.boardSquares.get(squareIndex));
    }
}