
package solidhangman.game.wordbuilders;

import solidhangman.game.exceptions.WrongLetterException;
import java.util.Scanner;
import solidhangman.game.wordbuilders.WordBuilder;

public class ConsoleWordBuilder implements WordBuilder{

    Scanner scan = new Scanner(System.in);
    public ConsoleWordBuilder() {
    }

    @Override
    public char getLetter() throws WrongLetterException{
        System.out.print("Introduce a letter: ");
        char option = scan.next().toUpperCase().charAt(0);
        int ascii = option;
        if(ascii > 90 || ascii <65)
            throw new WrongLetterException(option);
        return option;
    }
    
}
