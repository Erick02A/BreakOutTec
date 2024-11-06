package Player;

public class Ball
{
    private int positionX;
    private int positionY;
    private int speedX;
    private int speedY;

    public Ball()
    {
        this.positionY = 350;
        this.positionX = 500;
        this.speedX = -5;
        this.speedY = 5;
    }
    public void move()
    {
        positionX += speedX;
        positionY += speedY;
    }
    public void changeSpeed(boolean b)
    {
        if (b){
            this.speedX /=2;
            this.speedY /=2;
        }else {
            this.speedX *=2;
            this.speedY *=2;
        }

    }
    public void reset()
    {
        this.positionY = 350;
        this.positionX = 500;
    }
    public void bounce(boolean changeY, boolean changeX)
    {
        if (changeY)
        {
            speedY *= -1;
        }
        if (changeX)
        {
            speedX *= -1;
        }
    }
    public int getPositionX()
    {
        return positionX;
    }
    public int getPositionY()
    {
        return positionY;
    }
}
