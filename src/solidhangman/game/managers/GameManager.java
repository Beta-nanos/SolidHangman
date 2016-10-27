
package solidhangman.game.managers;

import solidhangman.game.exceptions.WrongInputException;
import java.util.List;
import solidhangman.OPTION;
import solidhangman.Player;

public interface GameManager {
    
    void showGameMenu();

    OPTION getChoiceAnswer() throws WrongInputException;

    void showStats();
    
    public Player nextPlayerToPlay(Player currentPlayer);

    void initPlayers(List<Player> players) throws WrongInputException;
    
}
