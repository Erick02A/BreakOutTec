package Player;

public class Paddle
{
    protected int position;
    protected int size;
    private int speed;
    public Paddle()
    {
        this.position = 250;
        this.size = 50;
        this.speed = 5;
    }
    public void moveLeft()
    {
        position += speed;
    }
    public void moveRight()
    {
        position -= speed;
    }
    public void changeSize(float mult)
    {
        if (mult == 0.5)
        {
            if (size != 50)
            {
                size *= mult;
            }
        }
        else
        {
            size *= mult;
        }
    }
}
