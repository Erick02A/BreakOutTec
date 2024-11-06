package Player;

import Game.Brick;
import Game.Observable;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Player implements Observer,Observable
{
    protected final String name;
    protected int level;
    protected int lives;
    protected int score;
    protected Brick[][] brick;
    protected Paddle paddle;
    protected ArrayList<Ball> balls = new ArrayList<Ball>();
    private Observable observable;
    private Screen screen;

    public Player(String name, Observable observable, Brick[][] brick)
    {
        this.brick = brick;
        this.observable = observable;
        this.name = name;
        this.score = 0;
        this.lives = 2;
        this.level = 0;
        this.paddle = new Paddle();
        balls.add(new Ball());
        //System.out.println(this.brick[0][0].getColor());
        screen = new Screen(this);
        screen.start();

    }
    public void increaseScore(int points)
    {
        score += points;
    }
    public void decreaseLife()
    {
        lives -=1;
    }
    public void reset()
    {
        score = 0;
        lives = 3;
    }

    public String getName()
    {
        return name;
    }
    public int getScore()
    {
        return score;
    }
    public int getRemaningLives()
    {
        return lives;
    }
    @Override
    public void update()
    {

    }

    @Override
    public void addObserver(Observer observer)
    {

    }

    @Override
    public void deletObserver()
    {

    }

    @Override
    public void notifi()
    {

    }

}
