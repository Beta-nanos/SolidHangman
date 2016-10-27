package solidhangman;

import solidhangman.game.composers.Word;

class Match {
    private Player player;
    private Word word;
    private int vidas;
    private String wordTextDuplicate;
    
    public Match(){
        vidas = 6;
    }

    void setWord(Word _word) {
        word = _word;
        wordTextDuplicate = _word.getWordText();
    }

    void setPlayer(Player currentPlayer) {
        player = currentPlayer;
    }

    void inputValidation(char letter) {
        if(wordTextDuplicate.contains(String.valueOf(letter))){
            removeLetterFromWord(letter);
        }else{
            vidas--;
        }
    }

    boolean hasFinished() {
        if(vidas == 0){
            player.getStatistics().incrementMatchesLost();
            return true;
        }
        if(wordTextDuplicate.length() == 0){
            player.getStatistics().incrementMatchesWon();
            return true;
        }
        return false;
    }

    private void removeLetterFromWord(char letter) {
        StringBuilder sb = new StringBuilder(wordTextDuplicate);
        for(int i = 0; i < wordTextDuplicate.length(); i++){
            if(wordTextDuplicate.charAt(i) == letter)
                sb.deleteCharAt(i);
        }
        wordTextDuplicate = sb.toString();
    }
}
