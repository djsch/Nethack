package me.djsch.Nethack.UI;

import me.djsch.Nethack.NethackGameState;
import me.djsch.Nethack.entities.NethackItem;
import me.djsch.Nethack.map.NethackCell;
import me.djsch.Nethack.map.NethackFloor;
import me.djsch.Nethack.NethackGameState.NethackDisplayState;

import javax.swing.*;
import java.util.HashMap;

public class NethackDisplayManager {
    // Helper method to display a string, starting at labels[row][col] and proceeding
    // to the right.
    private static void displayString(JLabel[][] labels, String s, int row, int col) {
        for (char c : s.toCharArray()) {
            labels[row][col].setText(Character.toString(c));
            col++;
            // TODO need to go to new row eventually.....
        }
    }

    private static void displayFloor(NethackGameState state, JLabel[][] labels) {
        NethackFloor floor = state.getCurFloor();
        NethackCell[][] cells = floor.getCells();

        // TODO: think about error checking. should this throw error?
        assert cells.length == labels.length;
        assert cells[0].length == labels[0].length;

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                labels[i][j].setText(Character.toString(cells[i][j].getSymbol()));
            }
        }
    }

    private static void displayInventory(NethackGameState state, JLabel[][] labels) {
        int curRow = 0;
        HashMap<Character, NethackItem> inv = state.getPlayer().getInventory();
        for (Character c : inv.keySet()) {
            displayString(labels, c + " - " + inv.get(c).getDescription(), curRow, 0);
            curRow++;
        }
    }

    public static void display(NethackGameState state, JLabel[][] labels) {
        if (state.getDisplayState() == NethackDisplayState.NEUTRAL) {
            displayFloor(state, labels);
        }
        else if (state.getDisplayState() == NethackDisplayState.INVENTORY) {
            displayInventory(state, labels);
        }
    }
}