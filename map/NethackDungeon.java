package me.djsch.Nethack.map;

import me.djsch.Nethack.NethackGameState;
import me.djsch.Nethack.entities.NethackPlayerCharacter;
import me.djsch.Nethack.entities.NethackPotion;

import java.util.ArrayList;

public class NethackDungeon {
    private NethackGameState gameState;

    private ArrayList<NethackFloor> floors;
    private NethackPlayerCharacter player;

    private int curFloor;

    public NethackDungeon(NethackGameState state, NethackPlayerCharacter player) {
        gameState = state;

        floors = new ArrayList<NethackFloor>(10);
        floors.add(new NethackFloor(gameState));
        floors.get(0).addEntity(player, 3, 4);
        floors.get(0).addEntity(new NethackPotion(gameState), 7, 8);
        floors.get(0).addEntity(new NethackPotion(gameState), 15, 2);

        curFloor = 0;
    }

    public NethackFloor getCurFloor() {
        return floors.get(curFloor);
    }
}