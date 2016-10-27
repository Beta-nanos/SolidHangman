package solidhangman.game.exceptions;

public class IncorrectPlayerSizeException extends Exception {

    public IncorrectPlayerSizeException(int size) {
        super("Received " + size + ". Expected players to be 1 or 2.");
    }
    
}
