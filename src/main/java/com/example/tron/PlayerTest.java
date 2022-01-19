package com.example.tron;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void PlayerHuman_StepOnUsedTile_IsDead() {
        Map map = new Map();
        PlayerHuman pl = new PlayerHuman(1, 1, "left", "xxxx", 2, map);

        pl.behave();

        assertEquals("dead", pl.getState());
    }

    @Test
    void PlayerHuman_StepOnFreeTile_IsAlive() {
        Map map = new Map();
        PlayerHuman pl = new PlayerHuman(1, 1, "right", "xxxx", 2, map);

        pl.behave();

        assertEquals("alive", pl.getState());
    }

    @Test
    void PlayerHuman_StepOnUsedTile_NotPossible() {
        Map map = new Map();
        map.drawOnMap(1, 2, 3);
        PlayerHuman pl = new PlayerHuman(1, 1, "right", "xxxx", 2, map);

        pl.behave();

        assertEquals(3, map.getElement(1, 2));
    }

    @Test
    void PlayerHuman_StepOnFreeTile_Possible() {
        Map map = new Map();
        PlayerHuman pl = new PlayerHuman(1, 1, "right", "xxxx", 2, map);

        pl.behave();

        assertEquals(2, map.getElement(2, 1));
    }
}