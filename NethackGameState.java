package me.djsch.Nethack;

import me.djsch.Nethack.entities.NethackPlayerCharacter;
import me.djsch.Nethack.map.NethackDungeon;
import me.djsch.Nethack.map.NethackFloor;

public class NethackGameState {
    public enum NethackDisplayState {
        NEUTRAL,
        INVENTORY,
        TYPING
    }

    public NethackDungeon dungeon;
    public NethackPlayerCharacter player;
    public NethackDisplayState state;
    private NethackIdentityManager idManager;

    public NethackGameState() {
        player = new NethackPlayerCharacter(this);
        dungeon = new NethackDungeon(this, player);
        state = NethackDisplayState.NEUTRAL;
        idManager = new NethackIdentityManager(this);
    }

    public int getPlayerRow() {
        return dungeon.getCurFloor().getPlayerRow();
    }

    public int getPlayerCol() {
        return dungeon.getCurFloor().getPlayerCol();
    }

    public NethackDungeon getDungeon() { return dungeon; }

    public NethackFloor getCurFloor() {
        return dungeon.getCurFloor();
    }

    public NethackPlayerCharacter getPlayer() {
        return player;
    }

    public void setDisplayState(NethackDisplayState state) {
        this.state = state;
    }

    public NethackDisplayState getDisplayState() {
        return this.state;
    }

    public NethackIdentityManager getIdManager() {
        return idManager;
    }

}