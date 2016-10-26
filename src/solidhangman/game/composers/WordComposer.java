package solidhangman.game.composers;

import java.io.FileNotFoundException;
import java.io.IOException;
import solidhangman.game.exceptions.NoWordsInFileException;
import solidhangman.game.exceptions.IncorrectPlayerSizeException;

public interface WordComposer {

    public void setActivePlayers(int amountOfPlayers) throws IncorrectPlayerSizeException, NoWordsInFileException, FileNotFoundException, IOException, NoWordsInFileException;
    public Word getWord();
}
