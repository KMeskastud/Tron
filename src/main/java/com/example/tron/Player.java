package com.example.tron;

public abstract class Player
{
    protected int x;
    protected int y;
    protected int id;
    protected String direction;
    protected String state;
    protected Map map;

    public Player(int xStart, int yStart, String direction, int id, Map map) {
        this.x = xStart;
        this.y = yStart;
        this.id = id;
        this.direction = direction;
        this.state = "alive";
        this.map = map;
        map.drawOnMap(xStart, yStart, id);
    }

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
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public String getDirection() {
        return direction;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

