package me.djsch.Nethack.entities;

import me.djsch.Nethack.NethackConstants;
import me.djsch.Nethack.NethackGameState;

public class NethackPotion extends NethackItem {
    private String type = "";

    public NethackPotion(NethackGameState state) {
        super(state);

        // TODO this should absolutely be in some generic item generation somewhere else
        String[] potions = NethackConstants.potionTypes;
        int rand = (int)(Math.random() * potions.length);
        type = potions[rand];
    }

    // TODO This should be in NethackItem
    // TODO maybe make scrolls next just so i have to compartmentalize correctly
    public String getType() {
        return type;
    }

    @Override
    public char getDisplayChar() {
        return '!';
    }

    // TODO this should probably be in NethackItem
    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        switch (this.buc) {
            case BLESSED:
                sb.append("a blessed");
                break;
            case UNCURSED:
                sb.append("an uncursed");
                break;
            case CURSED:
                sb.append("a cursed");
                break;
        }
        sb.append(" ");

        // TODO how do we access the IdentityManager??
        sb.append(gameState.getIdManager().getString(this));

        return sb.toString();
    }
}