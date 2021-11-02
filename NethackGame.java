package me.djsch.Nethack;

import me.djsch.Nethack.UI.NethackKeyListener;
import me.djsch.Nethack.UI.NethackWindow;
import me.djsch.map.*;

import java.awt.event.KeyEvent;

public class NethackGame {
    private NethackWindow window;
    private NethackGameState state;
    private NethackController controller;

    public NethackGame() {
        //player = new NethackPlayerCharacter();
        //board = new NethackFloor(player);
        state = new NethackGameState();
        window = new NethackWindow(new NethackKeyListener(this));
        controller = new NethackController();
    }

    public void start() {
        window.displayBoard(state);
    }

    public void handleButtonPress(KeyEvent e) {
        //System.out.println("game got char: " + c);
        controller.getNextGameState(state, e);
        window.displayBoard(state);
    }
}