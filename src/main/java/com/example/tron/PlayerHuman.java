package com.example.tron;

public class PlayerHuman extends Player {
    private char up;
    private char down;
    private char left;
    private char right;

    public PlayerHuman(int xStart, int yStart, String direction, String controls, int id, Map map) {
        super(xStart, yStart, direction, id, map);
        this.up = controls.charAt(0);
        this.left = controls.charAt(1);
        this.down = controls.charAt(2);
        this.right = controls.charAt(3);
    }

    public void changeDirection(int n) {
        if (n == left && direction != "right")
            direction = "left";
        else if (n == right && direction != "left")
            direction = "right";
        else if (n == up && direction != "down")
            direction = "up";
        else if (n == down && direction != "up")
            direction = "down";
    }

    /* @Override
    public void behave() {
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
    }*/
}
