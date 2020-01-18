package com.OSAGEIAMOS.Input;

import javafx.scene.input.KeyCode;

import java.util.HashMap;

public class Input {
    static final int NUM_OF_KEYCODES = KeyCode.values().length;
    static final HashMap<KeyCode, Boolean> KeyPressed = new HashMap<>(NUM_OF_KEYCODES);
    static final HashMap<KeyCode, Boolean> KeyTyped = new HashMap<>(NUM_OF_KEYCODES);
    static final HashMap<KeyCode, Boolean> KeyUp = new HashMap<>(NUM_OF_KEYCODES);

    static {
        //Get all the values from the KeyCode enum
        KeyCode[] vals = KeyCode.values();

        //Populate the hashmaps with the keys and seed their values as false
        for (KeyCode k : vals) {
            KeyPressed.put(k, false);
            KeyUp.put(k, false);
            KeyTyped.put(k, false);
        }
        //Log if initilization is successful, TODO: Change to logger instead
        System.out.println("Maps initialised: " + (KeyUp.size() == NUM_OF_KEYCODES && KeyTyped.size() == NUM_OF_KEYCODES && KeyPressed.size() == NUM_OF_KEYCODES));
    }

    //Set methods for each map
    public void SetKeyPressed(KeyCode kc) {
        KeyPressed.replace(kc, true);
    }
    public void SetKeyTyped(KeyCode kc) {
        KeyTyped.replace(kc, true);
    }
    public void SetKeyUp(KeyCode kc) {
        KeyUp.replace(kc, true);
    }

    //Get method for each map
    public Boolean getKeyPressed(KeyCode key) { return KeyPressed.get(key); }
    public Boolean getKeyTyped(KeyCode key) { return KeyTyped.get(key); }
    public Boolean getKeyUp(KeyCode key) { return KeyUp.get(key); }

    //TODO: Add method to reset maps for the beginning of a game loop
}