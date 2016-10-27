package solidhangman.game.matches;

import solidhangman.Player;
import solidhangman.game.composers.Word;

public class Match {
    private Player player;
    private Word word;
    private int lives;
    private String wordTextDuplicate;
    private String userWord; 
            
    public Match(){
        lives = 6;
    }

    public void setWord(Word word) {
        this.word = word;
        this.wordTextDuplicate = word.getWordText();
        int wordLength = word.getWordLength();
        StringBuilder sb = new StringBuilder(wordLength);
        
        for(int i = 0; i < wordLength; i++)
            sb.append("_");
        
        userWord = sb.toString();
    }

    public void setPlayer(Player currentPlayer) {
        player = currentPlayer;
    }

    public void inputValidation(char letter) {
        if(word.getWordText().contains(String.valueOf(letter))){
            updateUserWord(letter);
        }else{
            lives--;
        }
    }

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

    public void showStatus() {
        System.out.printf("Lives: %d %n", lives);
        for(int i = 0; i < userWord.length(); i++){
            System.out.print(userWord.charAt(i));
            System.out.print(" ");
        }
        System.out.println("");
    }
}
