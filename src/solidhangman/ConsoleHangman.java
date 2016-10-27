package solidhangman;

import solidhangman.game.composers.ConsoleWordComposer;
import solidhangman.game.wordbuilders.ConsoleWordBuilder;
import solidhangman.game.managers.ConsoleGameManager;

public class ConsoleHangman extends Hangman {

    public ConsoleHangman() {
        super(new ConsoleGameManager(), new ConsoleWordComposer(), new ConsoleWordBuilder());
    }
    
}
