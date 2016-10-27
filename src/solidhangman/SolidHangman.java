package solidhangman;

import solidhangman.game.hangmen.Hangman;
import solidhangman.game.hangmen.ConsoleHangman;
import java.io.IOException;
import java.util.Scanner;
import solidhangman.game.exceptions.IncorrectPlayerSizeException;
import solidhangman.game.exceptions.NoWordsInFileException;


public class SolidHangman {

    public static void main(String[] args) throws IncorrectPlayerSizeException, NoWordsInFileException, IOException {
       Scanner scan = new Scanner(System.in);
       boolean continuePlaying;
      
       Hangman game = new ConsoleHangman();
      
       do {
           System.out.println("Welcome to Solid Hangman-Remix 2016!");
           System.out.print("Do you want to play? Y/N: ");
           continuePlaying = scan.next().toUpperCase().charAt(0) == 'Y';
           if(continuePlaying){
               game.init();
               game.play();
           }
       } while(continuePlaying);
    }
    
}
