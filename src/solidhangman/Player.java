package solidhangman;

public class Player {
    private Statistics statistics;
    private String name;

    public Player(String _name) {
        name = _name;
        statistics = new Statistics();
    }

    public void showMyStats() {
        System.out.println(getName() + "'s statistics:");
        System.out.println("Matches won: " + statistics.getMatchesWon());
        System.out.println("Matches lost: " + statistics.getMatchesLost());
    }
    
    public String getName(){
        return name;
    }
    
    public Statistics getStatistics(){
        return statistics;
    }
}
