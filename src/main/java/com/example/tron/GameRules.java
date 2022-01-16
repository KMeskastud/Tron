package com.example.tron;

import java.util.List;

public class GameRules {
    private List<PlayerHuman> humans;
    private List<PlayerAI> bots;
    private Map map;

    public GameRules(Map map, List<PlayerHuman> humans, List<PlayerAI> bots) {
        this.map = map;
        this.humans = humans;
        this.bots = bots;
    }

    void addPlayers() {
        humans.add(new PlayerHuman(3, 2, "down", "wasd", 2, map));
        //humans.add(new PlayerHuman(10, 2, "down", "ijkl", 3, map));
        bots.add(new PlayerAI(10, 14, 3, map));
    }

    void playerMovement() {

        for (PlayerHuman human: humans)
            human.behave();
        for (PlayerAI bot: bots)
        {
            bot.behave();
        }
    }

    int didSomeoneDie()
    {
        for (PlayerHuman human: humans) {
            if(human.getState() == "dead")
                return human.getId();
        }
        for (PlayerAI bot: bots) {
            if(bot.getState() == "dead")
                return bot.getId();
        }
        return 0;
    }
}
