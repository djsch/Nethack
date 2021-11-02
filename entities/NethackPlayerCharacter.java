package me.djsch.Nethack.entities;

import me.djsch.Nethack.NethackGameState;

import java.util.*;

// The gamestate holds a reference to playercharacter, but the playercharacter
// lives inside the dungeon.

public class NethackPlayerCharacter extends NethackCharacter {

    private String role;
    private String alignment; // TODO enum?
    private String gender; // TODO enum? boolean?
    private int prayerTimeout;

    private HashMap<Character, NethackItem> inventory;
    private HashMap<NethackItem, Character> inventoryReverse;
    private LinkedList<Character> availableChars;

    public NethackPlayerCharacter(NethackGameState state) {
        super(state);

        inventory = new HashMap<Character, NethackItem>();
        inventoryReverse = new HashMap<NethackItem, Character>();

        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        availableChars = new LinkedList<Character>();
        for (Character c : alphabet.toCharArray()) {
            availableChars.add(c);
        }
    }

    public void addToInventory(NethackItem item) {
        char c = availableChars.poll();
        inventory.put(c, item);
        inventoryReverse.put(item, c);
    }

    public void removeFromInventory(NethackItem item) {
        assert(inventoryReverse.keySet().contains(item));
        char c = inventoryReverse.get(item);
        inventory.remove(c);
        inventoryReverse.remove(item);
        availableChars.add(c);
    }

    public HashMap<Character, NethackItem> getInventory() {
        return inventory;
    }
}