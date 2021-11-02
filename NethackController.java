package me.djsch.Nethack;

import me.djsch.Nethack.entities.NethackEntity;
import me.djsch.Nethack.entities.NethackItem;
import me.djsch.Nethack.entities.NethackPlayerCharacter;
import me.djsch.Nethack.map.NethackCell;
import me.djsch.Nethack.map.NethackFloor;

import java.awt.event.KeyEvent;
import java.util.HashSet;

// This class's primary function is to take a NethackGameState and a key press, and
// return a new NethackGameState that represents the state of the game after registering
// that button press.
public class NethackController {
    public NethackController() {

    }

    private static void getNextGameStateNeutral(NethackGameState curState, KeyEvent e) {
        NethackFloor floor = curState.getCurFloor();
        NethackPlayerCharacter player = curState.getPlayer();
        int playerRow = curState.getPlayerRow();
        int playerCol = curState.getPlayerCol();
        if (e.getID() == KeyEvent.KEY_TYPED) {
            switch (e.getKeyChar()) {
                case 'i':
                    curState.setDisplayState(NethackGameState.NethackDisplayState.INVENTORY);
                    break;
                case ',':
                    NethackCell cell = floor.getCells()[playerRow][playerCol];
                    HashSet<NethackEntity> items = cell.getContents();
                    HashSet<NethackItem> itemsToRemove = new HashSet<NethackItem>();
                    for (NethackEntity entity : items) {
                        if (entity instanceof NethackItem) {
                            itemsToRemove.add((NethackItem) entity);
                            player.addToInventory((NethackItem) entity);
                        }
                    }
                    for (NethackItem item : itemsToRemove) {
                        cell.remove(item);
                    }
                    break;
            }
        }
        else if (e.getID() == KeyEvent.KEY_RELEASED) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    floor.removeEntity(player, playerRow, playerCol);
                    floor.addEntity(player, playerRow - 1, playerCol);
                    break;
                case KeyEvent.VK_LEFT:
                    floor.removeEntity(player, playerRow, playerCol);
                    floor.addEntity(player, playerRow, playerCol - 1);
                    break;
                case KeyEvent.VK_DOWN:
                    floor.removeEntity(player, playerRow, playerCol);
                    floor.addEntity(player, playerRow + 1, playerCol);
                    break;
                case KeyEvent.VK_RIGHT:
                    floor.removeEntity(player, playerRow, playerCol);
                    floor.addEntity(player, playerRow, playerCol + 1);
                    break;
                case KeyEvent.VK_ENTER:
                    curState.setDisplayState(NethackGameState.NethackDisplayState.NEUTRAL);
                    break;
            }
        }
        else {
            System.out.println("ERROR: invalid key press event.");
        }
    }

    private static void getNextGameStateInventory(NethackGameState curState, KeyEvent e) {
        NethackFloor floor = curState.getCurFloor();
        NethackPlayerCharacter player = curState.getPlayer();
        int playerRow = curState.getPlayerRow();
        int playerCol = curState.getPlayerCol();
        if (e.getID() == KeyEvent.KEY_TYPED) {
            switch (e.getKeyChar()) {

            }
        }
        else if (e.getID() == KeyEvent.KEY_RELEASED) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_ENTER:
                    curState.setDisplayState(NethackGameState.NethackDisplayState.NEUTRAL);
                    break;
            }
        }
        else {
            System.out.println("ERROR: invalid key press event.");
        }
    }

    public static void getNextGameState(NethackGameState curState, KeyEvent e) {
        switch (curState.getDisplayState()) {
            case INVENTORY:
                getNextGameStateInventory(curState, e);
                break;
            case NEUTRAL:
                getNextGameStateNeutral(curState, e);
                break;
        }
    }
}