package solidhangman;

import java.util.ArrayList;
import java.util.List;

public class Hangman {

    private List<Player> players;
    private GameManager gameManager;
    private WordComposer wordComposer;
    private WordBuilder wordBuilder;

    public Hangman(GameManager gameManager, WordComposer wordComposer, WordBuilder wordBuilder) {
        this.gameManager = gameManager;
        this.wordComposer = wordComposer;
        this.wordBuilder = wordBuilder;
    }

    public void init() {
        players = new ArrayList<>();
        gameManager.initPlayers(players);
        wordComposer.setActivePlayers(players.size());
    }

    public boolean play() {

        OPTION chosenOption;
        do {
            gameManager.showGameMenu();
            chosenOption = gameManager.getChoiceAnswer();

            choiceValidation(chosenOption);
        } while (chosenOption != OPTION.EXIT);
        return false;
    }

    private void choiceValidation(OPTION option) {
        switch (option) {
            case PLAY:
                executeMatch();
                break;
            case SHOW_STATS:
                gameManager.showStats();
                break;
        }
    }

    private void executeMatch() {
        Match match = new Match();
        match.setWord(wordComposer.getWord());
        match.setPlayer(gameManager.nextPlayerToPlay());
        do {
            match.inputValidation(wordBuilder.getLetter());
        } while (!match.hasFinished());
    }

}
