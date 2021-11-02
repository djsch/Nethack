package me.djsch.Nethack.entities;

// A NethackEntity is anything that can exist and be displayed in the dungeon. This
// includes, for instance, a player character, a monster, an item, or a dungeon feature
// like a door or altar.

import me.djsch.Nethack.NethackGameState;

public abstract class NethackEntity {
    protected NethackGameState gameState;

    public NethackEntity(NethackGameState state) {
        gameState = state;
    }

    public abstract char getDisplayChar();

}