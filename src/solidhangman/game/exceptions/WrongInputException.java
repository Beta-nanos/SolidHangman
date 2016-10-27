
package solidhangman.game.exceptions;

public class WrongInputException extends Exception {

    public WrongInputException(char option) {
        super("Wrong input: "+option+". Expected a number from the choices.");
    }
}
