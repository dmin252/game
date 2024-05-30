import java.util.ArrayList;

public class Jail extends Square {
    private ArrayList<Player> players;
    private ArrayList<Integer> turns;

    public Jail(String name) {
        super(name);
        players = new ArrayList<Player>();
        turns = new ArrayList<Integer>();
    }

    public void addPlayer(Player p) {
        players.add(p);
        turns.add(3);
    }

    public void removePlayer(Player p) {
        System.out.println(p.getName() + " is out of jail");
        turns.remove(players.indexOf(p));
        players.remove(p);
    }

    public void addTurns(Player p) {
        turns.set(players.indexOf(p), turns.get(players.indexOf(p)) - 1);
        if (turns.get(players.indexOf(p)) == 0) {
            turns.remove(players.indexOf(p));
            players.remove(p);
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Integer> getTurns() {
        return turns;
    }

}
