package com.example.tron;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class WindowsMain  extends JFrame implements KeyListener{
    private static final long serialVersionUID = 1L;
    private List<PlayerHuman> humans = new ArrayList<>();
    private List<PlayerAI> bots = new ArrayList<>();
    private Map map = new Map();
    private GameRules rules = new GameRules(map, humans, bots);
    private WindowsRenderer renderer = new WindowsRenderer(map, rules);
    private String state = "nothing";

    public WindowsMain() throws Exception {
        super.setPreferredSize(new Dimension(1200, 600));
        super.pack();
        super.setVisible(true);
        super.addKeyListener(this);
        super.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }});
        initGame();
    }

    void initGame()
    {
        Thread game = new Thread("New Thread") {
            public void run(){
                state = "starting";
                rules.addPlayers();
                repaint();
                try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
                state = "running";
                while (state == "running")
                {
                    repaint();
                    rules.playerMovement();

                    if(rules.didSomeoneDie() != 0)
                        state = "over";
                    try {
                        Thread.sleep(50);//reik pridet kintama gamespeed
                    } catch (InterruptedException e) {e.printStackTrace();}
                }
                repaint();
            }
        };
        game.start();
    }

    @Override
    public void paint(Graphics g) {
        if(state == "starting")
        {
            super.paint(g);
            renderer.paint(g);
        }
        if(state == "running")
        {
            renderer.updatePlayer(g);
        }
        if(state == "over")
        {
            renderer.endScreen(g);
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int userCommand = e.getKeyChar();

        for (PlayerHuman human: humans) {
            human.changeDirection(userCommand);
        }
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                try {
                    new WindowsMain();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
}

