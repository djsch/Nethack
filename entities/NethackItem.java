package me.djsch.Nethack.entities;

// A NethackItem is anything that can be picked up and put in an inventory.

import me.djsch.Nethack.NethackGameState;

public abstract class NethackItem extends NethackEntity {
    protected enum bucStatus {
        BLESSED,
        UNCURSED,
        CURSED
    }

    protected bucStatus buc;
    protected boolean bucKnown;

    public NethackItem(NethackGameState state) {
        this(state, 0.05, 0.9, 0.05);
    }

    public NethackItem(NethackGameState state, double blessed, double uncursed, double cursed) {
        super(state);
        assert(blessed + uncursed + cursed == 1);
        double p = Math.random();
        if (p <= blessed) {
            this.buc = bucStatus.BLESSED;
        }
        else if (p <= blessed + uncursed) {
            this.buc = bucStatus.UNCURSED;
        }
        else {
            this.buc = bucStatus.CURSED;
        }
    }

    public bucStatus getBucStatus() {
        return buc;
    }

    public boolean isBucKnown() {
        return bucKnown;
    }

    public void setBucKnown(boolean known) {
        bucKnown = known;
    }

    public abstract String getDescription();
}