package com.example.tron;

import java.util.List;

public class GameRules {
    private List<Player> players;
    private Map map;
    private int gameSpeed;

    public GameRules(Map map, List<Player> players) {
        this.map = map;
        this.players = players;
    }

    void addPlayers() {
        players.add(new PlayerHuman(3, 2, "down", "wasd", 2, map));
        //humans.add(new PlayerHuman(10, 2, "down", "ijkl", 3, map));
        players.add(new PlayerAI(10, 14, 3, map));
    }

    void playerMovement() {
        for (Player player: players)
            player.behave();
    }

    int didSomeoneDie() {
        for (Player player: players)
            if (player.getState() == "dead")
                return player.getId();
        return 0;
    }

    public int getGameSpeed() {
        return gameSpeed;
    }

    public void setGameSpeed(int gameSpeed) {
        this.gameSpeed = gameSpeed;
    }
}
