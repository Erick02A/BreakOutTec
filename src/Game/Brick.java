package Game;

import abstrac.product.antipoderes;
import abstrac.product.poderes;

import java.awt.*;

public class Brick
{
    private final int positionX;
    private final int positionY;
    private boolean destroy;
    private final Color color;
    private poderes poder;
    private antipoderes antipoder;

    public Brick(int positionX, int positionY, Color color,poderes poder,antipoderes antipoder)
    {
        this.positionX = positionX * 100 + positionX * 5;
        this.positionY = positionY * 20 + 100 + positionY * 5;
        this.color = color;
        this.destroy = false;
        this.antipoder = antipoder;
        this.poder = poder;
    }
    public void colition()
    {
        destroy = true;
    }
    public boolean isDestroy()
    {
        return destroy;
    }
    public int getPositionX()
    {
        return positionX;
    }
    public int getPositionY()
    {
        return positionY;
    }
    public Color getColor()
    {
        return color;
    }
    public poderes getPoder(){return poder;}
    public antipoderes getAntipoder(){return antipoder;}
    public String Poder()
    {
        return poder.type();
    }
    public String Antipoder()
    {
        return antipoder.type();
    }


}
