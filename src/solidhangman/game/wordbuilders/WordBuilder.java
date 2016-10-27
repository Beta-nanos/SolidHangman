
package solidhangman.game.wordbuilders;

import solidhangman.game.exceptions.WrongLetterException;

public interface WordBuilder {
    public char getLetter()throws WrongLetterException;
}
