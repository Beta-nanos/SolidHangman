package solidhangman;

public class Player {
    private Statistics statistics;
    private String name;

    public Player(String _name) {
        name = _name;
        statistics = new Statistics();
    }

    public void showMyStats() {
        System.out.print(getName() + "'s statistics:");
        System.out.print("Matches won: " + statistics.getMatchesWon());
        System.out.print("Matches lost: " + statistics.getMatchesLost());
    }
    
    public String getName(){
        return name;
    }
    
    public Statistics getStatistics(){
        return statistics;
    }
}
