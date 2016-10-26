package solidhangman;

import java.util.Scanner;


public class SolidHangman {

    public static void main(String[] args) {
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
