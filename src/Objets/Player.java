package Objets;

import java.util.ArrayList;

public class Player
{
    private String name;
    private int lives;
    private int points;
    private Block[][] blocks;
    private ArrayList<Ball> balls;
    private Paddle paddle;

    public Player(String name)
    {
        this.name = name;
        this.lives = 3;
        this.points = 0;
        this.balls = new ArrayList<Ball>();
        this.blocks = new Block[14][8];
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public int getLives()
    {
        return lives;
    }
    public void setLives(int lives)
    {
        this.lives = lives;
    }
    public int getPoints()
    {
        return points;
    }
    public void setPoints(int points)
    {
        this.points = points;
    }
    public Block[][] getBlocks()
    {
        return blocks;
    }
    public void addBlock(int position_x,int position_y)
    {
        blocks[position_x][position_y]=new Block(position_x,position_y);
    }
}
