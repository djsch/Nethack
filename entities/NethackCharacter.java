package me.djsch.Nethack.entities;

import me.djsch.Nethack.NethackGameState;

public class NethackCharacter extends NethackEntity {
    public NethackCharacter(NethackGameState state) {
        super(state);
    }

    @Override
    public char getDisplayChar() {
        return '@';
    }
}