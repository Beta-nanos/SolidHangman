package solidhangman;

import solidhangman.game.composers.Word;

public class Match {
    private Player player;
    private Word word;
    private int lives;
    private String wordTextDuplicate;
    private String lines; 
            
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
        
        lines = sb.toString();
    }

    public void setPlayer(Player currentPlayer) {
        player = currentPlayer;
    }

    public void inputValidation(char letter) {
        if(word.getWordText().contains(String.valueOf(letter))){
            removeLetterFromWord(letter);
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
        if(lines.equals(word.getWordText())){
            player.getStatistics().incrementMatchesWon();
            System.out.println("You won this match! The word was: " + word.getWordText());
            return true;
        }
        return false;
    }

    private void removeLetterFromWord(char letter) {
        StringBuilder trimmedWord = new StringBuilder("");
        
        char[] newerWord = lines.toCharArray();
        
        for(int i = 0; i < wordTextDuplicate.length(); i++){
            char currentChar = wordTextDuplicate.charAt(i);
           
            if(currentChar == letter)
                newerWord[i] = letter;                
            else
                trimmedWord.append(currentChar);                
        }
        lines = String.valueOf(newerWord);
    }

    public void showStatus() {
        System.out.printf("Lives: %d %n", lives);
        for(int i = 0; i < lines.length(); i++){
            System.out.print(lines.charAt(i));
            System.out.print(" ");
        }
        System.out.println("");
    }
}
