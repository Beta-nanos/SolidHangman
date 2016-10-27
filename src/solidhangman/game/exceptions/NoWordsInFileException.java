package solidhangman.game.exceptions;

public class NoWordsInFileException extends Exception {
    public NoWordsInFileException(){
        super("No words are contained in the words file.");
    }
}
