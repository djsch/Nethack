package me.djsch.Nethack.map;

import me.djsch.Nethack.NethackGameState;
import me.djsch.Nethack.entities.NethackEntity;
import me.djsch.Nethack.entities.NethackPlayerCharacter;

import static me.djsch.Nethack.NethackConstants.NUM_COLUMNS;
import static me.djsch.Nethack.NethackConstants.NUM_ROWS;

public class NethackFloor {
    private NethackGameState gameState;

    private NethackCell[][] cells;

    // These vars are NOT the source of truth for player location. We verify
    // that the player is located in the correct cell when resolving calls
    // to getPlayerRow and getPlayerCol.
    int playerRow;
    int playerCol;

    public NethackFloor(NethackGameState state) {
        gameState = state;

        cells = new NethackCell[NUM_ROWS][NUM_COLUMNS];

        playerRow = 0;
        playerCol = 0;

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new NethackCell(gameState);
            }
        }

        // for testing
        //addEntity(player, player.getRow(), player.getCol());
        //cells[3][4].add(player);
        //player.moveTo(3, 4);
        //cells[1][8].add(new NethackPotion());
    }

    public void removeEntity(NethackEntity entity, int row, int col) {
        cells[row][col].remove(entity);
    }

    public void addEntity(NethackEntity entity, int row, int col) {
        if (entity instanceof NethackPlayerCharacter) {
            playerRow = row;
            playerCol = col;
        }
        cells[row][col].add(entity);
    }

    public int getPlayerRow() {
        assert cells[playerRow][playerCol].containsPlayer();
        return playerRow;
    }

    public int getPlayerCol() {
        System.out.println("playerRow is : " + playerRow);
        System.out.println("playerCol is : " + playerCol);
        assert cells[playerRow][playerCol].containsPlayer();
        return playerCol;
    }

    public NethackCell[][] getCells() {
        return cells;
    }
}