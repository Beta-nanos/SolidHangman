package solidhangman;

import solidhangman.game.managers.GameManager;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import solidhangman.game.exceptions.WrongInputException;

public class Hangman {

    private List<Player> players;
    private GameManager gameManager;
    private WordComposer wordComposer;
    private WordBuilder wordBuilder;
    private Player currentPlayer;

    public Hangman(GameManager gameManager, WordComposer wordComposer, WordBuilder wordBuilder) {
        this.gameManager = gameManager;
        this.wordComposer = wordComposer;
        this.wordBuilder = wordBuilder;
    }

    public void init() {
        players = new ArrayList<>();
        try {
            gameManager.initPlayers(players);
        } catch (WrongInputException ex) {
            System.out.println(ex.getMessage());
            init();
        }
        wordComposer.setActivePlayers(players.size());
        currentPlayer = players.get(0);
    }

    public void play() {
        try {
            showMenuOptions();
        } catch (WrongInputException ex) {
            System.out.println(ex.getMessage());
            play();
        }
    }

    private void showMenuOptions() throws WrongInputException {
        OPTION chosenOption;
        do {
            gameManager.showGameMenu();
            
            chosenOption = gameManager.getChoiceAnswer();
            choiceValidation(chosenOption);
            
        } while (chosenOption != OPTION.EXIT);
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
        match.setPlayer(currentPlayer);
        currentPlayer = gameManager.nextPlayerToPlay(currentPlayer);
        do {
            match.inputValidation(wordBuilder.getLetter());
        } while (!match.hasFinished());
    }

}
