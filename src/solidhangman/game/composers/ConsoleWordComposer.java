package solidhangman.game.composers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import solidhangman.game.exceptions.NoWordsInFileException;
import solidhangman.game.exceptions.IncorrectPlayerSizeException;

public class ConsoleWordComposer implements WordComposer{
    private List<Word> words;
    private Word currentWord;
    private WORD_MODE wordMode;
            
    public ConsoleWordComposer(){
        words = new ArrayList<>();
        currentWord = null;
    }
    
    @Override
    public void setActivePlayers(int amountOfPlayers) throws IncorrectPlayerSizeException, NoWordsInFileException, FileNotFoundException, IOException, NoWordsInFileException{
        if(amountOfPlayers < 1 || amountOfPlayers > 2)
            throw new IncorrectPlayerSizeException(amountOfPlayers);
        
        switch(amountOfPlayers){
            case 1:
                getWordsFromFile();
                wordMode = WORD_MODE.FILE;
                break;
            case 2:
                wordMode = WORD_MODE.USER;
                break;
        }
    }

    @Override
    public Word getWord() {
        switch(wordMode){
            case FILE:
                int indexCurrentWord = words.indexOf(currentWord);  
                if(indexCurrentWord == words.size()-1)
                    return words.get(0);
                else
                    return words.get(indexCurrentWord + 1);
            case USER:
                return getWordFromUser();
            default:
                return null;
        }
    }

    private void getWordsFromFile() throws FileNotFoundException, IOException, NoWordsInFileException {
        File fil = new File("words.txt");
        System.out.println(fil.getAbsolutePath());
        FileReader file = new FileReader("words.txt");
        
        BufferedReader buffer = new BufferedReader(file);
        String word = null;
        while((word = buffer.readLine()) != null){
            words.add(new Word(word));
        }
        
        if(words.size() == 0)
            throw new NoWordsInFileException();
        
        currentWord = words.get(0);
    }    

    private Word getWordFromUser() {
        System.out.print("Insert word for the next player to guess: ");
        Scanner scan = new Scanner(System.in);
        
        return new Word(scan.next());
    }
}
