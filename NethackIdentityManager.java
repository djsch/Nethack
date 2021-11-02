package me.djsch.Nethack;

import me.djsch.Nethack.entities.NethackItem;
import me.djsch.Nethack.entities.NethackPotion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class NethackIdentityManager {
    private NethackGameState gameState;

    // map from 'gain level' -> 'bubbly'
    private HashMap<String, String> potions;
    // map from 'gain level' -> true (if identified)
    private HashMap<String, Boolean> potionsId;

    private HashMap<String, String> scrolls;
    private HashMap<String, Boolean> scrollsId;

    public NethackIdentityManager(NethackGameState state) {
        gameState = state;

        potions = new HashMap<String, String>();
        potionsId = new HashMap<String, Boolean>();

        scrolls = new HashMap<String, String>();
        scrollsId = new HashMap<String, Boolean>();

        assign(NethackConstants.potionTypes, NethackConstants.potionAppearances, potions, potionsId);
        assign(NethackConstants.scrollTypes, NethackConstants.scrollAppearances, scrolls, scrollsId);

        /*
        for (String s : potions.keySet()) {
            System.out.println("map from " + s + " to " + potions.get(s));
        }
        for (String s : potionsId.keySet()) {
            System.out.println("map from " + s + " to " + potionsId.get(s));
        }
        */
    }

    private void assign(String[] types, String[] appearances, HashMap<String, String> assignments, HashMap<String, Boolean> ids) {
        // There must be at least enough appearances for however many types we have.
        assert(appearances.length >= types.length);

        ArrayList<String> typesShuffled = new ArrayList<String>(Arrays.asList(types));
        Collections.shuffle(typesShuffled);
        ArrayList<String> appearancesShuffled = new ArrayList<String>(Arrays.asList(appearances));
        Collections.shuffle(appearancesShuffled);

        for (int i = 0; i < typesShuffled.size(); i++) {
            assignments.put(typesShuffled.get(i), appearancesShuffled.get(i));
            ids.put(typesShuffled.get(i), false);
        }
    }

    public String getString(NethackItem item) {
        if (item instanceof NethackPotion) {
            String type = ((NethackPotion) item).getType();
            if (potionsId.get(type)) {
                return "potion of " + type;
            } else {
                return potions.get(type) + " potion";
            }
        }
        // TODO add the rest of the item types
        return "";
    }
}