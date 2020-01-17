package com.OSAGEIAMOS.Input;

import javafx.scene.input.KeyCode;

import java.util.HashMap;

public class Input {
    private final int NUM_OF_KEYCODES = KeyCode.values().length;
    HashMap<KeyCode, Boolean> KeyDown = new HashMap<>(NUM_OF_KEYCODES);
    HashMap<KeyCode, Boolean> KeyPressed = new HashMap<>(NUM_OF_KEYCODES);
    HashMap<KeyCode, Boolean> KeyUp = new HashMap<>(NUM_OF_KEYCODES);
}
