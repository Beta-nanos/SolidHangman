package solidhangman.game.composers;

public class Word {
    private String wordText;
    private int wordLength;
    
    public Word(String word) {
        this.wordText = word.toUpperCase();
        this.wordLength = word.length();
    }
  
    public String getWordText() {
        return wordText;
    }
    
    public int getWordLength() {
        return wordLength;
    }
    
    public int containsLetter(char letter){
        return this.wordText.indexOf(letter);
    }
}
