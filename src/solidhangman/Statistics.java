package solidhangman;

public class Statistics {
    private int MatchesWon;
    private int MatchesLost;
    
    public Statistics(){
        MatchesWon = 0;
        MatchesLost = 0;
    }
    
    public void incrementMatchesWon(){
        MatchesWon++;
    }
    
    public void incrementMatchesLost(){
        MatchesLost++;
    }
    
    public int getMatchesWon(){
        return MatchesWon;
    }
    
    public int getMatchesLost(){
        return MatchesLost;
    }
}
