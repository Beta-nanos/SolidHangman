
package solidhangman.game.managers;

public class WrongInputException extends Exception {

    WrongInputException(char option) {
        super("Wrong input: "+option+". Expected a number from the choices.");
    }
}
