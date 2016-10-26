package solidhangman;

public class ConsoleHangman extends Hangman {

    public ConsoleHangman() {
        super(new ConsoleGameManager(), new ConsoleWordComposer(), ConsoleWordBuilder());
    }
    
}
