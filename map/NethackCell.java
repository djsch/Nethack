package me.djsch.Nethack.map;

import me.djsch.Nethack.NethackGameState;
import me.djsch.Nethack.entities.NethackEntity;
import me.djsch.Nethack.entities.NethackPlayerCharacter;

import java.util.HashSet;

public class NethackCell {
    private NethackGameState gameState;

    private HashSet<NethackEntity> contents;

    public NethackCell(NethackGameState state) {
        gameState = state;

        contents = new HashSet<NethackEntity>();
    }

    public void add(NethackEntity entity) {
        contents.add(entity);
    }

    public void remove(NethackEntity entity) {
        assert contents.contains(entity);
        contents.remove(entity);
    }

    public HashSet<NethackEntity> getContents() {
        return contents;
    }

    public boolean containsPlayer () {
        for (NethackEntity entity : contents) {
            if (entity instanceof NethackPlayerCharacter) {
                return true;
            }
        }
        return false;
    }

    // Given the items this cell contains, return a char to be displayed in the UI.
    // TODO needs better name. 'getRepresentingSymbol'?
    public char getSymbol() {
        if (this.containsPlayer()) {
            return '@';
        }
        if (contents.iterator().hasNext()) {
            return contents.iterator().next().getDisplayChar();
        }
        return '.';
    }
}