package com.example.tron;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.util.List;

import javax.imageio.ImageIO;

public class WindowsRenderer {

    private static final int IMG_INITIAL_X_OFFSET_PX = 50;
    private static final int IMG_SIZE_PX = 20;

    private Map map;
    private GameRules rules;

    private BufferedImage wallImg;
    private BufferedImage carWallImg;
    private BufferedImage carWallDeadImg;

    public WindowsRenderer(Map map, GameRules rules) throws Exception {
        this.map = map;
        this.rules = rules;
        wallImg = ImageIO.read(new FileInputStream("wall.png"));
        carWallImg = ImageIO.read(new FileInputStream("carWall.png"));
        carWallDeadImg = ImageIO.read(new FileInputStream("carWallDead.png"));
    }

    public void paint(Graphics g) {
        for (int y=0; y<map.getHeight(); y++) {
            for (int x=0; x<map.getWidth(); x++) {
                int element = map.getElement(x, y);

                if (element == 1)
                    drawWall(g, x, y);
                else
                if (element != 1 && element != 0)
                    drawPlayerWall(g, x, y);
                else
                    drawSpace(g, x, y);
            }
        }
    }

    public void updatePlayer(Graphics g) {
        for (int y=0; y<map.getHeight(); y++) {
            for (int x=0; x<map.getWidth(); x++) {
                int element = map.getElement(x, y);
                if (element != 1 && element != 0)
                    drawPlayerWall(g, x, y);
            }
        }
    }

    public void endScreen(Graphics g) {
        for (int y=0; y<map.getHeight(); y++) {
            for (int x=0; x<map.getWidth(); x++) {
                int element = map.getElement(x, y);
                if (element == rules.didSomeoneDie())
                    drawPlayerWallDead(g, x, y);
            }
        }
    }

    private int calculateImgPos(int rawPos) {
        return IMG_INITIAL_X_OFFSET_PX + rawPos * IMG_SIZE_PX;
    }

    private void drawSpace(Graphics g, int x, int y) {}

    private void drawWall(Graphics g, int x, int y) {
        g.drawImage(wallImg, calculateImgPos(x), calculateImgPos(y), IMG_SIZE_PX, IMG_SIZE_PX, null);
    }

    private void drawPlayerWall(Graphics g, int x, int y) {
        g.drawImage(carWallImg, calculateImgPos(x), calculateImgPos(y), IMG_SIZE_PX, IMG_SIZE_PX, null);
    }

    private void drawPlayerWallDead(Graphics g, int x, int y) {
        g.drawImage(carWallDeadImg, calculateImgPos(x), calculateImgPos(y), IMG_SIZE_PX, IMG_SIZE_PX, null);
    }
}
