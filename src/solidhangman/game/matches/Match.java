package solidhangman.game.matches;

import solidhangman.Player;
import solidhangman.game.composers.Word;

public interface Match {    
    public void setWord(Word word);
    public void setPlayer(Player currentPlayer);
    public void inputValidation(char letter);
    public boolean hasFinished();
    public void showStatus();
}
