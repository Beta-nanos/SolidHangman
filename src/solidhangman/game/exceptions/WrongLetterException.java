/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solidhangman.game.exceptions;

/**
 *
 * @author isaula
 */
public class WrongLetterException extends Exception {

    public WrongLetterException(char option) {
        super("Wrong input: "+option+". Expected a letter.");
    }
    
}
