package solidhangman;

import solidhangman.game.composers.Word;

class Match {
    private Player player;
    private Word word;
    private int lives;
    private String wordTextDuplicate;
    
    public Match(){
        lives = 6;
    }

    void setWord(Word _word) {
        word = _word;
        wordTextDuplicate = _word.getWordText().toUpperCase();
    }

    void setPlayer(Player currentPlayer) {
        player = currentPlayer;
    }

    void inputValidation(char letter) {
        if(wordTextDuplicate.contains(String.valueOf(letter))){
            removeLetterFromWord(letter);
        }else{
            lives--;
        }
    }

    boolean hasFinished() {
        if(lives == 0){
            player.getStatistics().incrementMatchesLost();
            System.out.println("Out of luck! You've lost this match! The word was: " + word.getWordText());
            return true;
        }
        if(wordTextDuplicate.length() == 0){
            player.getStatistics().incrementMatchesWon();
            System.out.println("You won this match! The word was: " + word.getWordText());
            return true;
        }
        return false;
    }

    private void removeLetterFromWord(char letter) {
        String newWord = "";
        for(int i = 0; i < wordTextDuplicate.length(); i++){
            if(wordTextDuplicate.charAt(i) != letter)
                newWord += wordTextDuplicate.charAt(i);
        }
        wordTextDuplicate = newWord;
    }
}
