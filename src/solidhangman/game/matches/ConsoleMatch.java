package solidhangman.game.matches;

import solidhangman.game.players.Player;
import solidhangman.game.composers.Word;

public class ConsoleMatch implements Match {
    private Player player;
    private Word word;
    private int lives;
    private String wordTextDuplicate;
    private String userWord; 
    
    public ConsoleMatch() {
        lives = 6;
    }
    
    @Override
    public void setWord(Word word) {
        this.word = word;
        this.wordTextDuplicate = word.getWordText();
        int wordLength = word.getWordLength();
        StringBuilder sb = new StringBuilder(wordLength);
        
        for(int i = 0; i < wordLength; i++)
            sb.append("_");
        
        userWord = sb.toString();
    }

    @Override
    public void setPlayer(Player currentPlayer) {
        player = currentPlayer;
    }

    @Override
    public void inputValidation(char letter) {
        if(word.getWordText().contains(String.valueOf(letter))){
            updateUserWord(letter);
        }else{
            lives--;
        }
    }

    @Override
    public boolean hasFinished() {
        if(lives == 0){
            player.getStatistics().incrementMatchesLost();
            System.out.println("Out of luck! You've lost this match! The word was: " + word.getWordText());
            return true;
        }
        if(userWord.equals(word.getWordText())){
            player.getStatistics().incrementMatchesWon();
            System.out.println("You won this match! The word was: " + word.getWordText());
            return true;
        }
        return false;
    }

    private void updateUserWord(char letter) {
        char[] newerWord = userWord.toCharArray();
        
        for(int i = 0; i < wordTextDuplicate.length(); i++){
            char currentChar = wordTextDuplicate.charAt(i);
            if(currentChar == letter)
                newerWord[i] = letter;                
        }
        userWord = String.valueOf(newerWord);
    }

    @Override
    public void showStatus() {
        System.out.printf("Lives: %d %n", lives);
        for(int i = 0; i < userWord.length(); i++){
            System.out.print(userWord.charAt(i));
            System.out.print(" ");
        }
        System.out.println("");
    }
}
