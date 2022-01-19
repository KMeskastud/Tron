package com.example.tron;

public class PlayerAI extends Player {

    @Override
    public void behave() {
        changeDirection();
        switch (direction) {
            case "left": x -= 1; break;
            case "right": x += 1; break;
            case "up": y -= 1; break;
            case "down": y += 1; break;
        }
        if(map.getElement(x, y) != 0)
            state = "dead";
        else
            map.drawOnMap(x, y, id);
    }

    public PlayerAI(int xStart, int yStart, int id, Map map) {
        super(xStart, yStart, "down", id, map);
        changeDirection();
    }

    private int rightDistance() {
        for (int i = x + 1; i <= map.getWidth(); i++)
            if (map.getElement(i, y) != 0)
                return i - x - 2; return 0;
    }

    private int leftDistance() {
        for (int i = x - 1; i >= 0; i--)
            if (map.getElement(i, y) != 0)
                return x - i; return 0;
    }

    private int downDistance() {
        for (int i = y + 1; i <= map.getHeight(); i++)
            if (map.getElement(x, i) != 0)
                return i - y; return 0;
    }

    private int upperDistance() {
        for (int i = y - 1; i >= 0; i--)
            if (map.getElement(x, i) != 0)
                return y - i; return 0;
    }

    private void changeDirection() {
        int dist = 0, currentDist = 0;
        String dir = direction;

        switch (direction){
            case "right" : currentDist = rightDistance(); break;
            case "left" : currentDist = leftDistance(); break;
            case "up" : currentDist = upperDistance(); break;
            case "down" : currentDist = downDistance(); break;
        }

        if(currentDist > 5)
            return;

        if (dist < rightDistance() && direction != "left") {
            dist = rightDistance();
            dir = "right";
        }
        if (dist < leftDistance() && direction != "right") {
            dist = leftDistance();
            dir = "left";
        }
        if (dist < upperDistance() && direction != "down") {
            dist = upperDistance();
            dir = "up";
        }
        if (dist < downDistance() && direction != "up") {
            dist = downDistance();
            dir = "down";
        }
        direction = dir;
    }
}
