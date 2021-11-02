package me.djsch.Nethack.UI;

import me.djsch.Nethack.NethackGameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

import static me.djsch.Nethack.NethackConstants.NUM_COLUMNS;
import static me.djsch.Nethack.NethackConstants.NUM_ROWS;

public class NethackWindow {

    private JLabel[][] labels;
    private JFrame frame;

    public NethackWindow(KeyListener listener) {
        labels = new JLabel[NUM_ROWS][NUM_COLUMNS];

        //1. Create the frame.
        frame = new JFrame("FrameDemo");

        //2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //3. Create components and put them in the frame.
        //JLabel[][] labels = new JLabel[NUM_ROWS][NUM_COLUMNS];
        JPanel panel = new JPanel(new GridLayout(NUM_ROWS, NUM_COLUMNS));
        for (int i = 0; i < labels.length; i++) {
            for (int j = 0; j < labels[i].length; j++) {
                labels[i][j] = new JLabel(".");
                labels[i][j].setFont(new Font(Font.MONOSPACED, 12, 12));
                //labels[i][j].setText();
                panel.add(labels[i][j]);
                //panel.add(new JLabel(String.valueOf(grid[i][j])));
            }
        }
        frame.getContentPane().add(panel, BorderLayout.CENTER);


        //4. Size the frame.
        frame.pack();

        //5. Show it.
        frame.setVisible(true);

        //6. Add KeyListener
        frame.addKeyListener(listener);

    }

    public void displayBoard(NethackGameState state) {
        NethackDisplayManager.display(state, labels);
        /*
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
        */

    }

    public static void createWindow() {

    }
}