package com.OSAGEIAMOS.Core;

import java.util.*;

public class ObjectManager {
    private List<GameObject> gameObjects = new LinkedList<>();

    public void addGameObject(GameObject go) {
        gameObjects.add(go);
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void removeGameObject(GameObject go) {
        gameObjects.remove(go);
    }

    public void removeAllGameObjects() {
        gameObjects.clear();
    }
}