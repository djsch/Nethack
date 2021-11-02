package me.djsch.Nethack.UI;

import me.djsch.Nethack.NethackGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NethackKeyListener implements KeyListener  {
    //where initialization occurs:
    //typingArea = new JTextField(20);
    //typingArea.addKeyListener(this);

    //Uncomment this if you wish to turn off focus
    //traversal.  The focus subsystem consumes
    //focus traversal keys, such as Tab and Shift Tab.
    //If you uncomment the following line of code, this
    //disables focus traversal and the Tab events
    //become available to the key event listener.
    //typingArea.setFocusTraversalKeysEnabled(false);

    // Hold a reference to the game so that we can pass button presses to it.
    private NethackGame game;

    public NethackKeyListener(NethackGame nethackGame) {
        game = nethackGame;
    }

    /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
        //displayInfo(e, "KEY TYPED: ");
        //game.handleButtonPress(e.getKeyChar());
        game.handleButtonPress(e);
    }

    /** Handle the key-pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
        //displayInfo(e, "KEY PRESSED: ");
    }

    /** Handle the key-released event from the text field. */
    public void keyReleased(KeyEvent e) {
        //displayInfo(e, "KEY RELEASED: ");
        game.handleButtonPress(e);
    }

    private void displayInfo(KeyEvent e, String keyStatus){

        //You should only rely on the key char if the event
        //is a key typed event.
        int id = e.getID();
        String keyString;
        if (id == KeyEvent.KEY_TYPED) {
            char c = e.getKeyChar();
            keyString = "key character = '" + c + "'";
        } else {
            int keyCode = e.getKeyCode();
            keyString = "key code = " + keyCode
                    + " ("
                    + KeyEvent.getKeyText(keyCode)
                    + ")";
        }
        System.out.println("keyString is: " + keyString);

        int modifiersEx = e.getModifiersEx();
        String modString = "extended modifiers = " + modifiersEx;
        String tmpString = KeyEvent.getModifiersExText(modifiersEx);
        if (tmpString.length() > 0) {
            modString += " (" + tmpString + ")";
        } else {
            modString += " (no extended modifiers)";
        }
        System.out.println("modString is: " + modString);

        String actionString = "action key? ";
        if (e.isActionKey()) {
            actionString += "YES";
        } else {
            actionString += "NO";
        }
        System.out.println("actionString is: " + actionString);

        String locationString = "key location: ";
        int location = e.getKeyLocation();
        if (location == KeyEvent.KEY_LOCATION_STANDARD) {
            locationString += "standard";
        } else if (location == KeyEvent.KEY_LOCATION_LEFT) {
            locationString += "left";
        } else if (location == KeyEvent.KEY_LOCATION_RIGHT) {
            locationString += "right";
        } else if (location == KeyEvent.KEY_LOCATION_NUMPAD) {
            locationString += "numpad";
        } else { // (location == KeyEvent.KEY_LOCATION_UNKNOWN)
            locationString += "unknown";
        }
        System.out.println("locationString is: " + locationString);

        //Display information about the KeyEvent...
    }
}