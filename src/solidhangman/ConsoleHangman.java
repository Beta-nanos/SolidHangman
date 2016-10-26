package solidhangman;

import solidhangman.game.managers.ConsoleGameManager;

public class ConsoleHangman extends Hangman {

    public ConsoleHangman() {
        super(new ConsoleGameManager(), new ConsoleWordComposer(), ConsoleWordBuilder());
    }
    
}
