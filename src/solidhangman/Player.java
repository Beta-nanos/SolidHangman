package solidhangman;

public class Player {
    private Statistics statistics;
    private String name;

    public Player(String name) {
        this.name = name;
        statistics = new Statistics();
    }

    public void showMyStats() {
        System.out.println(getName() + "'s statistics:");
        System.out.println("Matches won: " + statistics.getMatchesWon());
        System.out.println("Matches lost: " + statistics.getMatchesLost());
    }
    
    public String getName(){
        return this.name;
    }
    
    public Statistics getStatistics(){
        return statistics;
    }
}
