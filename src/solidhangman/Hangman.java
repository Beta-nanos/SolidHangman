package solidhangman;

import solidhangman.game.matches.ConsoleMatch;
import solidhangman.game.matches.Match;
import java.io.IOException;
import solidhangman.game.composers.WordComposer;
import solidhangman.game.wordbuilders.WordBuilder;
import solidhangman.game.managers.GameManager;
import java.util.ArrayList;
import java.util.List;
import solidhangman.game.exceptions.IncorrectPlayerSizeException;
import solidhangman.game.exceptions.NoWordsInFileException;
import solidhangman.game.exceptions.WrongInputException;
import solidhangman.game.exceptions.WrongLetterException;

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

    public void init() throws IncorrectPlayerSizeException, IOException {
        players = new ArrayList<>();
        try {
            gameManager.initPlayers(players);
        } catch (WrongInputException ex) {
            System.out.println(ex.getMessage());
            init();
        }
        try{
            wordComposer.setActivePlayers(players.size());
        } catch (NoWordsInFileException ex){
            System.out.println(ex.getMessage());
            init();
        }
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
        Match match = new ConsoleMatch();
        match.setWord(wordComposer.getWord());
        match.setPlayer(currentPlayer);
        currentPlayer = gameManager.nextPlayerToPlay(currentPlayer);
        do {
            char letter = obtainLetter();
            match.inputValidation(letter);
            match.showStatus();
        } while (!match.hasFinished());
    }

    private char obtainLetter() {
        char letter;
        try {
            letter =wordBuilder.getLetter();
        } catch (WrongLetterException ex) {
            System.out.println(ex.getMessage());
            letter = obtainLetter();
        }
        return letter;
    }
}
